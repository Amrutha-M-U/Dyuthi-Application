package com.example.jenit.dyuthiapp.model;

/**
 * Created by Jenit on 30-08-2016.
 */
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventDetailsResponseBean {
    @SerializedName("result")
    public List<EventsDetails> result;

    public List<EventsDetails> getResult() {
        return result;
    }
}

