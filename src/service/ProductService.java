package service;

import java.util.List;

import dao.ProductDao;
import entity.Product;

public class ProductService {
    private List<Product> products;
    ProductDao productDao = new ProductDao();

    public ProductService() {
        this.products = productDao.getAll();
    }

    public void add(Product product) {
        productDao.create(product);
        this.products = productDao.getAll();
    }

    public void edit(Product product){
        productDao.edit(product);
        this.products = productDao.getAll();
    }

    public void delete(int id){
        productDao.delete(id);
        this.products = productDao.getAll();
    }

    public List<Product> getProducts() {
        return products;
    }

}
