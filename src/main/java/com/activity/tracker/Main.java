package com.activity.tracker;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.services.ServiceActivity;
import com.activity.tracker.ws.ActivityInterface;

import javax.xml.ws.Endpoint;


public class Main {

    public static void main(String[] args) {

        ServiceActivity activity = new ServiceActivity ();
        Activities act = activity.addActivity (1,"Running","medium",false);
        Endpoint.publish ("http://localhost:8086/ActivityTracker", new ServiceActivity());
        System.out.println (act);

    }
}

