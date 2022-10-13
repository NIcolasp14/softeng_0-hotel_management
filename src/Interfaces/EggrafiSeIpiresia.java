package Interfaces;

import Classes.Customer.Customer;

public interface EggrafiSeIpiresia
{
    void insertEggrafi(Customer customer);
    void updateEggrafi(Customer customer);
    void deleteEggrafi(String usr);
    Classes.Customer.Customer getCustomer(String email, String pass);
    Classes.Customer.Customer getCustomer(String usr);
    Classes.Customer.Customer getCustomerbyPN(String pn);
}
