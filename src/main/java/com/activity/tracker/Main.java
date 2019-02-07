package com.activity.tracker;

import com.activity.tracker.services.ServiceActivityTracker;

import javax.xml.ws.Endpoint;


public class Main {

    public static void main(String[] args) {
        Endpoint.publish ("http://localhost:8086/ActivityTracker", new ServiceActivityTracker ());

    }
}

