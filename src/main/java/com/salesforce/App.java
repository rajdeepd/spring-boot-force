package com.salesforce;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import org.json.JSONArray;
import org.salesforce.SObject;
import org.salesforce.Util;
import org.json.JSONObject;

@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/accounts")
    String accountList() {
        Util util = new Util();
        SObject sObject = new SObject("Account",util.getBaseUrl());
        String body = sObject.getList();
        JSONObject obj = new JSONObject(body);
        JSONArray array = obj.getJSONArray("recentItems");
        return array.toString(4);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
