ALTER TABLE CLUB DROP FOREIGN KEY FK_CLUB_MEMBER_MEMBERID
ALTER TABLE CLUB DROP FOREIGN KEY FK_CLUB_CITY_CITYID
DROP TABLE ACTIVITIES
DROP TABLE club_member
DROP TABLE CLUB
DROP TABLE cities
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
