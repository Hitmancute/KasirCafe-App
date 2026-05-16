/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelKategory;

/**
 *
 * @author fuadm
 */
public interface ServiceKategory {

    void addData(ModelKategory moka);

    void UpdateData(ModelKategory moka);

    void DeleteData(ModelKategory moka);

    ModelKategory getById(String id);

    List<ModelKategory> getData();

    List<ModelKategory> getData2();

    List<ModelKategory> search(String id);

    List<ModelKategory> search2(String id);
    
    String nomer();

}
