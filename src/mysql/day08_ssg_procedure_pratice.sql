use ssgdb;
-- 스토어드 함수를 사용하기 위해 생성권한을 허용해야 함
SET GLOBAL log_bin_trust_function_creators = 1;


DROP FUNCTION IF EXISTS userFunc;

DELIMITER $$
CREATE FUNCTION userFunc(value1 INT, value2 INT)
    RETURNS INT
BEGIN
    RETURN value1 + value2;
END $$
DELIMITER ;

SELECT userFunc(100, 200);

DROP FUNCTION IF EXISTS getAgeFunc;
DELIMITER $$
CREATE FUNCTION getAgeFunc(bYear INT)
    RETURNS INT
BEGIN
    DECLARE age INT;
    SET age = YEAR(CURDATE()) - bYear;
    RETURN age;
END $$
DELIMITER ;

-- 함수의 반환값을 SELECT - INTO - 로 저장했다가 사용 가능
SELECT getAgeFunc(1979) INTO @age1979;
SELECT getAgeFunc(1997) INTO @age1997;
SELECT CONCAT('1997년과 1979년의 나이차 --> ',(@age1979 - @age1997));

-- 현재 저장된 스토어드 함수의 이름 및 내용 확인
SHOW CREATE FUNCTION getAgeFunc;
-- 스토어드 함수 삭제
DROP FUNCTION getAgeFunc;


-- 커서
-- 05. 심화 (32p)
-- 커서를 이용해 고객의 평균 키 구하는 스토어드 프로시저
DROP PROCEDURE IF EXISTS cursorProc;
DELIMITER $$
CREATE PROCEDURE cursorProc()
BEGIN
    DECLARE userHeight INT; -- 고객의 키
    DECLARE cnt INT DEFAULT 0; -- 고객의 인원 수(=읽은 행의 수)
    DECLARE totalHeight INT DEFAULT 0; -- 키의 합계

    DECLARE endofRow BOOLEAN DEFAULT FALSE; -- 행의 끝 여부 (기본 FALSE)

    DECLARE userCursor CURSOR FOR -- 커서 선언
        SELECT height FROM usertbl;

    DECLARE CONTINUE HANDLER -- 행의 끝이면 endofRow 변수에 TRUE 대입
        FOR NOT FOUND SET endofRow = TRUE;

    OPEN userCursor;

    cursor_loop: LOOP
        FETCH userCursor INTO userHeight; -- 고객 키 1개를 대입

        IF endofRow THEN
            LEAVE cursor_loop; -- 더이상 읽을 행이 없으면 LOOP 종료
        END IF;

        SET cnt = cnt + 1;
        SET totalHeight = totalHeight + userHeight;
    END LOOP cursor_loop;

    -- 고객 키의 평균을 출력
    SELECT CONCAT('고객 키의 평균 --> ',(totalHeight/cnt));

    CLOSE userCursor; -- 커서 닫기
END $$
DELIMITER ;

CALL cursorProc();

-- 트리거 실습
use ssgdb;
CREATE TABLE IF NOT EXISTS testTBL(id int, txt varchar(20));
insert into testTBL values (1,'레드벨벳'),(2,'잇지'),(3,'블랙핑크');

DROP TRIGGER IF EXISTS testTrg;

DELIMITER //
CREATE TRIGGER testTrg -- 트리거 이름
    AFTER DELETE -- 삭제 후에 작동하도록 지정
    ON testTBL -- 트리거를 부착한 테이블
    FOR EACH ROW -- 각 행마다 적용
BEGIN
   SET @msg = '가수 그룹이 삭제됨'; -- 트리거 실행 시 작동되는 코드
END //
DELIMITER ;

SET @msg = '';
INSERT INTO testTBL VALUES (4,'마마무');
SELECT @msg;
UPDATE testTBL SET txt = '블핑' WHERE id = 3;
SELECT @msg;
DELETE FROM testTBL WHERE id = 4;
SELECT @msg;

CREATE TABLE backup_userTbl
(
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NOT NULL ,
    birthYear INT NOT NULL ,
    addr CHAR(2) NOT NULL ,
    mobile1 CHAR(3),
    mobile2 CHAR(8),
    height SMALLINT,
    mDate DATE,
    modType CHAR(2),
    modDate DATE,
    modUser VARCHAR(256)
);

DROP TRIGGER IF EXISTS backUserTbl_UpdateTrg;
DELIMITER //
CREATE TRIGGER backUserTbl_UpdateTrg
    AFTER UPDATE
    ON usertbl
    FOR EACH ROW
BEGIN
    INSERT INTO backup_userTbl VALUES (OLD.userID, OLD.name, OLD.birthYear,
                                      OLD.addr, OLD.mobile1, OLD.mobile2,
                                       OLD.height, OLD.mDate, '수정',
                                       CURDATE(), CURRENT_USER());
end //
DELIMITER ;

DROP TRIGGER IF EXISTS backUserTbl_DeleteTrg;
DELIMITER //
CREATE TRIGGER backUserTbl_DeleteTrg
    AFTER DELETE
    ON usertbl
    FOR EACH ROW
BEGIN
    INSERT INTO backup_userTbl VALUES (OLD.userID, OLD.name, OLD.birthYear,
                                       OLD.addr, OLD.mobile1, OLD.mobile2,
                                       OLD.height, OLD.mDate, '삭제',
                                       CURDATE(), CURRENT_USER());
end //
DELIMITER ;

UPDATE usertbl SET addr = '몽고' WHERE userID = 'JKW';
DELETE FROM usertbl WHERE height >= 177;

TRUNCATE TABLE usertbl;
SELECT * FROM backup_userTbl;

DROP TRIGGER IF EXISTS userTbl_InsertTrg;
DELIMITER //
CREATE TRIGGER userTbl_InsertTrg
    AFTER INSERT
    ON usertbl
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = '데이터의 입력을 시도했습니다. 귀하의 정보가 서버에 기록되었습니다.';
end //
DELIMITER ;

INSERT INTO usertbl VALUES ('ABC','에비씨',1977,'서울','011','11111111',181,'2019-12-25');

DROP TRIGGER IF EXISTS userTbl_BeforeInsertTrg;
DELIMITER //
CREATE TRIGGER userTbl_BeforeInsertTrg
    BEFORE INSERT
    ON usertbl
    FOR EACH ROW
BEGIN
    IF NEW.birthYear < 1900 THEN
        SET NEW.birthYear = 0;
    ELSEIF NEW.birthYear > YEAR(CURDATE()) THEN
        SET NEW.birthYear = YEAR(CURDATE());
        END IF;
end //
DELIMITER ;

INSERT INTO userTbl VALUES ('AAA','에이',1877,'서울','011','11112222',181,'2022-12-25');
INSERT INTO userTbl VALUES ('BBB','비이',2977,'경기','011','11113333',171,'2019-3-25');
SELECT * FROM usertbl;