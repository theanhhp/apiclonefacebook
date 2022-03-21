package com.Theanh.apiclonefacebook.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private ModelData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ModelData getData() {
        return data;
    }

    public void setData(ModelData data) {
        this.data = data;
    }
}
