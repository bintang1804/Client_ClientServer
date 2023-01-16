/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.model;

/**
 *
 * @author Bintang
 */
public class Gaji {

    private Long gajiId;
    private String kodeSlip;
    private Long anggotaId;
    private String tanggal;
    private int golongan;
    private double potongan;
    private double gajiBersih;

    public Long getGajiId() {
        return gajiId;
    }

    public void setGajiId(Long gajiId) {
        this.gajiId = gajiId;
    }

    public String getKodeSlip() {
        return kodeSlip;
    }

    public void setKodeSlip(String kodeSlip) {
        this.kodeSlip = kodeSlip;
    }

    public Long getAnggotaId() {
        return anggotaId;
    }

    public void setAnggotaId(Long anggotaId) {
        this.anggotaId = anggotaId;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getGolongan() {
        return golongan;
    }

    public void setGolongan(int golongan) {
        this.golongan = golongan;
    }

    public double getPotongan() {
        return potongan;
    }

    public void setPotongan(double potongan) {
        this.potongan = potongan;
    }

    public double getGajiBersih() {
        return gajiBersih;
    }

    public void setGajiBersih(double gajiBersih) {
        this.gajiBersih = gajiBersih;
    }

}
