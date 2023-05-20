package controller;

import view.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerController {
    ManagerView managerView;
    CustomerController customerController;
    ProductController productController;
    OderController oderController;

    public ManagerController(ManagerView managerView, CustomerController customerController, ProductController productController, OderController oderController) {
        this.managerView = managerView;
        this.customerController = customerController;
        this.productController = productController;
        this.oderController = oderController;
        this.managerView.addOderListener(new OderListener());
        this.managerView.addProductListener(new ProductListener());
        this.managerView.addCustomerListener(new CustomerListener());
    }
    public void show(){
        managerView.setVisible(true);
    }

    class CustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.setVisible(false);
            customerController.showCustomers();
        }
    }
    class ProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.setVisible(false);
            productController.showProducts();
        }
    }

    class OderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            managerView.setVisible(false);
            oderController.showOderView();
        }
    }
}
