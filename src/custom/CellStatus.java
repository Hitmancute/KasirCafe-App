package custom;

import javax.swing.JLabel;

public class CellStatus extends JLabel {

    public CellStatus(StatusType type) {

        setText(type.toString());

    }
}