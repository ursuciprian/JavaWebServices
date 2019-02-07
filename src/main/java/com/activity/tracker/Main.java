package com.activity.tracker;

import com.activity.tracker.clubs.Club;
import com.activity.tracker.services.WSServices;
import com.activity.tracker.users.ClubMember;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Endpoint.publish ("http://localhost:8086/ActivityTracker", new WSServices ());

        List<Club> cl = new ArrayList<> ();
        cl.add (new Club ("Vivertine",3.5f,"Iasi", new ClubMember ("Ciprian", "Ursu")));


    }
}

