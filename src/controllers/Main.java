package controllers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import views.DialogLogin;
import views.ViewMenuPrincipal;

public class Main {

    public static void main(String[] args) throws PropertyVetoException {
//        ViewMenuPrincipal viewMenuPrincipal = new ViewMenuPrincipal();// Crear objeto del JFrame principal
//        viewMenuPrincipal.setExtendedState(ViewMenuPrincipal.MAXIMIZED_BOTH);
//        viewMenuPrincipal.setVisible(true);// Visualizar frame
        test();
    }

    public static void test() {
        // Test
        DialogLogin dialogLogin = new DialogLogin();
        centerOnScreen(dialogLogin, true);
        dialogLogin.setVisible(true);
    }

    // Center on screen ( absolute true/false (exact center or 25% upper left) )
    public static void centerOnScreen(final Component c, final boolean absolute) {
        final int width = c.getWidth();
        final int height = c.getHeight();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width / 2) - (width / 2);
        int y = (screenSize.height / 2) - (height / 2);
        if (!absolute) {
            x /= 2;
            y /= 2;
        }
        c.setLocation(x, y);
    }
}
