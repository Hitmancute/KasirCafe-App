/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelProduk;

/**
 *
 * @author fuadm
 */
public interface ServiceProduk {

    void addData(ModelProduk mopa);

    void UpdateData(ModelProduk mopa);

    void DeleteData(ModelProduk mopa);

    ModelProduk getById(String id);

    List<ModelProduk> getData();

    List<ModelProduk> getData2();

    List<ModelProduk> search(String id);
}
