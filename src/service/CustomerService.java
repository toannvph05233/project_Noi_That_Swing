package service;

import dao.CustomerDao;
import entity.Customer;

import java.util.List;

public class CustomerService {
    private List<Customer> customers;
    CustomerDao CustomerDao = new CustomerDao();

    public CustomerService() {
        this.customers = CustomerDao.getAll();
    }

    public void add(Customer Customer) {
        CustomerDao.create(Customer);
        this.customers = CustomerDao.getAll();
    }

    public void edit(Customer Customer){
        CustomerDao.edit(Customer);
        this.customers = CustomerDao.getAll();
    }

    public void delete(int id){
        CustomerDao.delete(id);
        this.customers = CustomerDao.getAll();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
