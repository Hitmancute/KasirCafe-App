/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelPelanggan;

/**
 *
 * @author fuadm
 */
public interface ServicePelanggan {

    void addData(ModelPelanggan mopel);

    void UpdateData(ModelPelanggan mopel);

    void DeleteData(ModelPelanggan mopel);

    ModelPelanggan getById(String id);

    List<ModelPelanggan> getData();

    List<ModelPelanggan> getData2();

    List<ModelPelanggan> search(String id);
    
    String nomer();
}
