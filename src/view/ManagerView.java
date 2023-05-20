package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class ManagerView extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton userBtn;
    private JButton productBtn;
    private JButton oderBtn;
    private JButton customerBtn;

    public ManagerView() {
        // Tạo frame chính
        frame = new JFrame("Manager View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Tạo panel chứa các component
        panel = new JPanel();

        // Tạo các JButton
        userBtn = new JButton("Quản Lý User");
        productBtn = new JButton("Quản Lý Product");
        oderBtn = new JButton("Quản Lý Oder");
        customerBtn = new JButton("Quản Lý Customer");

        // Thêm các JButton vào panel
        panel.add(userBtn);
        panel.add(productBtn);
        panel.add(oderBtn);
        panel.add(customerBtn);

        // Thêm panel vào frame
        frame.getContentPane().add(panel);
        // Hiển thị frame
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public void addUserListener(ActionListener listener) {
        userBtn.addActionListener(listener);
    }

    public void addProductListener(ActionListener listener) {
        productBtn.addActionListener(listener);
    }

    public void addOderListener(ActionListener listener) {
        oderBtn.addActionListener(listener);
    }
    public void addCustomerListener(ActionListener listener) {
        customerBtn.addActionListener(listener);
    }


    public static void main(String[] args) {
        // Tạo đối tượng ManagerView
        ManagerView managerView = new ManagerView();
    }
}
