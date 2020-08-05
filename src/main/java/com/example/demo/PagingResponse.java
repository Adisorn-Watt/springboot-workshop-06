package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"page", "item_per_page", "users"})
public class PagingResponse {
    @JsonProperty("users")
    private List<UserResponse> userResponseList;

    private int page;

    @JsonProperty("item_per_page")
    private int itemPerPage;

    public PagingResponse(int page, int itemPerPage) {
        this.page = page;
        this.itemPerPage = itemPerPage;
    }
    // generated since line 22
    public List<UserResponse> getUserResponseList() {
        return userResponseList;
    }

    public void setUserResponseList(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }
}
