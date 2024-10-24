package core.utils;

import javax.swing.JOptionPane;

public class Util {

    public void alertMessage() {
        JOptionPane.showMessageDialog(null,
                "Invalid password. Try again.",
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }
}
