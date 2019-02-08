package com.activity.tracker.services;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.clubs.City;
import com.activity.tracker.clubs.Club;
import com.activity.tracker.users.ClubMember;
import com.activity.tracker.ws.ActivityTrackerInterface;

import javax.jws.WebService;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebService(endpointInterface = "com.activity.tracker.ws.ActivityTrackerInterface")
public class WSServices implements ActivityTrackerInterface {


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ActivityTracker");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    TypedQuery<Club> query = em.createQuery ("select c from Club c where c.clubName = ?1", Club.class);

    @Override
    public Activities addActivity(int activityId, String activityName, String difficulty, boolean trainingRequired) {


        Activities activities = new Activities();
        activities.setActivityId(activityId);
        activities.setActivityName(activityName);
        activities.setDifficulty(difficulty);
        activities.setTrainingRequired(trainingRequired);

        tx.begin();
        em.persist(activities);
        tx.commit();
        return activities;
    }

    @Override
    public Activities removeActivity(int activityId) {

        Activities activities = retrieveActivity(activityId);
        if (activities != null) {

            tx.begin();
            em.remove(activities);
            tx.commit();
        }

        return activities;
    }

    @Override
    public Activities getActivities(int activityId) {

        Activities activities = retrieveActivity(activityId);
        return activities;

    }

    private Activities retrieveActivity(int activityId) {
        return em.find(Activities.class, activityId);
    }

    @Override
    public City addCity(int cityId, String cityName) {

        City cities = new City();
        cities.setCityId(cityId);
        cities.setCityName(cityName);

        tx.begin();
        em.persist(cities);
        tx.commit();

        return cities;
    }

    @Override
    public Club addClub(String clubName, float clubRank) {

        Club clubs = new Club();
        clubs.setClubName(clubName);
        clubs.setClubRanking(clubRank);
        tx.begin();
        em.persist(clubs);
        tx.commit();

        return clubs;
    }

    @Override
    public City createActiveClub(String cityName, String clubName, List<String> member) {

        City city = new City(); //new city
        city.setCityName(cityName); //city name
        Club club = new Club(); // new club
        club.setClubName(clubName); //set the club
        List<Club> clubs = new ArrayList<>();
        List<ClubMember> clubMembers =new ArrayList<>();
        for(String memberName : member)
        {
            ClubMember clubMember = new ClubMember();
            clubMember.setFirstName(memberName);
            clubMember.setLastName(memberName);
            clubMember.setBirthDate(new Date());
            clubMembers.add(clubMember);
        }
        club.setMembers(clubMembers);
        clubs.add(club);

        city.setClubs(clubs);
        tx.begin();
        em.persist(city);
        tx.commit();

        return city;
    }

    @Override
    public List<Club> findClubs(String clubName){

        List<Club> clubList = query.setParameter (1,clubName).getResultList ();

        return (List<Club>) clubList;
    }

}

