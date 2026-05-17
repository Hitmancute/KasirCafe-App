/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.ModelLogin;

/**
 *
 * @author fuadm
 */
public class TableModKasir extends AbstractTableModel {

    private List<ModelLogin> list = new ArrayList<>();

    public void addData(ModelLogin mola) {
        list.add(mola);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
    }

    public void UpdateData(int row, ModelLogin mola) {
        list.add(row, mola);
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

    public void setData(List<ModelLogin> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public void setData(int index, ModelLogin moka) {
        list.set(index, moka);
        fireTableRowsUpdated(index, index);
    }

    public ModelLogin getData(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    private final String[] columNames = {"No", "ID Kasir", "Nama", "Username", "Role"};

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return "   " + (rowIndex + 1);
        } else {
            switch (columnIndex - 1) {
                case 0:
                    return list.get(rowIndex).getId();
                case 1:
                    return list.get(rowIndex).getNama();
                case 2:
                    return list.get(rowIndex).getUsername();
                case 3:
                    return list.get(rowIndex).getRole();
                default:
                    return null;
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "   " + columNames[column];
        } else {
            return columNames[column];
        }
    }
}
