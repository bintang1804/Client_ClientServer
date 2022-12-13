/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.controller;

import com.bintang.clientbintang.FormAnggota;
import com.bintang.clientbintang.model.Anggota;
import com.bintang.clientbintang.service.AnggotaService;
import javax.swing.JOptionPane;

/**
 *
 * @author LABSIDOSEN
 */
public class AnggotaController {
    private AnggotaService anggotaService;
    private final FormAnggota formAnggota;

    public AnggotaController(FormAnggota formAnggota) {
        this.formAnggota = formAnggota;
        anggotaService = new AnggotaService();
    }
    
    
    public void bersihForm(){
        formAnggota.getTxtIdAnggota().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
    }
    
    public Anggota saveAnggota(){
        Anggota anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        return anggotaService.saveAnggota(anggota);
    }
    
    public Anggota getAnggotaId(){
        Long id = Long.parseLong(formAnggota.getTxtIdAnggota().getText());
        Anggota anggota = anggotaService.getAnggota(id);
        if(anggota!=null){
            formAnggota.getTxtNama().setText(anggota.getNama());
            formAnggota.getTxtAlamat().setText(anggota.getAlamat());
        }else{
            JOptionPane.showMessageDialog(formAnggota, "Data tidak ada");
        }
        return anggota;
    }
    
}
