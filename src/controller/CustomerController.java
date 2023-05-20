package controller;

import entity.Customer;
import entity.Oder;
import service.CustomerService;
import service.OderService;
import service.StaticVariable;
import view.CustomerView;
import view.ManagerView;
import view.OderDetailView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerController {
    private CustomerService customerService = new CustomerService();
    private CustomerView customerView;
    private OderService oderService;
    private OderDetailView oderDetailView;
    private OderDetailController oderDetailController;
    private ManagerView managerView;

    public CustomerController(ManagerView managerView,CustomerView customerView, OderDetailView oderDetailView, OderDetailController oderDetailController) {
        this.oderDetailView = oderDetailView;
        this.managerView = managerView;
        this.customerView = customerView;
        this.oderService = new OderService();
        this.oderDetailController = oderDetailController;
        customerView.addListCustomerViewSelectionListener(new ListCustomerSelectionListener());
        customerView.addAddCustomerViewListener(new AddCustomerListener());
        customerView.addClearCustomerViewListener(new ClearCustomerListener());
        customerView.addEditCustomerViewListener(new EditCustomerListener());
        customerView.addDeleteCustomerViewListener(new DeleteCustomerListener());
        customerView.addCustomerViewToOderListener(new CreateOderCustomerListener());
        customerView.BackProductListener(new BackProductListener());

    }

    public void showCustomers() {
        customerView.setVisible(true);
        customerView.showListCustomerViews(customerService.getCustomers());
    }

    class ListCustomerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            customerView.fillCustomerViewFromSelectedRow();
        }
    }


    class AddCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = customerView.getCustomerViewInfo();
            if (Customer != null) {
                customerService.add(Customer);
                customerView.showListCustomerViews(customerService.getCustomers());
                customerView.showMessage("Thêm thành công!");
            }
        }
    }


    class EditCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = customerView.getCustomerViewInfo();
            if (Customer != null) {
                customerService.edit(Customer);
                customerView.showListCustomerViews(customerService.getCustomers());
                customerView.showMessage("Sửa thành công!");
            }
        }
    }


    class ClearCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerView.clearCustomerViewInfo();
        }
    }


    class DeleteCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer Customer = customerView.getCustomerViewInfo();
            if (Customer != null) {
                customerService.delete(Customer.getId());
                customerView.showListCustomerViews(customerService.getCustomers());
                customerView.showMessage("Xóa thành công!");
            }
        }
    }

    class BackProductListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerView.setVisible(false);
            managerView.setVisible(true);
        }
    }

    class CreateOderCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            StaticVariable.customer = customerView.getCustomerViewInfo();
            Oder oder = new Oder(StaticVariable.customer, StaticVariable.user,0);
            oderService.add(oder);
            customerView.showMessage("Thêm thành công!");
            customerView.setVisible(false);
            oderDetailController.showProducts();

        }
    }
}
