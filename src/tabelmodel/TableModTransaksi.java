/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ModelTransaksi;

/**
 *
 * @author fuadm
 */
public class TableModTransaksi extends AbstractTableModel {

    private List<ModelTransaksi> list = new ArrayList<>();

    public void addData(ModelTransaksi motran) {
        list.add(motran);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }

    public void UpdateData(int row, ModelTransaksi motran) {
        list.add(row, motran);
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

    public void setData(List<ModelTransaksi> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int index, ModelTransaksi motran) {
        list.set(index, motran);
        fireTableRowsUpdated(index, index);
    }

    public ModelTransaksi getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getIdKasir().getId();
            case 2:
                return list.get(rowIndex).getIdPelanggan().getId();
            case 3:
                return list.get(rowIndex).getIdKasir().getNama();
            case 4:
                return list.get(rowIndex).getIdPelanggan().getNama();
            case 5:
                return list.get(rowIndex).getTanggal();
            case 6:
                return list.get(rowIndex).getTotalHarga();
            case 7:
                return list.get(rowIndex).getBayar();
            case 8:
                return list.get(rowIndex).getKembalian();
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
                return "id_kasir";
            case 2:
                return "id_pelanggan";
            case 3:
                return "nama";
            case 4:
                return "nama";
            case 5:
                return "tanggal";
            case 6:
                return "total_harga";
            case 7:
                return "bayar";
            case 8:
                return "kembalian";
            default:
                return null;
        }
    }
}
