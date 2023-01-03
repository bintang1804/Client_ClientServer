/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.controller;

import com.bintang.clientbintang.FormBuku;
import com.bintang.clientbintang.FormPeminjaman;
import com.bintang.clientbintang.model.Buku;
import com.bintang.clientbintang.model.Peminjaman;
import com.bintang.clientbintang.model.ResponseTemplateVO;
import com.bintang.clientbintang.service.BukuService;
import com.bintang.clientbintang.service.PeminjamanService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bintang
 */
@RestController
@RequestMapping("/peminjaman")

public class PeminjamanController {

    private final PeminjamanService peminjamanService;
    private final FormPeminjaman formPeminjaman;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        this.formPeminjaman = formPeminjaman;
        peminjamanService = new PeminjamanService();
    }

    public void bersihForm() {
        formPeminjaman.getTxtIdPeminjaman().setText("");
        formPeminjaman.getTxtIdAnggota().setText("");
        formPeminjaman.getTxtIdBuku().setText("");
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }

    
//        public void getPeminjamanId() {
//        Long id = Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText());
//        Peminjaman peminjaman = peminjamanService.getPeminjaman(id);
//        if (peminjaman != null) {
//            formPeminjaman.getTxtIdPeminjaman().setText(peminjaman.getAnggotaId().toString());
//            formPeminjaman.getTxtIdBuku().setText(peminjaman.getBukuId().toString());
//            formPeminjaman.getTxtIdAnggota().setText(peminjaman.getAnggotaId().toString());
//            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
//            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
//        } else {
//            JOptionPane.showMessageDialog(formPeminjaman, "Data Tidak Ditemukan");
//        }
//    }
    public Peminjaman getPeminjamanId() {
        Long id = Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText());
        Peminjaman peminjaman = peminjamanService.getPeminjaman(id);
        if (peminjaman != null) {
//            formPeminjaman.getTxtIdPeminjaman().setText(peminjaman.getAnggotaId().toString());
            formPeminjaman.getTxtIdBuku().setText(peminjaman.getBukuId().toString());
            formPeminjaman.getTxtIdAnggota().setText(peminjaman.getAnggotaId().toString());
            formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
            formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Data Tidak Ditemukan");
        }
        return peminjaman;
    }
//        public Buku getBukuId() {
//        Long id = Long.parseLong(formBuku.getTxtIdBuku().getText());
//        Buku buku = bukuService.getBuku(id);
//        if (buku != null) {
//            formBuku.getTxtJudul().setText(buku.getJudul());
//            formBuku.getTxtPenerbit().setText(buku.getPenerbit());
//            formBuku.getTxtPengarang().setText(buku.getPengarang());
//            formBuku.getTxtTahunterbit().setText(buku.getTahun_terbit());
//
//        } else {
//            JOptionPane.showMessageDialog(formBuku, "Data tidak ada");
//        }
//        return buku;
//    }
    

    public Peminjaman savePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
//        peminjaman.setPeminjamanId(Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText()));
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtIdBuku().getText()));
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtIdAnggota().getText()));
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
        peminjaman = peminjamanService.savePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtIdPeminjaman().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Entry Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Entry Data Gagal");
        }
        return peminjamanService.savePeminjaman(peminjaman);

    }
    
    

    
//      public Buku saveBuku() {
//        Buku buku = new Buku();
//        buku.setJudul(formBuku.getTxtJudul().getText());
//        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
//        buku.setPengarang(formBuku.getTxtPengarang().getText());
//        buku.setTahun_terbit(formBuku.getTxtTahunterbit().getText());
//        return bukuService.saveBuku(buku);
//    }
      
      
    public void viewTable() {
        DefaultTableModel tableModel = (DefaultTableModel) formPeminjaman.getTabelPeminjaman().getModel();
        tableModel.setRowCount(0);
        List<Peminjaman> peminjamanList = peminjamanService.getAllPeminjaman();
        for (Peminjaman peminjaman : peminjamanList) {
            Object[] row = {
                peminjaman.getPeminjamanId(),
                peminjaman.getAnggotaId(),
                peminjaman.getBukuId(),
                peminjaman.getTglpinjam(),
                peminjaman.getTglkembali()
            };
            tableModel.addRow(row);
        }
    }

    public void updatePeminjaman() {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setPeminjamanId(Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText()));
        peminjaman.setAnggotaId(Long.parseLong(formPeminjaman.getTxtIdAnggota().getText()));
        peminjaman.setBukuId(Long.parseLong(formPeminjaman.getTxtIdBuku().getText()));
        peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
        peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
        peminjaman = peminjamanService.savePeminjaman(peminjaman);
        if (peminjaman != null) {
            formPeminjaman.getTxtIdPeminjaman().setText(peminjaman.getPeminjamanId().toString());
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Gagal");
        }

    }
    
//        public void updateBuku() {
//        Buku buku = new Buku();
//        buku.setBukuId(Long.parseLong(formBuku.getTxtIdBuku().getText()));
//        buku.setJudul(formBuku.getTxtJudul().getText());
//        buku.setPenerbit(formBuku.getTxtPenerbit().getText());
//        buku.setPengarang(formBuku.getTxtPengarang().getText());
//        buku.setTahun_terbit(formBuku.getTxtTahunterbit().getText());
//        buku = bukuService.updateBuku(buku);
//        if (buku != null) {
//            formBuku.getTxtIdBuku().setText(buku.getBukuId().toString());
//            JOptionPane.showMessageDialog(formBuku, "Update Data Berhasil");
//        } else {
//            JOptionPane.showMessageDialog(formBuku, "Update Data Gagal");
//        }
//    }

    public void deletePeminjaman() {
        Long id = Long.parseLong(formPeminjaman.getTxtIdPeminjaman().getText());
        peminjamanService.deletePeminjaman(id);
        JOptionPane.showMessageDialog(formPeminjaman, "Delete Data Berhasil");
    }
    
   



   
}
