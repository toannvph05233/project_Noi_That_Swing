package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import entity.Customer;
import service.CustomerService;


public class CustomerView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addCustomerViewBtn;
    private JButton editCustomerViewBtn;
    private JButton deleteCustomerViewBtn;
    private JButton clearCustomerViewBtn;
    private JButton AddCustomerViewToOder;
    private JButton backBtn;


    private JScrollPane jScrollPaneCustomerViewTable;

    private JTable CustomerViewTable;

    private JLabel idLabel;
    private JLabel nameCustomerViewLabel;
    private JLabel addressCustomerViewLabel;
    private JLabel phoneCustomerViewLabel;
    private JLabel emailCustomerViewLabel;

    private JTextField idCustomerViewField;
    private JTextField nameCustomerViewField;
    private JTextField addressCustomerViewField;
    private JTextField phoneCustomerViewField;
    private JTextField emailCustomerViewField;


    private JLabel titleCustomerViewLabel;


    private String[] columnCustomerView = new String[]{
            "Id", "Name", "Address", "Phone", "Email"};

    private Object data = new Object[][]{};

    public CustomerView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addCustomerViewBtn = new JButton("Add");
        editCustomerViewBtn = new JButton("Edit");
        deleteCustomerViewBtn = new JButton("Delete");
        clearCustomerViewBtn = new JButton("Clear");
        AddCustomerViewToOder = new JButton("Tạo Hóa Đơn");

        backBtn = new JButton("Back");

        jScrollPaneCustomerViewTable = new JScrollPane();
        CustomerViewTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameCustomerViewLabel = new JLabel("Name");
        addressCustomerViewLabel = new JLabel("Address");
        phoneCustomerViewLabel = new JLabel("Phone");
        emailCustomerViewLabel = new JLabel("Email");


        titleCustomerViewLabel = new JLabel("Danh Sách Khách Hàng");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleCustomerViewLabel.setFont(font);

        idCustomerViewField = new JTextField(15);
        idCustomerViewField.setEditable(false);

        nameCustomerViewField = new JTextField(15);
        addressCustomerViewField = new JTextField(15);
        phoneCustomerViewField = new JTextField(15);
        emailCustomerViewField = new JTextField(15);

        // cài đặt các cột và data cho bảng CustomerView
        CustomerViewTable.setModel(new DefaultTableModel((Object[][]) data, columnCustomerView));
        jScrollPaneCustomerViewTable.setViewportView(CustomerViewTable);
        jScrollPaneCustomerViewTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý CustomerView
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneCustomerViewTable);

        panel.add(addCustomerViewBtn);
        panel.add(editCustomerViewBtn);
        panel.add(deleteCustomerViewBtn);
        panel.add(clearCustomerViewBtn);
        panel.add(AddCustomerViewToOder);

        panel.add(backBtn);

        panel.add(idLabel);
        panel.add(nameCustomerViewLabel);
        panel.add(phoneCustomerViewLabel);
        panel.add(emailCustomerViewLabel);

        panel.add(addressCustomerViewLabel);

        panel.add(titleCustomerViewLabel);

        panel.add(idCustomerViewField);
        panel.add(nameCustomerViewField);
        panel.add(phoneCustomerViewField);

        panel.add(addressCustomerViewField);
        panel.add(phoneCustomerViewField);
        panel.add(emailCustomerViewField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameCustomerViewLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameCustomerViewLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressCustomerViewLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressCustomerViewLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneCustomerViewLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneCustomerViewLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, emailCustomerViewLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, emailCustomerViewLabel, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleCustomerViewLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleCustomerViewLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, backBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, backBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idCustomerViewField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idCustomerViewField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameCustomerViewField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameCustomerViewField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneCustomerViewField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneCustomerViewField, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, emailCustomerViewField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, emailCustomerViewField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressCustomerViewField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressCustomerViewField, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneCustomerViewTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCustomerViewTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addCustomerViewBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addCustomerViewBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editCustomerViewBtn, 70, SpringLayout.WEST, addCustomerViewBtn);
        layout.putConstraint(SpringLayout.NORTH, editCustomerViewBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteCustomerViewBtn, 70, SpringLayout.WEST, editCustomerViewBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteCustomerViewBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearCustomerViewBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearCustomerViewBtn, 75, SpringLayout.WEST, deleteCustomerViewBtn);

        layout.putConstraint(SpringLayout.NORTH, AddCustomerViewToOder, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, AddCustomerViewToOder, 65, SpringLayout.WEST, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Quản lý khách hàng");
        this.setSize(950, 380);
        // disable Edit and Delete buttons
        editCustomerViewBtn.setEnabled(false);
        deleteCustomerViewBtn.setEnabled(false);
        addCustomerViewBtn.setEnabled(true);

        editCustomerViewBtn.setEnabled(false);
        deleteCustomerViewBtn.setEnabled(false);
        addCustomerViewBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list CustomerView vào bảng CustomerViewTable
     *
     * @param list
     */
    public void showListCustomerViews(List<Customer> list) {
        int size = list.size();
        Object[][] CustomerViews = new Object[size][5];
        for (int i = 0; i < size; i++) {
            CustomerViews[i][0] = list.get(i).getId();
            CustomerViews[i][1] = list.get(i).getName();
            CustomerViews[i][2] = list.get(i).getAddress();
            CustomerViews[i][3] = list.get(i).getPhone();
            CustomerViews[i][4] = list.get(i).getEmail();

        }
        CustomerViewTable.setModel(new DefaultTableModel(CustomerViews, columnCustomerView));
    }

    public void clearCustomerViewInfo() {
        idCustomerViewField.setText("");
        nameCustomerViewField.setText("");
        addressCustomerViewField.setText("");
        phoneCustomerViewField.setText("");
        emailCustomerViewField.setText("");

        editCustomerViewBtn.setEnabled(false);
        deleteCustomerViewBtn.setEnabled(false);
        addCustomerViewBtn.setEnabled(true);
    }


    public Customer getCustomerViewInfo() {
        try {
            String name = nameCustomerViewField.getText();
            String address = addressCustomerViewField.getText();
            String phone = phoneCustomerViewField.getText();
            String email = emailCustomerViewField.getText();
            String id = idCustomerViewField.getText();
            if (id.equals("")) {
                return new Customer(name, address, phone, email);
            } else {
                int idC = Integer.parseInt(id);
                return new Customer(idC, name, address, phone, email);
            }


        } catch (Exception e) {
            return new Customer();

        }
    }

    public void BackProductListener(ActionListener listener) {
        backBtn.addActionListener(listener);
    }

    public void fillCustomerViewFromSelectedRow() {
        CustomerService CustomerViewFunc = new CustomerService();
        // lấy chỉ số của hàng được chọn
        int row = CustomerViewTable.getSelectedRow();
        if (row >= 0) {
            idCustomerViewField.setText(CustomerViewTable.getModel().getValueAt(row, 0).toString());
            nameCustomerViewField.setText(CustomerViewTable.getModel().getValueAt(row, 1).toString());
            addressCustomerViewField.setText(CustomerViewTable.getModel().getValueAt(row, 2).toString());
            phoneCustomerViewField.setText(CustomerViewTable.getModel().getValueAt(row, 3).toString());
            emailCustomerViewField.setText(CustomerViewTable.getModel().getValueAt(row, 4).toString());

            editCustomerViewBtn.setEnabled(true);
            deleteCustomerViewBtn.setEnabled(true);
            addCustomerViewBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddCustomerViewListener(ActionListener listener) {
        addCustomerViewBtn.addActionListener(listener);
    }

    public void addEditCustomerViewListener(ActionListener listener) {
        editCustomerViewBtn.addActionListener(listener);
    }

    public void addDeleteCustomerViewListener(ActionListener listener) {
        deleteCustomerViewBtn.addActionListener(listener);
    }

    public void addClearCustomerViewListener(ActionListener listener) {
        clearCustomerViewBtn.addActionListener(listener);
    }

    public void addCustomerViewToOderListener(ActionListener listener) {
        AddCustomerViewToOder.addActionListener(listener);
    }

    public void addListCustomerViewSelectionListener(ListSelectionListener listener) {
        CustomerViewTable.getSelectionModel().addListSelectionListener(listener);
    }


}
