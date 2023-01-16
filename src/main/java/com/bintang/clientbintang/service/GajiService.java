/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.service;

import com.bintang.clientbintang.model.Gaji;
import com.google.gson.Gson;
import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author Bintang
 */
public class GajiService {

    private final String URL = "http://localhost:8080";

    public Gaji getGaji(Long gajiId) {
        Gaji gaji = Unirest.get(URL + "/gaji/" + gajiId).asObject(Gaji.class).getBody();
        if (gaji != null) {
            return gaji;
        }
        return null;
    }

    public List<Gaji> getAllGaji() {
        List<Gaji> gajiList = Unirest.get(URL + "/gaji/")
                .asObject(new GenericType<List<Gaji>>() {
                })
                .getBody();
        return gajiList;
    }

    public Gaji saveGaji(Gaji gaji) {
        HttpResponse<JsonNode> response = Unirest.post(URL + "/gaji/")
                .header("content-type", "application/json")
                .body(gaji)
                .asJson();
        Gson gson = new Gson();
        Gaji a = gson.fromJson(response.getBody().toString(), Gaji.class);
        return a;
    }

    public Gaji updateGaji(Gaji gaji) {
        HttpResponse<JsonNode> response = Unirest.put(URL + "/gaji/")
                .header("content-type", "application/json")
                .body(gaji)
                .asJson();
        Gson gson = new Gson();
        Gaji a = gson.fromJson(response.getBody().toString(), Gaji.class);
        return a;
    }

    public void deleteGaji(Long slipGaji) {
        Unirest.delete(URL + "/gaji/" + slipGaji).asEmpty();
    }
}
