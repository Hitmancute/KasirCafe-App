package custom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import custom.CellStatus;
import custom.StatusType;

public class TableCustom extends JTable {

    public TableCustom() {

        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);

        getTableHeader().setReorderingAllowed(false);

        // Header Renderer
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                TableHeader header = new TableHeader(value + "");

                if (column == 8) {
                    header.setHorizontalAlignment(CENTER);
                }

                return header;
            }
        });

        // Body Renderer
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                if (column != 8) {
                    // Kolom biasa
                    Component component = super.getTableCellRendererComponent(
                            table,
                            value,
                            isSelected,
                            hasFocus,
                            row,
                            column
                    );

                    component.setBackground(Color.WHITE);

                    setBorder(noFocusBorder);

                    if (isSelected) {
                        component.setForeground(new Color(15, 89, 140));
                    } else {
                        component.setForeground(new Color(102, 102, 102));
                    }
                    return component;
                }else{
                    StatusType type = StatusType.valueOf(value.toString());;
                    CellStatus cell = new CellStatus(type);
                    return cell;
                }

            }
        });
    }

    // Method tambah row
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
