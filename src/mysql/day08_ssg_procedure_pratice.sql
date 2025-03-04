use ssgdb;
CREATE TABLE usertbl -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);

CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
commit;

SELECT * FROM usertbl;
SELECT * FROM buytbl;


-- 1.1 userTbl테이블을 대상으로 1개의 이름을 입력하여 해당 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요
-- '조관우' 회원의 정보를 출력하세요
DELIMITER $$
CREATE PROCEDURE test_find(name_find varchar(10))
BEGIN
    SELECT * FROM usertbl WHERE name = name_find;
END $$
DELIMITER ;

CALL test_find('조관우');

-- 1.2 userTbl 테이블  : 회원중 출생년도가 1970 이후 출생자이면서 키가 178 초과 인 회원의 정보를 출력하는 프로시저를 작성하고 실행시키세요
DELIMITER $$
CREATE PROCEDURE test_find2(year_find int, height_find smallint)
BEGIN
    SELECT * FROM usertbl WHERE birthYear > year_find AND height > height_find;
end $$
DELIMITER ;

CALL test_find2(1970,178);

-- 1.3 usertbl 테이블 :  1980년 이후 출생자에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다." 1980년 이전 출생자들에게는 "고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다." 출력하는 프로시저 작성
DROP PROCEDURE IF EXISTS ifelseProc;
DELIMITER $$
CREATE PROCEDURE ifelseProc(IN username VARCHAR(20))
BEGIN
    DECLARE bYear INt;
    SELECT birthYear INTO bYear FROM usertbl WHERE name = username;

    IF (bYear >= 1980) THEN SELECT '고객님 건강보험 생애 전환 서비스 가입에 해당하지 않습니다.';
    ELSE SELECT '고객님 건강보험 생애 전환 서비스 가입에 해당하오니 가입해 주시길 바랍니다.';
    END IF;
    END $$
DELIMITER ;
CALL ifelseProc('은지원');

-- 1.4 while문을 활용하여 구구단을 문자열로 생성해서 테이블에 입력하는 프로시저를 작성해 보자
DROP TABLE IF EXISTS guguTBL;
CREATE TABLE guguTBl(txt VARCHAR(100)); -- 구구단 저장용 테이블

DROP PROCEDURE IF EXISTS whileProcgugu;
DELIMITER $$
CREATE PROCEDURE whileProcgugu()
BEGIN
    DECLARE i int; -- 구구단 앞자리
    DECLARE j int; -- 구구단 뒷자리
    DECLARE str varchar(100); -- 결과값

    SET i = 2;

    WHILE (i < 10) -- 2단 부터 9단까지
        DO
            SET str = '';
            SET j = 1; -- 구구단 뒤 숫자 2 * 1 ~ 9까지
            WHILE(j < 10)
                DO
                    SET str = CONCAT(str,' ',i,' x ',j,' = ', i*j); -- 결과물 출력
                    SET j = j + 1;
                END WHILE ;
            SET i = i + 1;
            INSERT INTO guguTBl VALUES (str);
    END WHILE;
END $$
DELIMITER ;

Call whileProcgugu();
SELECT * FROM guguTBl;

-- 1. 4-1 1부터 100까지 합계를 구하는 totalSum 프로시저 작성해 보세요. 출력 포맷은 '1-100의 총합은 5050 입니다.'
DROP PROCEDURE IF EXISTS totalSum;
DELIMITER $$
CREATE PROCEDURE totalSum(i int, j int)
BEGIN
    DECLARE sum INT;
    DECLARE start INT;
    DECLARE str VARCHAR(100);

    SET sum = 0;
    SET start = i;

    WHILE (i <= j)
        DO
            SET sum = sum + i;
            SET i = i + 1;
        end while ;

    SET str = CONCAT(start,'-',j,'의 총합은 ',sum,' 입니다.');
    SELECT str;
END $$
DELIMITER ;

CALL totalSum(1,100);

-- 1.5 DECARE~ HANDLER 를 이용해서 오류처리 구문을 추가해 보자 . ex) 1부터 숫자를 더하여 합계가 정수형(int)데이터 형식의 오버플로우가 발생하면 멈추고 오류처리를 해보자
DROP PROCEDURE IF EXISTS totalSum;
DELIMITER $$
CREATE PROCEDURE totalSum()
BEGIN
    DECLARE i INT; -- 1씩 증가하는 값
    DECLARE result INT; -- 합계(정수형), 오버플로우 발생시킬 예정
    DECLARE savepointResult Int; -- 오버플로 직전의 값 저장

    DECLARE EXIT HANDLER FOR 1264 -- INT형 오버플로우가 발생하면 해당 부분 수행
    BEGIN
        SELECT CONCAT('INT 오버플로우 직전의 합계 --> ',savepointResult);
        SELECT CONCAT('1+2+3+ ... + ', i, ' = 오버플로우');
    END ;

    SET i = 1; -- i를 1로 초기화
    SET result = 0; -- 합계 0으로 초기화

    WHILE (TRUE) -- 무한루프
        DO
            SET savepointResult = result; -- 오버플로우 직전의 합을 저장하기 위해
            SET result = result + i;
            SET i = i + 1;
        END WHILE ;

END $$
DELIMITER ;

CALL totalSum();

-- 1.6 현재 저장된 프로시저의 이름과 내용을 확인해 보자
use information_schema;
SELECT ROUTINE_NAME, ROUTINE_DEFINITION FROM information_schema.ROUTINES
WHERE ROUTINE_SCHEMA = 'ssgdb' AND ROUTINE_TYPE = 'PROCEDURE';

-- 1.7 파라미터도 확인해 보자
SELECT PARAMETER_MODE, PARAMETER_NAME, DTD_IDENTIFIER FROM information_schema.PARAMETERS
WHERE SPECIFIC_NAME = 'ifelseProc';

-- 1.8 테이블 이름을 파라미터로 전달해 보자
use ssgdb;
DROP PROCEDURE IF EXISTS nameTblProc;

# DELIMITER $$
# CREATE PROCEDURE nameTblProc(IN tblname VARCHAR(20))
# BEGIN
#     SELECT * FROM tblname;
# END $$
# DELIMITER ;

-- CALL nameTblProc('usertbl'); -- MySQL은 직접 테이블 이름을 파라미터로 사용할 수 없다.

DELIMITER $$
CREATE PROCEDURE nameTblProc(IN tblname VARCHAR(20))
BEGIN
    SET @sqlQuery = CONCAT('SELECT * FROM ',tblname);

    PREPARE myQuery FROM @sqlQuery;
    EXECUTE myQuery;
    DEALLOCATE PREPARE myQuery;
END $$
DELIMITER ;

CALL nameTblProc('usertbl');

-- 1.9 배송담당자는 사용자의 정보를 접근할 수 있는 프로시저(delivProc)를 이용하여 사용자의 주소와 이름을 확인한다.
-- userid, name, addr, mobile1, mobile2 만 접근해서 사용자의 정보를 조회할 수 있는 delivProc 작성하세요
-- 배송담당자는 사용자의 uesrid로 회원의 정보를 접근할 수 있다.
DROP PROCEDURE IF EXISTS delivProc;

DELIMITER $$
CREATE PROCEDURE delivProc(id char(8))
BEGIN
    SELECT userID, name, addr, mobile1, mobile2 FROM usertbl WHERE userID = id;
END $$
DELIMITER ;

CALL delivProc('BBK');