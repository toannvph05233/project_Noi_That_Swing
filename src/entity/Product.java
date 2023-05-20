package entity;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String content;
    private int price;
    private int quantity;
    private Date date = new Date();

    public Product() {
    }

    public Product(String name, String content, int price, int quantity) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.quantity = quantity;
        this.date = new Date();
    }

    public Product(int id, String name, String content, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
        this.quantity = quantity;
        this.date = new Date();
    }

    public Product(int id, String name, String content, int price, int quantity, Date date) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
