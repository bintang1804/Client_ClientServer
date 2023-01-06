/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bintang.clientbintang.controller;



import com.bintang.clientbintang.FormPengembalian;
import com.bintang.clientbintang.model.Pengembalian;
import com.bintang.clientbintang.service.PengembalianService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bintang
 */
public class PengembalianController {
    private final PengembalianService pengembalianService;
    private final FormPengembalian formPengembalian;
    
    public PengembalianController(FormPengembalian formPengembalian){
        this.formPengembalian = formPengembalian;
        pengembalianService = new PengembalianService();
    }
    
    public void bersihForm(){
        formPengembalian.getTxtPengembalianId().setText("");
        formPengembalian.getTxtPeminjamanId().setText("");
 
    }
    
    public void getPengembalianId(){
        Long id = Long.parseLong(formPengembalian.getTxtPengembalianId().getText());
        Pengembalian pengembalian = pengembalianService.getPengembalian(id);
        if(pengembalian!=null){
            formPengembalian.getTxtPeminjamanId().setText(pengembalian.getPengembalianId().toString());
        }else{
            JOptionPane.showMessageDialog(formPengembalian, "Data Tidak Ditemukan");
        }
    }
    
    public void savePengembalian() {
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setPeminjamanId(Long.parseLong(formPengembalian.getTxtPeminjamanId().getText()));
        pengembalian = pengembalianService.savePengembalian(pengembalian);
        if (pengembalian != null) {
            formPengembalian.getTxtPengembalianId().setText(pengembalian.getPengembalianId().toString());
            JOptionPane.showMessageDialog(formPengembalian, "Entri Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPengembalian, "Entri Data Gagal");
        }
    }
    
     public void updatePengembalian() {
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setPengembalianId(Long.parseLong(formPengembalian.getTxtPengembalianId().getText()));
        pengembalian = pengembalianService.updatePengembalian(pengembalian);
        if (pengembalian != null) {
            formPengembalian.getTxtPengembalianId().setText(pengembalian.getPengembalianId().toString());
            JOptionPane.showMessageDialog(formPengembalian, "Update Data Berhasil");
        } else {
            JOptionPane.showMessageDialog(formPengembalian, "Update Data Gagal");
        }
    }
    
    public void deletePengembalian(){
        Long id = Long.parseLong(formPengembalian.getTxtPengembalianId().getText());
        pengembalianService.deletePengembalian(id);
        JOptionPane.showMessageDialog(formPengembalian, "Delete Data Berhasil");
    }
    
        public void viewTabel(){
        DefaultTableModel tabelModel = (DefaultTableModel) formPengembalian.getTabelPengembalian().getModel();
        tabelModel.setRowCount(0);
        List<Pengembalian> pengembalianList = pengembalianService.getAllPengembalian();
        for(Pengembalian pengembalian : pengembalianList){
            Object[] row = {
                pengembalian.getPengembalianId(),
                pengembalian.getPeminjamanId(),
                pengembalian.getTglDiKembalikan(),
                pengembalian.getTerlambat(),
                pengembalian.getDenda()
            };
            tabelModel.addRow(row);
        }
    } 
}
