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

DELIMITER $$
CREATE PROCEDURE p_insertresultcodes(IN cData VARCHAR(225), IN cTName VARCHAR(255), OUT resultMsg VARCHAR(255))
BEGIN
    -- 쿼리문 생성
    SET @strsql = CONCAT(
            'INSERT INTO ', cTName,' (cId , cName) ', ' SELECT COALESCE(MAX(cId),0) + 1 , ? FROM ', cTName
                  );
    -- 바인딩 할 변수 설정
    SET @cData = cData;
    SET resultMsg = 'Insert Success';

    PREPARE stmt FROM @strsql;
    EXECUTE stmt USING @cData;
    EXECUTE stmt USING @resultMsg;
    DEALLOCATE PREPARE stmt;

    -- 트렌젝션 확정
    COMMIT ;
END $$
DELIMITER ;

select * from code1;

CREATE TABLE TB_MEMBER (
                           m_seq INT AUTO_INCREMENT PRIMARY KEY,  -- 자동 증가 시퀀스
                           m_userid VARCHAR(20) NOT NULL,
                           m_pwd VARCHAR(20) NOT NULL,
                           m_email VARCHAR(50) NULL,
                           m_hp VARCHAR(20) NULL,
                           m_registdate DATETIME DEFAULT NOW(),  -- 기본값: 현재 날짜와 시간
                           m_point INT DEFAULT 0
);

-- TB_MEMBER 테이블에 callableStmtEx03 클래스 작성하여서 sp_MEMBER_INSERT 프로시저 생성
-- 회원을 입력하도록 작성, "회원 정보가 안전하게 저장되었습니다." 메세지 출력
DROP PROCEDURE sp_MEMBER_INSERT;
DELIMITER $$
CREATE PROCEDURE sp_MEMBER_INSERT(IN m_userid VARCHAR(255), IN m_pwd VARCHAR(255), IN m_email VARCHAR(255), IN m_hp VARCHAR(255),IN m_point INT,
                                  IN cTName VARCHAR(255), OUT resultMsg VARCHAR(255))
BEGIN
    SET @sql = CONCAT(
            'INSERT INTO ', cTName,' (m_userid, m_pwd, m_email, m_hp,m_point) ',
               'VALUES (?,?,?,?,?)'
               );
    SET @m_userid = m_userid;
    SET @m_pwd = m_pwd;
    SET @m_email = m_email;
    SET @m_hp = m_hp;
    SET @m_point = m_point;
    SET resultMsg = '회원 정보가 안전하게 저장되었습니다.';

    PREPARE stmt FROM @sql;
    EXECUTE stmt USING @m_userid, @m_pwd, @m_email, @m_hp, @m_point;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;

select * from TB_MEMBER;

use ssgdb;
DROP TABLE tb_product;
CREATE TABLE tb_product(
    prodCode CHAR(3) NOT NULL ,
    prodId CHAR(4) NOT NULL ,
    prodDate DATETIME NOT NULL ,
    prodStatus CHAR(10) NULL
);

INSERT INTO tb_product VALUES ('AAA','0001',DATE_FORMAT('2023.10.10','%Y.%m.%d'),'판매완료');
INSERT INTO tb_product VALUES ('AAA','0002',DATE_FORMAT('2023.10.11','%Y.%m.%d'),'매장진열');
INSERT INTO tb_product VALUES ('BBB','0001',DATE_FORMAT('2023.10.12','%Y.%m.%d'),'재고창고');
INSERT INTO tb_product VALUES ('CCC','0001',DATE_FORMAT('2023.10.13','%Y.%m.%d'),'판매완료');
INSERT INTO tb_product VALUES ('CCC','0002',DATE_FORMAT('2023.10.14','%Y.%m.%d'),'매장진열');

ALTER TABLE tb_product
    ADD CONSTRAINT PK_product_proCode_proId
    PRIMARY KEY (prodCode,prodId);

SELECT * FROM tb_product;

-- 테이블의 인덱스 정보 확인
SHOW INDEX FROM tb_product;

