package custom;

import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ModelKategory;

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

                if (column == 4) {
                    header.setHorizontalAlignment(CENTER);
                }

                return header;
            }
        });

        // Body Renderer
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean selected,
                    boolean hasFocus,
                    int row,
                    int column) {

                if (column != 4) {

                    Component com = super.getTableCellRendererComponent(
                            table,
                            value,
                            selected,
                            hasFocus,
                            row,
                            column
                    );

                    com.setBackground(Color.WHITE);

                    setBorder(noFocusBorder);

                    if (selected) {
                        com.setForeground(new Color(15, 89, 140));
                    } else {
                        com.setForeground(new Color(102, 102, 102));
                    }

                    return com;

                } else {

                    StatusType type = (StatusType) value;
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
