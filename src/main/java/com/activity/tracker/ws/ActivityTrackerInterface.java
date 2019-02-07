package com.activity.tracker.ws;

import com.activity.tracker.activities.Activities;
import com.activity.tracker.clubs.City;
import com.activity.tracker.clubs.Club;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "ActivityTracker")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ActivityTrackerInterface {
    @WebMethod(operationName = "addActivities")
    @WebResult(name = "activityAdded")
    Activities addActivity(@WebParam(name = "ActivityID") int activityId, @WebParam(name = "ActivityName") String activityName, @WebParam(name = "ActivityDifficulty") String difficulty, @WebParam(name = "RequiresTraining") boolean trainingRequired);

    @WebMethod(operationName = "addCity")
    @WebResult(name = "addedCity")
    City addCity(int cityId, String cityName);

    @WebMethod(operationName = "addClub")
    @WebResult(name = "addedClubs")
    Club addClub(@WebParam(name = "clubName")String clubName,@WebParam(name = "cityName") String cityName, @WebParam(name = "Rating") float clubRank);

    @WebMethod(operationName = "removeActivity")
    @WebResult(name = "removedActivity")
    Activities removeActivity(@WebParam(name = "id") int activityId);


    @WebMethod(operationName = "findActivities")
    @WebResult(name = "activity")
    Activities getActivities(@WebParam(name = "activityId") int activityId);
}

