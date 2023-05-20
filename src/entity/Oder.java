package entity;

import java.util.Date;

public class Oder implements Comparable {
    private int id;
    private Customer customer;
    private User user;
    private int total;
    private Date date= new Date();

    public Oder() {
    }

    public Oder(Customer customer, User user, int total) {
        this.customer = customer;
        this.user = user;
        this.total = total;
    }

    public Oder(int id, Customer customer, User user, int total, Date date) {
        this.id = id;
        this.customer = customer;
        this.user = user;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Object o) {
        return date.compareTo(date);
    }
}
