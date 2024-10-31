package controllers;

import core.utils.Util;
import java.beans.PropertyVetoException;
import views.DialogLogin;

public class Main {

    public static Util util = new Util();

    public static void main(String[] args) throws PropertyVetoException {
        DialogLogin dialogLogin = new DialogLogin();
        util.centerOnScreen(dialogLogin, true);
        dialogLogin.setVisible(true);
    }
}
