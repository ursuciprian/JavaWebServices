ALTER TABLE members_CLUB DROP FOREIGN KEY FK_members_CLUB_ClubMember_MEMBERID
ALTER TABLE members_CLUB DROP FOREIGN KEY FK_members_CLUB_clubs_CLUBID
ALTER TABLE cities_CLUB DROP FOREIGN KEY FK_cities_CLUB_City_CITYID
ALTER TABLE cities_CLUB DROP FOREIGN KEY FK_cities_CLUB_clubs_CLUBID
ALTER TABLE CLUB_members DROP FOREIGN KEY FK_CLUB_members_Club_CLUBID
ALTER TABLE CLUB_members DROP FOREIGN KEY FK_CLUB_members_members_MEMBERID
DROP TABLE ACTIVITIES
DROP TABLE members
DROP TABLE cities
DROP TABLE CLUB
DROP TABLE members_CLUB
DROP TABLE cities_CLUB
DROP TABLE CLUB_members
