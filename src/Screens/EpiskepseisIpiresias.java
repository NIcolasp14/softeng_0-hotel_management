package Screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import Classes.ConnectSQL;
/*import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;*/

public class EpiskepseisIpiresias {
    private JTextField txtDate;
    private JTable tblEpiskepsis;
    private JTextField txtCost;
    private JComboBox cmbIpiresia;
    private JButton btnSearch;

    private DefaultTableModel model;
    Object[] columns = {"perigrafi_ipiresias","poso","hm_ora_eisodou","hm_ora_eksodou"};


    public EpiskepseisIpiresias() {
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    /*
        public EpiskepseisIpiresias() {
            txtDate.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    try {
                        String query="SELECT ";
                        PreparedStatement pst=connection.prepareStatement(query);
                        pst.setString(1,txtDate.getText());
                        ResultSet rs=pst.executeQuery();
                        tblEpiskepsis.setModel(DbU);


                    }catch()

                }
            });
        }
    */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel(0,4);
        model.setColumnIdentifiers(columns);
        try {
            tblEpiskepsis = new JTable(model);
            Connection c = ConnectSQL.get_connection();
            String query = "select perigrafi_ipiresias,x.poso,y.hm_ora_eisodou,y.hm_ora_eksodou\n" +
                           "from (ipiresies natural join xreosi_ipiresias) as x natural join episkeptontai as y ";
            PreparedStatement ps;
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
              Object[] row={rs.getString("perigrafi_ipiresias"),rs.getString("poso"),rs.getString("hm_ora_eisodou"),rs.getString("hm_ora_eksodou")};
                System.out.println(row);
                model.addRow(row);
            }
            rs.close();
            //ps.close();

        }catch (SQLClientInfoException er){
            er.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    }
}
