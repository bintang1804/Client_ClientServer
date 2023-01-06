/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.service;

import com.bintang.clientbintang.model.Pengembalian;
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
public class PengembalianService {
     private final String URL = "http://localhost:7050";
    
    public Pengembalian getPengembalian(Long pengembalianId){
        Pengembalian pengembalian = Unirest.get(URL+"/pengembalian/"+pengembalianId).asObject(Pengembalian.class).getBody();
        if (pengembalian!=null){
            return pengembalian;
        }
        return null;
    }
    
    public List<Pengembalian> getAllPengembalian(){
        List<Pengembalian> pengembalianList = Unirest.get(URL + "/pengembalian/")
                .asObject(new GenericType<List<Pengembalian>>(){})
                .getBody();
        return pengembalianList;
    }
    
    public Pengembalian savePengembalian(Pengembalian pengembalian){
        HttpResponse<JsonNode> response = Unirest.post(URL + "/pengembalian/")
                .header("content-type","application/json")
                .body(pengembalian)
                .asJson();
        Gson gson = new Gson();
        Pengembalian a = gson.fromJson(response.getBody().toString(),Pengembalian.class);
        return a;
    }
    
    public Pengembalian updatePengembalian(Pengembalian pengembalian){
        HttpResponse<JsonNode> response = Unirest.put(URL+"/pengembalian/")
                   .header("content-type", "application/json")
                   .body(pengembalian)
                   .asJson();
        Gson gson = new Gson();
        Pengembalian a = gson.fromJson(response.getBody().toString(), Pengembalian.class);
        return a;
    }
    
    public void deletePengembalian(Long pengembalianId){
        Unirest.delete(URL+"/pengembalian/"+pengembalianId).asEmpty();
    } 
}
