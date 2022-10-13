package Interfaces;

import Classes.Customer.*;

public interface Customercrud {
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(String usr);
    void updateBill(String usr);
    Classes.Customer.Customer getCustomer(String email, String pass);
    Classes.Customer.Customer getCustomer(String usr);
    Classes.Customer.Customer getCustomerbyPN(String pn);

}
