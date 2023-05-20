import java.awt.EventQueue;

import controller.*;
import view.*;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                RegisterView registerView = new RegisterView();
                OderView oderView = new OderView();
                CustomerView customerView = new CustomerView();
                OderDetailView oderDetailView = new OderDetailView();
                ProductView productView = new ProductView();
                ManagerView managerView = new ManagerView();


                ProductController productController = new ProductController(productView, managerView);
                OderController oderController = new OderController(oderView);
                OderDetailController oderDetailController = new OderDetailController(oderDetailView, customerView);
                RegisterController registerController = new RegisterController(view, registerView);
                CustomerController customerController = new CustomerController(managerView, customerView, oderDetailView, oderDetailController);
                ManagerController managerController = new ManagerController(managerView, customerController, productController, oderController);
                LoginController loginController = new LoginController(managerController, customerController, view, registerView, customerView, oderView);

                loginController.showLoginView();
            }
        });
    }
}