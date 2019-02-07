package com.activity.tracker.clubs;

import com.activity.tracker.users.ClubMember;

import javax.persistence.*;

@Entity
public class Club {
    @Id
    @GeneratedValue
    private int clubId;
    private String clubName;
    private float clubRanking;
    private String clubCity;
    private enum clubFacilities{};

    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClubMember member;

    public Club() {
    }




    public Club(int clubId, String clubName, float clubRanking, String clubCity, ClubMember member){
        this.clubId = clubId;
        this.clubName = clubName;
        this.clubRanking = clubRanking;
        this.clubCity = clubCity;
        this.member = member;
    }



    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public float getClubRanking() {
        return clubRanking;
    }

    public void setClubRanking(float clubRanking) {
        this.clubRanking = clubRanking;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }
}
