/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelTransaksi;

/**
 *
 * @author fuadm
 */
public interface ServiceTransaksi {

    void addData(ModelTransaksi motran);

    void UpdateData(ModelTransaksi motran);

    void DeleteData(ModelTransaksi motran);

    ModelTransaksi getById(String id);

    List<ModelTransaksi> getData();

    List<ModelTransaksi> getData2();

    List<ModelTransaksi> search(String id);

}
