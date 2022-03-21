package com.Theanh.apiclonefacebook.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelLists {
    @JsonProperty("account")
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
