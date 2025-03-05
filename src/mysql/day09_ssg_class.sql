-- 샘플 테이블 생성
use ssgdb;
CREATE TABLE CODE1(cId int, cName VARCHAR(20));
SELECT * FROM CODE1;

INSERT INTO CODE1 VALUES (1,'프론트 디자이너');
DROP PROCEDURE p_insertcodes;

DELIMITER $$
CREATE PROCEDURE p_insertcodes(IN cData VARCHAR(225), IN cTName VARCHAR(255))
BEGIN
    -- 쿼리문 생성
    SET @strsql = CONCAT(
                    'INSERT INTO ', cTName,' (cId , cName) ', ' SELECT COALESCE(MAX(cId),0) + 1 , ? FROM ', cTName
                  );
    -- 바인딩 할 변수 설정
    SET @cData = cData;
#     SET @resultMsg = 'Insert Success';

    PREPARE stmt FROM @strsql;
    EXECUTE stmt USING @cData;
    DEALLOCATE PREPARE stmt;

    -- 트렌젝션 확정
    COMMIT ;
END $$
DELIMITER ;

CALL p_insertcodes('백엔드 자바 개발자','CODE1');

SELECT * FROM CODE1;
