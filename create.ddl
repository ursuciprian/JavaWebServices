CREATE TABLE ACTIVITIES (ACTIVITYID INTEGER NOT NULL, ACTIVITYNAME VARCHAR(255), DIFFICULTY VARCHAR(255), TRAININGREQUIRED TINYINT(1) default 0, PRIMARY KEY (ACTIVITYID))
CREATE TABLE club_member (MEMBERID INTEGER NOT NULL, BIRTHDATE DATE, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PRIMARY KEY (MEMBERID))
CREATE TABLE CLUB (CLUBID INTEGER NOT NULL, CLUBCITY VARCHAR(255), CLUBNAME VARCHAR(255), CLUBRANKING FLOAT, CITY_CITYID INTEGER, MEMBER_MEMBERID INTEGER, PRIMARY KEY (CLUBID))
CREATE TABLE cities (CITYID INTEGER NOT NULL, CITYNAME INTEGER, PRIMARY KEY (CITYID))
ALTER TABLE CLUB ADD CONSTRAINT FK_CLUB_MEMBER_MEMBERID FOREIGN KEY (MEMBER_MEMBERID) REFERENCES club_member (MEMBERID)
ALTER TABLE CLUB ADD CONSTRAINT FK_CLUB_CITY_CITYID FOREIGN KEY (CITY_CITYID) REFERENCES cities (CITYID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
