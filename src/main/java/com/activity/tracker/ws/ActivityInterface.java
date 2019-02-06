package com.activity.tracker.ws;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.services.ServiceActivity;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceProvider;

@WebService(name = "ActivityTracker")
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface ActivityInterface {

    Activities addActivity(@WebParam(name = "ActivityID") int activityId, String activityName, String difficulty, boolean trainingRequired);


}
