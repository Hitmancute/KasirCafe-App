/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fuadm
 */
public class ModelProduk {

    private ModelKategory idKategori;
    private String id;
    private String NamaMenu;
    private Long harga;
    private int stok;
    private String status;

    public ModelKategory getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(ModelKategory idKategori) {
        this.idKategori = idKategori;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMenu() {
        return NamaMenu;
    }

    public void setNamaMenu(String NamaMenu) {
        this.NamaMenu = NamaMenu;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
