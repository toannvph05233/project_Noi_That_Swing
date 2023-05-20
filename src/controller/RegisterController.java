package controller;

import entity.User;
import service.UserService;
import view.LoginView;
import view.RegisterView;
import view.OderView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private UserService userDao;
    private LoginView loginView;
    private RegisterView registerView;

    private OderView oderView;
    public RegisterController(LoginView view, RegisterView registerView) {
        this.loginView = view;
        this.registerView = registerView;
        this.userDao = new UserService();
        registerView.addRegisterListener(new RegisterListener());
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = registerView.getUser();
            if (userDao.checkUserName(user)) {
                userDao.add(user);
                loginView.setVisible(true);
                registerView.setVisible(false);
            } else {
                registerView.showMessage("username đang bị trùng hoặc để trống");
            }
        }
    }
}
