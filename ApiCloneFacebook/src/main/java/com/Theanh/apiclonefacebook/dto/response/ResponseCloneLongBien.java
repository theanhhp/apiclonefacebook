package com.Theanh.apiclonefacebook.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseCloneLongBien {
    @JsonProperty("success")
    private String success;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<String> data;

    @JsonProperty("timespan")
    private String timespan;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getTimespan() {
        return timespan;
    }

    public void setTimespan(String timespan) {
        this.timespan = timespan;
    }
}
