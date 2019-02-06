package com.activity.tracker.services;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.ws.ActivityInterface;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@WebService(endpointInterface = "com.activity.tracker.ws.ActivityInterface")
public class ServiceActivity implements ActivityInterface {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("ActivityTracker");
        EntityManager em = emf.createEntityManager ();
        EntityTransaction tx = em.getTransaction ();

    @Override
    public Activities addActivity(int activityId, String activityName, String difficulty, boolean trainingRequired) {


        Activities activities = new Activities ();
        activities.setActivityId (activityId);
        activities.setActivityName (activityName);
        activities.setDificulty (difficulty);
        activities.setTrainingRequired (trainingRequired);

        tx.begin ();

        em.persist (activities);

        tx.commit ();

        return activities;
    }

public void removeActivity(int id) {
        try {
            Activities activities = em.find (Activities.class, id);
            if (activities != null) {

                tx.begin ();
                em.remove (activities);
                tx.commit ();
            }
        } catch (Exception e) {

            System.out.println ("ID: " + id + "not found" + e.getMessage ());

        }

    }

}



