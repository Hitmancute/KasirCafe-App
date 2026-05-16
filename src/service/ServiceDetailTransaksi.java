/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelDetailTransaksi;

/**
 *
 * @author fuadm
 */
public interface ServiceDetailTransaksi {

    void addData(ModelDetailTransaksi motdet);

    void UpdateData(ModelDetailTransaksi motdet);

    void DeleteData(ModelDetailTransaksi motdet);

    ModelDetailTransaksi getById(String id);

    List<ModelDetailTransaksi> getData();

    List<ModelDetailTransaksi> getData2();

    List<ModelDetailTransaksi> search(String id);
}
