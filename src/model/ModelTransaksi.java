/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fuadm
 */
public class ModelTransaksi {

    private String id;
    private ModelLogin idKasir;
    private ModelPelanggan idPelanggan;
    private String tanggal;
    private Long totalHarga;
    private Long bayar;
    private Long kembalian;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ModelLogin getIdKasir() {
        return idKasir;
    }

    public void setIdKasir(ModelLogin idKasir) {
        this.idKasir = idKasir;
    }

    public ModelPelanggan getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(ModelPelanggan idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Long getBayar() {
        return bayar;
    }

    public void setBayar(Long bayar) {
        this.bayar = bayar;
    }

    public Long getKembalian() {
        return kembalian;
    }

    public void setKembalian(Long kembalian) {
        this.kembalian = kembalian;
    }

}
