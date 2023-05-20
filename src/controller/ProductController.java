package controller;

import entity.Product;
import service.ProductService;
import view.ManagerView;
import view.ProductView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController {
    private ProductService productService;
    private ProductView productView;
    private ManagerView managerView;

    public ProductController(ProductView productView, ManagerView managerView) {
        this.productService = new ProductService();
        this.managerView = managerView;
        this.productView = productView;
        productView.addListProductSelectionListener(new ListProductSelectionListener());
        productView.addAddProductListener(new AddProductListener());
        productView.addClearProductListener(new ClearProductListener());
        productView.addEditProductListener(new EditProductListener());
        productView.addDeleteProductListener(new DeleteProductListener());
        productView.backProductListener(new BackProductListener());

    }

    public void showProducts() {
        productView.setVisible(true);
        productView.showListProducts(productService.getProducts());
    }

    class ListProductSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            productView.fillProductFromSelectedRow();
        }
    }


    class AddProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = productView.getProductInfo();
            if (Product != null) {
                productService.add(Product);
                productView.showListProducts(productService.getProducts());
                productView.showMessage("Thêm thành công!");
            }
        }
    }


    class EditProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = productView.getProductInfo();
            if (Product != null) {
                productService.edit(Product);
                productView.showListProducts(productService.getProducts());
                productView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            productView.clearProductInfo();
        }
    }

    class BackProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            productView.setVisible(false);
            managerView.setVisible(true);
        }
    }


    class DeleteProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product Product = productView.getProductInfo();
            if (Product != null) {
                productService.delete(Product.getId());
                productView.showListProducts(productService.getProducts());
                productView.showMessage("Xóa thành công!");
            }
        }
    }
}
