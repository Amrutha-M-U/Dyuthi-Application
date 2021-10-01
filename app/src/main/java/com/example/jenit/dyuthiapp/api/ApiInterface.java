package com.example.jenit.dyuthiapp.api;

import com.example.jenit.dyuthiapp.model.EventDetailsResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Jenit on 30-08-2016.
 */
public class ApiInterface {
    @GET("")
    Call<EventDetailsResponseBean> getEventDetails();
}
