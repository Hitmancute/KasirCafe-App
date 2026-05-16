/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fuadm
 */
public class ModelDetailTransaksi {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ModelTransaksi getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(ModelTransaksi idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public ModelProduk getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(ModelProduk idProduk) {
        this.idProduk = idProduk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }
    private String id;
    private ModelTransaksi idTransaksi;
    private ModelProduk idProduk;
    private int jumlah;
    private Long subtotal;
}
