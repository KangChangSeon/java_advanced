-- 테이블 스페이스
#     테이블이 저장되는 물리적 공간을 '테이블 스페이스' 라고 한다.
#     대용량의 데이터를 다룰 때 성능 향상을 위해 테이블 스페이스에 대한 설정방법을 알아야 함
#     데이터베이스는 테이블을 논리적 공간으로 다루며, 테이블 스페이스는 실제로 데이터가 저장되는 물리적 공간을 의미한다.
SHOW VARIABLES LIKE 'innodb_data_file_path';

-- 대용량의 데이터를 운영한다고 가정하고, 테이블 스페이스를 분리해서 설정하는 방법에 대해 알아보자
# 1. innodb_file_per_table 상태정보를 on 상태인지를 확인한다.
SHOW VARIABLES LIKE 'innodb_file_per_table';
# 테이블 스페이스 설정
CREATE TABLESPACE ts__a ADD DATAFILE 'ts_a.ibd';
CREATE TABLESPACE ts__b ADD DATAFILE 'ts_b.ibd';
CREATE TABLESPACE ts__c ADD DATAFILE 'ts_c.ibd';

use ssgdb;
CREATE TABLE table_a(id INT) TABLESPACE ts__a;
ALTER TABLE table_b TABLESPACE ts__c;