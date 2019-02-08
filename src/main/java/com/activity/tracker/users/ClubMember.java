package com.activity.tracker.users;

import com.activity.tracker.clubs.Club;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "members")
public class ClubMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToMany(cascade = ALL, fetch = FetchType.LAZY)
    private List<Club> clubs = new ArrayList<>();


    public ClubMember() {
    }

    public ClubMember(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

    }

    public ClubMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public ClubMember(String firstName, String lastName, Date birthDate, List<Club> clubs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.clubs = clubs;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", clubs=" + clubs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMember that = (ClubMember) o;
        return memberId == that.memberId &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                birthDate.equals(that.birthDate) &&
                Objects.equals(clubs, that.clubs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, firstName, lastName, birthDate, clubs);
    }
}


