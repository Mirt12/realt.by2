package main.api;

import java.util.HashMap;

public class PageObjectForLogin {
    String endpoint = "https://realt.by/bff/graphql";

    public HashMap<String, String> getRequestheaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        return headers;
    }

    public HashMap<String, String> getQueryParams(String login, String password) {
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("login", login);
        queryParams.put("password", password);
        return queryParams;
    }
}
