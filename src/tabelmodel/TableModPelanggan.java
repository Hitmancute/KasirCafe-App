/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ModelPelanggan;

/**
 *
 * @author fuadm
 */
public class TableModPelanggan extends AbstractTableModel {

    private List<ModelPelanggan> list = new ArrayList<>();

    public void addData(ModelPelanggan mopel) {
        list.add(mopel);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }

    public void UpdateData(int row, ModelPelanggan mopel) {
        list.add(row, mopel);
        fireTableDataChanged();
        JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
    }

    public void DeleteData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }

    public void setData(List<ModelPelanggan> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int index, ModelPelanggan mopel) {
        list.set(index, mopel);
        fireTableRowsUpdated(index, index);
    }

    public ModelPelanggan getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getNoHp();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "nama";
            case 2:
                return "no_hp";
            default:
                return null;
        }
    }
}
