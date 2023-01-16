/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.controller;

import com.bintang.clientbintang.FormBuku;
import com.bintang.clientbintang.model.Anggota;
import com.bintang.clientbintang.model.Buku;
import com.bintang.clientbintang.service.BukuService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bintang
 */
public class BukuController {

    private BukuService bukuService;
    private FormBuku formBuku;

    public BukuController(FormBuku formBuku) {
        this.formBuku = formBuku;
        bukuService = new BukuService();
    }

    public void bersihForm() {
        formBuku.getTxtIdBuku().setText("");
        formBuku.getTxtJudul().setText("");
        formBuku.getTxtPenerbit().setText("");
        formBuku.getTxtPengarang().setText("");
        formBuku.getTxtTahunterbit().setText("");

    }

    public Buku saveBuku() {
        Buku buku = new Buku();
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setTahun_terbit(formBuku.getTxtTahunterbit().getText());
        return bukuService.saveBuku(buku);
    }

    public Buku getBukuId() {
        Long id = Long.parseLong(formBuku.getTxtIdBuku().getText());
        Buku buku = bukuService.getBuku(id);
        if (buku != null) {
            formBuku.getTxtJudul().setText(buku.getJudul());
            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
            formBuku.getTxtPengarang().setText(buku.getPengarang());
            formBuku.getTxtTahunterbit().setText(buku.getTahun_terbit());

        } else {
            JOptionPane.showMessageDialog(formBuku, "Data tidak ada");
        }
        return buku;
    }


    public void updateBuku() {
        Buku buku = new Buku();
        buku.setBukuId(Long.parseLong(formBuku.getTxtIdBuku().getText()));
        buku.setJudul(formBuku.getTxtJudul().getText());
        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
        buku.setPengarang(formBuku.getTxtPengarang().getText());
        buku.setTahun_terbit(formBuku.getTxtTahunterbit().getText());
        buku = bukuService.updateBuku(buku);
        if (buku != null) {
            formBuku.getTxtIdBuku().setText(buku.getBukuId().toString());
            JOptionPane.showMessageDialog(formBuku, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formBuku, "Update Data Gagal");
        }
    }

    public void deleteBuku() {
        Long id = Long.parseLong(formBuku.getTxtIdBuku().getText());
        bukuService.deleteBuku(id);
        JOptionPane.showMessageDialog(formBuku, "Delete Data Berhasil");
    }

    public void viewTabel() {
        DefaultTableModel tabelModel = (DefaultTableModel) formBuku.getTabelBuku().getModel();
        tabelModel.setRowCount(0);
        List<Buku> bukuList = bukuService.getAllBuku();
        for (Buku buku : bukuList) {
            Object[] row = {
                buku.getBukuId(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
                buku.getTahun_terbit(),};
            tabelModel.addRow(row);
        }
    }
}
