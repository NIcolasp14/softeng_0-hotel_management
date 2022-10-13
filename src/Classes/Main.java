package Classes;

import Screens.InsertCustomer;
import Screens.Krousma9;

import javax.swing.*;
import javax.swing.JTable;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
public class Main {

    public static void main(String[] args) {
        Connection con = ConnectSQL.get_connection();

        if (con != null) {
            // Do something.
            System.out.println("Ready!");
        }
        JFrame f=new JFrame("Customer Data");
        f.setSize(300,300);
        f.add(new Krousma9().Krousma9);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
