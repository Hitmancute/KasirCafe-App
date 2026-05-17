/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ModelLogin;

/**
 *
 * @author fuadm
 */
public interface ServiceLogin {

    void prossLogin(ModelLogin molo);

    List<ModelLogin> search(String id);

    List<ModelLogin> getData();

}
