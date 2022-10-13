package Screens;

import Classes.ConnectSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Krousma9 {
    public JTable tblKrousma;
    public JPanel Krousma9;
    private JTextField txtOnoma;
    private JButton btnSearch;
    private JTextField txtEpitheto;
    private DefaultTableModel model;
    Object[] columns = {"onomasia_xorou","id_Xorou","hm_ora_eisodou","hm_ora_eksodou"};

    public Krousma9() {
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
//                    tblKrousma = new JTable(model);
                    Connection c = ConnectSQL.get_connection();

                    PreparedStatement ps;
                    ps = c.prepareStatement("SELECT onomasia_xorou,id_xorou,hm_ora_eisodou,hm_ora_eksodou FROM ( (SELECT nfc_id FROM  Customer WHERE Customer.onoma = ? AND Customer.eponimo = ?) as x NATURAL JOIN episkeptontai) as y NATURAL JOIN xoroi ");
                    ps.setString(1,txtOnoma.getText());
                    ps.setString(2,txtEpitheto.getText());

                    ResultSet rs = ps.executeQuery();

                    while(rs.next()){

                        Object[] row = {rs.getString("onomasia_xorou"),rs.getString("id_xorou"),rs.getString("hm_ora_eisodou"),rs.getString("hm_ora_eksodou")};

                        model.addRow(row);
                    }
                    rs.close();
                    ps.close();
                }catch (SQLClientInfoException er){
                    er.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel(0,4);
        model.setColumnIdentifiers(columns);
        try {
            tblKrousma = new JTable(model);
            Connection c = ConnectSQL.get_connection();
            String query = "SELECT onomasia_xorou,id_xorou,hm_ora_eisodou,hm_ora_eksodou \n" +
                    "FROM ( (SELECT nfc_id \n" +
                    "\t  FROM  Customer \n" +
                    "\t  WHERE Customer.onoma='Warde' AND Customer.eponimo='de Vaen') as x NATURAL JOIN episkeptontai) as y NATURAL JOIN xoroi ";
            PreparedStatement ps;
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery(query);
//            while(rs.next()){
//                Object[] row={rs.getString("onomasia_xorou"),rs.getString("id_xorou"),rs.getString("hm_ora_eisodou"),rs.getString("hm_ora_eksodou")};
//                System.out.println(row);
//                model.addRow(row);
//            }
            rs.close();
            //ps.close();

        }catch (SQLClientInfoException er){
            er.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
