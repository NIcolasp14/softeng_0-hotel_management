package Classes.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Classes.ConnectSQL;

public class CustomerDAOImpl{

   /* private static Connection connection;
    private static PreparedStatement ps;

    @Override
    public void insertCustomer(Customer customer) {

        try {

            Connection connection = Classes.ConnectSQL.get_connection();
            ps = connection.prepareStatement("INSERT INTO Customer(NFC_ID,Onoma,Eponimo,Hm_Gennisis,getArithmos_Eggrafou,Eidos_Eggrafou,Arxi_Ekdosis,Phone,Email) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, customer.getNFC_ID());
            ps.setString(2, customer.getOnoma());
            ps.setString(3,customer.getEponimo());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getHm_Gennisis());
            ps.setString(7, customer.getEidos_Eggrafou());
            ps.setString(8, customer.getArxi_Ekdosis());
            ps.setString(9, customer.getPhone());


            ps.executeUpdate();

            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }

    }
    ps = connection.prepareStatement("UPDATE client SET first_name=?,last_name=?,password=?,alas=?,country=?,city=?,street_address=?,postal_code=? WHERE username=?");
    @Override
    public void updateCustomer(Customer customer) {

        try{

            Connection connection = Classes.ConnectSQL.get_connection();
            ps = connection.prepareStatement("UPDATE client SET first_name=?,last_name=?,password=?,alas=?,country=?,city=?,street_address=?,postal_code=? WHERE username=?");
            ps.setString(1, customer.getNFC_ID());
            ps.setString(2, customer.getOnoma());
            ps.setString(3,customer.getEponimo());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getHm_Gennisis());
            ps.setString(7, customer.getEidos_Eggrafou());
            ps.setString(8, customer.getArxi_Ekdosis());
            ps.setString(9, customer.getPhone());


            ps.executeUpdate();

            connection.close();
        }catch (Exception e){

            e.getStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String usr) {

        try{

            connection = Classes.MyConnectionProvider.getCon();
            ps = connection.prepareStatement("DELETE FROM client WHERE username=?");
            ps.setString(1, usr);

            ps.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String email, String pass) {

        byte[] salt = null;
        Customer customer = new Customer();
        try{

            connection = Classes.MyConnectionProvider.getCon();

            ps = connection.prepareStatement("SELECT alas FROM client WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                salt = rs.getBytes(1);
            }

            String sc = hashing.Sha_512(pass, salt);

            ps = connection.prepareStatement("SELECT * FROM client WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, sc);

            rs = ps.executeQuery();
            while (rs.next()){
                customer.setUsr(rs.getString(1));
                customer.setFirstname(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setPassword(rs.getString(5));
                customer.setSalt(rs.getBytes(6));
                customer.setAfm(rs.getString(7));
                customer.setPhonenumber(rs.getString(8));
                customer.setCountry(rs.getString(9));
                customer.setCity(rs.getString(10));
                customer.setAddress(rs.getString(11));
                customer.setPCode(rs.getString(12));
                customer.setProgram(rs.getString(13));
            }
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }

        return customer;
    }

    @Override
    public Customer getCustomer(String usr) {
        Customer customer = new Customer();

        try {

            connection = Classes.MyConnectionProvider.getCon();
            ps = connection.prepareStatement("SELECT * FROM client WHERE username=?");
            ps.setString(1, usr);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                customer.setUsr(rs.getString(1));
                customer.setFirstname(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setPassword(rs.getString(5));
                customer.setSalt(rs.getBytes(6));
                customer.setAfm(rs.getString(7));
                customer.setPhonenumber(rs.getString(8));
                customer.setCountry(rs.getString(9));
                customer.setCity(rs.getString(10));
                customer.setAddress(rs.getString(11));
                customer.setPCode(rs.getString(12));
                customer.setProgram(rs.getString(13));
            }
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }
        return customer;
    }

    @Override
    public Customer getCustomerbyPN(String pn) {
        Customer customer = new Customer();

        try {

            connection = Classes.MyConnectionProvider.getCon();
            ps = connection.prepareStatement("SELECT * FROM client WHERE phone_number=?");
            ps.setString(1, pn);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                customer.setUsr(rs.getString(1));
                customer.setFirstname(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setEmail(rs.getString(4));
                customer.setPassword(rs.getString(5));
                customer.setSalt(rs.getBytes(6));
                customer.setAfm(rs.getString(7));
                customer.setPhonenumber(rs.getString(8));
                customer.setCountry(rs.getString(9));
                customer.setCity(rs.getString(10));
                customer.setAddress(rs.getString(11));
                customer.setPCode(rs.getString(12));
                customer.setProgram(rs.getString(13));
            }
            connection.close();
        }catch (Exception e){
            e.getStackTrace();
        }
        return customer;
    }*/
}
