package com.example.jenit.dyuthiapp.model;

/**
 * Created by Jenit on 30-08-2016.
 */

import com.google.gson.annotations.SerializedName;
public class EventsDetails {
    @SerializedName("Event")
    public String Event;
    @SerializedName("Time")
    public String Time;
    @SerializedName("Venue")
    public String Venue;
    @SerializedName("Contact")
    public String Contact;
    @SerializedName("Type")
    public String Type;
    @SerializedName("Day")
    public String Day;

    public EventsDetails(String contact, String day, String event, String time, String type, String venue) {
        Contact = contact;
        Day = day;
        Event = event;
        Time = time;
        Type = type;
        Venue = venue;
    }

    public String getContact() {
        return Contact;
    }

    public String getEvent() {
        return Event;
    }

    public String getDay() {
        return Day;
    }

    public String getTime() {
        return Time;
    }

    public String getType() {
        return Type;
    }

    public String getVenue() {
        return Venue;
    }
}
