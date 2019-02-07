package com.activity.tracker.clubs;

import com.activity.tracker.users.ClubMember;

import javax.persistence.*;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;
    private String clubName;
    private float clubRanking;

    //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //private City city;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ClubMember> members;

    public Club(){}
    public Club(String clubName, float clubRanking, List<ClubMember> members) {
        this.clubName = clubName;
        this.clubRanking = clubRanking;
        this.members = members;
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

    public List<ClubMember> getMembers() {
        return members;
    }

    public void setMembers(List<ClubMember> members) {
        this.members = members;
    }
}
