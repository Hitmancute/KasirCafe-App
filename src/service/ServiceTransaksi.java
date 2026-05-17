/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelDetailTransaksi;
import model.ModelTransaksi;

/**
 *
 * @author fuadm
 */
public interface ServiceTransaksi {

    void addData(ModelTransaksi motran, ModelDetailTransaksi modetran);

    void UpdateData(ModelTransaksi motran, ModelDetailTransaksi modetran);

    void DeleteData(ModelTransaksi motran,ModelDetailTransaksi modetran);

    ModelTransaksi getById(String id);

    List<ModelTransaksi> getData();

    List<ModelTransaksi> getData2();

    List<ModelTransaksi> search(String id);

}
