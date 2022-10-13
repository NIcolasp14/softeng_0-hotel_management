package Screens;

import Classes.ConnectSQL;
import Classes.Customer.Customer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import static Classes.MyConnectionProvider.getCon;


public class InsertCustomer {
    public JPanel Insert;
    private JButton btnCancel;
    private JButton btninsertclose;
    private JButton btninsertnew;
    private JTextField txtOnoma;
    private JTextField txtID;
    private JTextField txtBirth;
    private JTextField txtArithmos;
    private JTextField txtArxi;
    private JTextField txtemail;
    private JTextField txtphone;
    private JTextField txtEpitheto;
    private JComboBox cmbEidos;
    private JCheckBox chkgym;
    private JCheckBox chksaouna;
    private JCheckBox chksine;
    private JTable tblCustomer;
    Object[] columns = {"nfc_id","Onoma","Eponimo","Hm_gennisisi","Arithmos_Eggrafou","Tipos_Eggrafou","Arxi_Ekdosis","email","phone"};


   /* public ArrayList<Customer> getUsersList()
    {
        ArrayList<Customer> usersList = new ArrayList<Customer>();
        Connection connection = getCon();

        String query = "SELECT * FROM  'Customer' ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            Customer Cust;

            while(rs.next())
            {
                Cust = new Customer(rs.getString("nfc_id"),rs.getString("onoma "),rs.getString("eponimo"),rs.getString("hm_gennisis"),rs.getString("arithmos_eggrafou "),rs.getString("eidos_eggrafou"),rs.getString("arxi_ekdosis"),rs.getString("email "),rs.getString("phone"));
                usersList.add(Cust);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }


    public void showItem(int index)
    {
        jTextField_id.setText(getItemsList().get(index).getId());

        jTextField_name.setText(getItemsList().get(index).getName());

        jTextArea_description.setText(getItemsList().get(index).getDescription());

        ImageIcon icon = new ImageIcon(getItemsList().get(index).getImage());

        Image image = icon.getImage().getScaledInstance(jLabel_image.getWidth(),
                jLabel_image.getHeight(), Image.SCALE_SMOOTH);

        jLabel_image.setIcon(new ImageIcon(image));
    }

    public void executeSQlQuery(String query, String message)
    {
        Connection con = getCon();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();

                JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public InsertCustomer() {
        btninsertnew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cust=new Customer();
                cust.setOnoma(txtOnoma.getText());
                cust.setEponimo(txtEpitheto.getText());
                cust.setNFC_ID(txtID.getText());
                cust.setHm_Gennisis(txtBirth.getText());
                cust.setArithmos_Eggrafou(txtArithmos.getText());
                cust.setArxi_Ekdosis(txtArxi.getText());
                cust.setEmail(txtemail.getText());
                cust.setPhone(txtphone.getText());
                cust.setEidos_Eggrafou(cmbEidos.toString());
            }
        });
        tblCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }*/

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model=new DefaultTableModel(0,9);
        model.setColumnIdentifiers(columns);
        try {
            tblCustomer = new JTable(model);
            Connection c = Classes.ConnectSQL.get_connection();

            String query = "SELECT * FROM  Customer ";
            Statement s = c.createStatement();
            ResultSet rs=s.executeQuery(query);

            while(rs.next()){
                Object[] row={rs.getString("nfc_id"),rs.getString("onoma"),rs.getString("eponimo"),rs.getString("hm_gennisis"),rs.getString("arithmos_eggrafou"),rs.getString("eidos_eggrafou"),rs.getString("arxi_ekdosis"),rs.getString("email"),rs.getString("phone")};
                model.addRow(row);
            }
        }catch (SQLClientInfoException e){
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
