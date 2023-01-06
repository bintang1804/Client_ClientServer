/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.model;

/**
 *
 * @author Bintang
 */
public class Pengembalian {
    private Long pengembalianId;
    private Long peminjamanId;
    private String tglDiKembalikan;
    private int terlambat;
    private double denda;

    public Long getPengembalianId() {
        return pengembalianId;
    }

    public void setPengembalianId(Long pengembalianId) {
        this.pengembalianId = pengembalianId;
    }

    public Long getPeminjamanId() {
        return peminjamanId;
    }

    public void setPeminjamanId(Long peminjamanId) {
        this.peminjamanId = peminjamanId;
    }

    public String getTglDiKembalikan() {
        return tglDiKembalikan;
    }

    public void setTglDiKembalikan(String tglDiKembalikan) {
        this.tglDiKembalikan = tglDiKembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }
}
