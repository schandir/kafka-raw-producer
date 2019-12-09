package com.nathan.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class SampleMessage {

    private String id;
    private String message;

    public SampleMessage() {
        //for Spring-Web binding
    }
    @JsonCreator
    public SampleMessage(@JsonProperty("id") String id,
                    @JsonProperty("message") String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }


    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("message", message)
                .toString();
    }
}
