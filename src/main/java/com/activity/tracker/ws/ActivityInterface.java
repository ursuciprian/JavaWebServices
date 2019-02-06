package com.activity.tracker.ws;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.services.ServiceActivity;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceProvider;

@WebService(name = "ActivityTracker")
@SOAPBinding(style= SOAPBinding.Style.RPC)
public interface ActivityInterface {
    @WebMethod(operationName = "addActivities")
    @WebResult (name = "activityAdded")
    Activities addActivity(@WebParam(name = "ActivityID") int activityId, @WebParam(name = "ActivityName") String activityName, @WebParam(name = "ActivityDifficulty") String difficulty, @WebParam(name = "RequiresTraining") boolean trainingRequired);


}
