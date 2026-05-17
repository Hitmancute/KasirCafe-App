/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ModelDetailTransaksi;

/**
 *
 * @author fuadm
 */
public class TableModDetailTransaksi extends AbstractTableModel {

    private List<ModelDetailTransaksi> list = new ArrayList<>();

    public void addData(ModelDetailTransaksi motdet) {
        list.add(motdet);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }

    public void UpdateData(int row, ModelDetailTransaksi motdet) {
        list.add(row, motdet);
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

    public void setData(List<ModelDetailTransaksi> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int index, ModelDetailTransaksi motdet) {
        list.set(index, motdet);
        fireTableRowsUpdated(index, index);
    }

    public ModelDetailTransaksi getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getIdTransaksi().getId();
            case 2:
                return list.get(rowIndex).getIdProduk().getId();
            case 3:
                return list.get(rowIndex).getJumlah();
            case 4:
                return list.get(rowIndex).getSubtotal();
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
                return "id_transaksi";
            case 2:
                return "id_menu";
            case 3:
                return "jumlah";
            case 4:
                return "subtotal";
            default:
                return null;
        }
    }
}
