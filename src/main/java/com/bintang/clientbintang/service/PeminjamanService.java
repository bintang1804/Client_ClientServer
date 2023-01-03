/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.service;

import com.bintang.clientbintang.model.Buku;
import com.bintang.clientbintang.model.Peminjaman;
import com.google.gson.Gson;
import static com.google.gson.internal.bind.TypeAdapters.URL;
import java.util.List;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author Bintang
 */
public class PeminjamanService {

    private final String URL = "http://localhost:8050";
//
//    public Peminjaman getPeminjaman(Long peminjamanId) {
//        Peminjaman peminjaman = Unirest.get(URL + "/peminjaman/" + peminjamanId).asObject(Peminjaman.class).getBody();
//        if (peminjaman != null) {
//            return peminjaman;
//        }
//
//        return peminjaman;
//    }
//
    public List<Peminjaman> getAllPeminjaman() {
        List<Peminjaman> peminjamanList = Unirest.get(URL + "/peminjaman/")
                .asObject(new GenericType<List<Peminjaman>>() {
                })
                .getBody();
        return peminjamanList;
    }
//
//    public Peminjaman savePeminjaman(Peminjaman peminjaman) {
//        HttpResponse<JsonNode> response = Unirest.post(URL + "/peminjaman/")
//                .header("content-type", "application/json")
//                .body(peminjaman)
//                .asJson();
//        Gson gson = new Gson();
//        Peminjaman p = gson.fromJson(response.getBody().toString(), Peminjaman.class);
//        return peminjaman;
//    }
//
//    public Peminjaman updatePeminjaman(Peminjaman peminjaman) {
//        HttpResponse<JsonNode> response = Unirest.put(URL + "/peminjaman/")
//                .header("content-type", "application/json")
//                .body(peminjaman)
//                .asJson();
//        Gson gson = new Gson();
//        Peminjaman p = gson.fromJson(response.getBody().toString(), Peminjaman.class);
//        return peminjaman;
//    }
//
    public void deletePeminjaman(Long peminjamanId) {
        Unirest.delete(URL + "/peminjaman/" + peminjamanId).asEmpty();
    }
    
    
    
    public Peminjaman getPeminjaman(Long peminjamanId){
        Peminjaman peminjaman = Unirest.get(URL + "/peminjaman/"+peminjamanId)
                .asObject(Peminjaman.class)
                .getBody();
        return peminjaman;
    }
    

    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        HttpResponse<JsonNode> response = Unirest.post(URL + "/peminjaman/")
                .header("Content-Type", "application/json")
                .body(peminjaman)
                .asJson();
        Gson gson = new Gson();
        return gson.fromJson(response.getBody().toString(), Peminjaman.class);
    }
    
    
    public Buku updateBuku(Buku buku){
        HttpResponse<JsonNode> response = Unirest.put(URL + "/buku/")
                .header("content-type","application/json")
                .body(buku)
                .asJson();
        Gson gson = new Gson();
        Buku b = gson.fromJson(response.getBody().toString(),Buku.class);
        return b;
    }
    

}
