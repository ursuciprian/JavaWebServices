package com.activity.tracker.services;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.ws.ActivityTrackerInterface;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@WebService(endpointInterface = "com.activity.tracker.ws.ActivityTrackerInterface")
public class ServiceActivityTracker implements ActivityTrackerInterface {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("ActivityTracker");
        EntityManager em = emf.createEntityManager ();
        EntityTransaction tx = em.getTransaction ();

    @Override
    public Activities addActivity(int activityId, String activityName, String difficulty, boolean trainingRequired) {


        Activities activities = new Activities ();
        activities.setActivityId (activityId);
        activities.setActivityName (activityName);
        activities.setDifficulty (difficulty);
        activities.setTrainingRequired (trainingRequired);

        tx.begin ();

        em.persist (activities);

        tx.commit ();
        return activities;
    }
    @Override
    public Activities removeActivity(int activityId) {

            Activities activities = em.find (Activities.class, activityId);
            if (activities != null) {

                tx.begin ();
                em.remove (activities);
                tx.commit ();
            }

        return activities;
    }

}



