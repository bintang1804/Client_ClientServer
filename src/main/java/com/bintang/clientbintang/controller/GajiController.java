/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.controller;

import com.bintang.clientbintang.FormPenggajian;
import com.bintang.clientbintang.model.Gaji;
import com.bintang.clientbintang.model.Peminjaman;
import com.bintang.clientbintang.service.GajiService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bintang
 */
public class GajiController {

    private final GajiService gajiService;
    private final FormPenggajian formPenggajian;

    public GajiController(FormPenggajian formPenggajian) {
        this.formPenggajian = formPenggajian;
        gajiService = new GajiService();
    }

    public void clearForm() {
        formPenggajian.getTxtgajiId().setText("");
        formPenggajian.getTxtkodeSlip().setText("");
        formPenggajian.getTxtTanggal().setText("");
        formPenggajian.getTxtAnggotaId().setText("");
        formPenggajian.getTxtGolongan().setText("");

    }

    public void getGajiId() {
        Long id = Long.valueOf(formPenggajian.getTxtgajiId().getText());
//        Long id = Long.parseLong(formPenggajian.getTxtgajiId().getText());
        Gaji gaji = gajiService.getGaji(id);
        if (gaji != null) {
            formPenggajian.getTxtgajiId().setText(gaji.getGajiId().toString());
            formPenggajian.getTxtkodeSlip().setText(gaji.getTanggal());
            formPenggajian.getTxtTanggal().setText(gaji.getTanggal());
            formPenggajian.getTxtAnggotaId().setText(gaji.getAnggotaId().toString());
            formPenggajian.getTxtGolongan().setText(gaji.getGolongan() + "");

        } else {
            JOptionPane.showMessageDialog(formPenggajian, "Data Tidak Ditemukan");
        }
    }

//    public void getPeminjamanId() {
//        Long id = Long.valueOf(formPeminjaman.getTxtIdPeminjaman().getText());
//        Peminjaman peminjaman = peminjamanService.getPeminjaman(id);
//        if (peminjaman != null) {
//            formPeminjaman.getTxtIdAnggota().setText(peminjaman.getAnggotaId().toString());
//            formPeminjaman.getTxtIdBuku().setText(peminjaman.getBukuId().toString());
//            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
//            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
//        } else {
//            JOptionPane.showMessageDialog(formPeminjaman, "Data Tidak Ada");
//        }
//    }
    public Gaji saveGaji() {
        Gaji gaji = new Gaji();
        gaji.setTanggal(formPenggajian.getTxtTanggal().getText());
        gaji.setGajiId(Long.parseLong(formPenggajian.getTxtgajiId().getText()));
        gaji.setAnggotaId(Long.parseLong(formPenggajian.getTxtAnggotaId().getText()));
        gaji.setGolongan(Integer.parseInt(formPenggajian.getTxtGolongan().getText()));
        gaji = gajiService.saveGaji(gaji);
        if (gaji != null) {
            formPenggajian.getTxtgajiId().setText(gaji.getGajiId().toString());
            JOptionPane.showMessageDialog(formPenggajian, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPenggajian, "Entri Data Gagal");
        }
        return gajiService.saveGaji(gaji);
    }

//    public Peminjaman savePeminjaman() {
//        Peminjaman peminjaman = new Peminjaman();
////        peminjaman.setPeminjamanId(Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText()));
//        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtIdBuku().getText()));
//        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtIdAnggota().getText()));
//        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
//        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
//        peminjaman = peminjamanService.savePeminjaman(peminjaman);
//        if (peminjaman != null) {
//            formPeminjaman.getTxtIdPeminjaman().setText(peminjaman.getPeminjamanId().toString());
//            JOptionPane.showMessageDialog(formPeminjaman, "Entry Data Berhasil");
//        } else {
//            JOptionPane.showMessageDialog(formPeminjaman, "Entry Data Gagal");
//        }
//        return peminjamanService.savePeminjaman(peminjaman);
//
//    }
    public void updateGaji() {
        Gaji gaji = new Gaji();
        gaji.setGajiId(Long.parseLong(formPenggajian.getTxtgajiId().getText()));
        gaji.setKodeSlip(formPenggajian.getTxtkodeSlip().getText());
        gaji.setTanggal(formPenggajian.getTxtTanggal().getText());
        gaji.setAnggotaId(Long.parseLong(formPenggajian.getTxtAnggotaId().getText()));
        gaji = gajiService.saveGaji(gaji);
        if (gaji != null) {
            formPenggajian.getTxtkodeSlip().setText(gaji.getGajiId().toString());
            JOptionPane.showMessageDialog(formPenggajian, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPenggajian, "Update Data Gagal");
        }
    }

    public void deleteGaji() {
        Long id = Long.parseLong(formPenggajian.getTxtAnggotaId().getText());
        gajiService.deleteGaji(id);
        JOptionPane.showMessageDialog(formPenggajian, "Delete Data Berhasil");
    }

    public void viewTabel() {
        DefaultTableModel tabelModel = (DefaultTableModel) formPenggajian.getTabelgaji().getModel();
        tabelModel.setRowCount(0);
        List<Gaji> gajiList = gajiService.getAllGaji();
        for (Gaji gaji : gajiList) {
            Object[] row = {
                gaji.getKodeSlip(),
                gaji.getTanggal(),
                gaji.getAnggotaId(),
                gaji.getGolongan(),
                gaji.getPotongan(),
                gaji.getGajiBersih(),
                gaji.getGajiId()

            };
            tabelModel.addRow(row);
        }
    }
}
