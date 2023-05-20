package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Product;
import service.UserService;
import entity.User;
import view.CustomerView;
import view.LoginView;
import view.RegisterView;
import view.OderView;

public class LoginController {
    private UserService userDao;
    private LoginView loginView;
    private RegisterView registerView;
    private CustomerView customerView;
    private ManagerController managerController;
    private CustomerController customerController;

    public LoginController(ManagerController managerController, CustomerController customerController, LoginView view, RegisterView registerView, CustomerView customerView, OderView oderView) {
        this.customerController = customerController;
        this.customerView = customerView;
        this.loginView = view;
        this.registerView = registerView;
        this.managerController = managerController;
        this.userDao = new UserService();
        view.addLoginListener(new LoginListener());
        view.showRegisterView(new RegisterListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     *
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User userLogin = loginView.getUser();
            User user = userDao.login(userLogin);
            if (user != null) {
                if (user.getRole().equals("admin")) {
                    managerController.show();
                } else {
                    customerController.showCustomers();
                }
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            registerView.setVisible(true);
        }
    }
}