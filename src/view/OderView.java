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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entity.Oder;
import entity.OderDetail;
import service.OderDetailService;

public class OderView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addCustomerBtn;
    //    private JButton DiagnoseBtn;
    private JButton editCustomerBtn;
    private JButton deleteCustomerBtn;
    private JButton clearBtn;
    private JButton showAllBtn;
    private JButton searchBtn;
    private JButton sortCustomerNameBtn;
    private JScrollPane jScrollPaneCustomerTable;
    private JScrollPane jScrollPaneAddress;
    private JScrollPane jScrollPaneOderDetailTable;


    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel searchLabel;
    private JTable OderTable;
    private JTable OderDetailTable;


    private JLabel titleCustomerLabel;
    private JLabel titleLabel;

    private JTextField searchField;

    private JTextField idField;
    private JTextField nameField;
    private JTextArea addressTA;
    private JTextField phoneField;

    // định nghĩa các cột của bảng student
    private String[] columnOder = new String[]{
            "Id", "Name Customer", "Address Customer", "Phone Customer", "Total", "Date"};

    private Object data = new Object[][]{};

    public OderView() {
        initComponents();
    }

    private Object data2 = new Object[][]{};
    private String[] columnOderDetail = new String[]{
            "Id", "Quantity", "Name Product", "Name Customer", "Price"};


    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addCustomerBtn = new JButton("Add");
//        DiagnoseBtn = new JButton("Hóa Đơn Chi Tiết");
//        DiagnoseBtn.setBackground(Color.BLUE);
        editCustomerBtn = new JButton("Edit");
        deleteCustomerBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        searchBtn = new JButton("Search");
        showAllBtn = new JButton("Show All Oder");

        sortCustomerNameBtn = new JButton("Sort By Name");

        jScrollPaneCustomerTable = new JScrollPane();
        jScrollPaneOderDetailTable = new JScrollPane();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        addressLabel = new JLabel("Address");
        phoneLabel = new JLabel("Phone");
        searchLabel = new JLabel("Search Name");


        titleLabel = new JLabel("Danh Sách Hóa Đơn");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleLabel.setFont(font);
        OderTable = new JTable();

        jScrollPaneOderDetailTable = new JScrollPane();
        OderDetailTable = new JTable();


        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(15);
        idField.setEditable(false);
        nameField = new JTextField(15);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        phoneField = new JTextField(15);
        searchField = new JTextField(15);

        OderDetailTable.setModel(new DefaultTableModel((Object[][]) data2, columnOderDetail));
        OderTable.setModel(new DefaultTableModel((Object[][]) data, columnOder));
        jScrollPaneCustomerTable.setViewportView(OderTable);
        jScrollPaneCustomerTable.setPreferredSize(new Dimension(550, 200));

        jScrollPaneOderDetailTable.setViewportView(OderDetailTable);
        jScrollPaneOderDetailTable.setPreferredSize(new Dimension(750, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneCustomerTable);
        panel.add(jScrollPaneOderDetailTable);

        panel.add(addCustomerBtn);
//        panel.add(DiagnoseBtn);
        panel.add(editCustomerBtn);
        panel.add(deleteCustomerBtn);
        panel.add(clearBtn);
        panel.add(showAllBtn);
        panel.add(searchBtn);
        panel.add(titleLabel);

        panel.add(sortCustomerNameBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);

        panel.add(searchLabel);

        panel.add(idField);
        panel.add(nameField);
        panel.add(jScrollPaneAddress);
        panel.add(phoneField);
        panel.add(searchField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 250, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, searchLabel, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchField, 100, SpringLayout.WEST, searchLabel);
        layout.putConstraint(SpringLayout.NORTH, searchField, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchBtn, 190, SpringLayout.WEST, searchField);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneField, 250, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneCustomerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCustomerTable, 60, SpringLayout.NORTH, panel);

//        layout.putConstraint(SpringLayout.WEST, DiagnoseBtn, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, DiagnoseBtn, 290, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addCustomerBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addCustomerBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editCustomerBtn, 80, SpringLayout.WEST, addCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, editCustomerBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteCustomerBtn, 80, SpringLayout.WEST, editCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteCustomerBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteCustomerBtn);


        layout.putConstraint(SpringLayout.NORTH, sortCustomerNameBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortCustomerNameBtn, 80, SpringLayout.WEST, clearBtn);
        layout.putConstraint(SpringLayout.NORTH, showAllBtn, 340, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, showAllBtn, 180, SpringLayout.NORTH, sortCustomerNameBtn);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneOderDetailTable, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneOderDetailTable, 395, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Customer Information");
        this.setSize(950, 660);
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        addCustomerBtn.setEnabled(true);
        setLocationRelativeTo(null);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list student vào bảng studentTable
     *
     * @param list
     */
    public void showListOder(List<Oder> list) {
        int size = list.size();

        Object[][] oders = new Object[size][6];
        for (int i = 0; i < size; i++) {
            oders[i][0] = list.get(i).getId();
            oders[i][1] = list.get(i).getCustomer().getName();
            oders[i][2] = list.get(i).getCustomer().getAddress();
            oders[i][3] = list.get(i).getCustomer().getPhone();
            oders[i][4] = list.get(i).getTotal();
            oders[i][5] = format.format(list.get(i).getDate());
        }
        OderTable.setModel(new DefaultTableModel(oders, columnOder));
    }

    public void showListOderDetail(List<OderDetail> list) {
        int size = list.size();
        Object[][] OderDetail = new Object[size][5];
        for (int i = 0; i < size; i++) {
            OderDetail[i][0] = list.get(i).getId();
            OderDetail[i][1] = list.get(i).getQuantity();
            OderDetail[i][2] = list.get(i).getProduct().getName();
            OderDetail[i][3] = list.get(i).getOder().getCustomer().getName();
            OderDetail[i][4] = list.get(i).getProduct().getPrice();
        }
        OderDetailTable.setModel(new DefaultTableModel(OderDetail, columnOderDetail));
    }

    OderDetailService oderDetailService = new OderDetailService();

    /**
     * điền thông tin của hàng được chọn từ bảng student
     * vào các trường tương ứng của student.
     */
    public void fillOderFromSelectedRow() {
        int row = OderTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(OderTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(OderTable.getModel().getValueAt(row, 1).toString());
            addressTA.setText(OderTable.getModel().getValueAt(row, 2).toString());
            phoneField.setText(OderTable.getModel().getValueAt(row, 3).toString());

            int idOder = Integer.parseInt(idField.getText());
            List<OderDetail> oderDetails = oderDetailService.getOderDetailByOder(idOder);
            showListOderDetail(oderDetails);
            // enable Edit and Delete buttons
            editCustomerBtn.setEnabled(true);
            deleteCustomerBtn.setEnabled(true);
            // disable Add button
            addCustomerBtn.setEnabled(false);
        }
    }


    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        addressTA.setText("");
        phoneField.setText("");
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        // enable Add button
        addCustomerBtn.setEnabled(true);
    }


    public void showOder(Oder oder) {
        idField.setText("" + oder.getId());
        nameField.setText(oder.getCustomer().getName());
        addressTA.setText(oder.getCustomer().getAddress());
        phoneField.setText("" + oder.getCustomer().getPhone());
        // enable Edit and Delete buttons
        editCustomerBtn.setEnabled(true);
        deleteCustomerBtn.setEnabled(true);
        // disable Add button
        addCustomerBtn.setEnabled(false);
    }

    public String getNameSearch() {
        String name = searchField.getText();
        if (!name.equals("")) {
            return name;
        }
        return null;
    }

    /**
     * lấy thông tin student
     *
     * @return
     */
    public Oder getOderInfo() {
        // validate student
        if (!validateName() || !validateAddress() || !validatePhone()) {
            return null;
        }
        try {
            Oder oder = new Oder();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                oder.setId(Integer.parseInt(idField.getText()));
            }
//            oder.setNameCustomer(nameField.getText().trim());
//            oder.setAddressCustomer(addressTA.getText().trim());
//            oder.setPhoneCustomer(phoneField.getText().trim());
            return oder;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }


    public int getIdCustomer() {
        String id = idField.getText();
        if (id.equals("")) {
            return -1;
        }
        return Integer.parseInt(id);
    }

    public String getNameCustomer() {
        return nameField.getText();
    }
    public int getIdOder() {
        return Integer.parseInt(idField.getText());
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }

    private boolean validatePhone() {
        try {
            Integer.parseInt(phoneField.getText().trim());

            if (phoneField.getText().trim().length() != 10) {
                phoneField.requestFocus();
                showMessage("Phone không hợp lệ, phải là 10 ký tự.");
                return false;
            }
        } catch (Exception e) {
            phoneField.requestFocus();
            showMessage("Phone phải là số");
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addCustomerBtn.addActionListener(listener);
    }

    public void searchCustomerListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    public void showAllCustomerListener(ActionListener listener) {
        showAllBtn.addActionListener(listener);
    }


    public void addEdiStudentListener(ActionListener listener) {
        editCustomerBtn.addActionListener(listener);
    }


    public void addDeleteStudentListener(ActionListener listener) {
        deleteCustomerBtn.addActionListener(listener);
        OderDetailTable.setModel(new DefaultTableModel((Object[][]) data2, columnOderDetail));
    }


    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
//    public void diagnoseDetail(ActionListener listener) {
//        DiagnoseBtn.addActionListener(listener);
//    }



    public void addSortStudentNameListener(ActionListener listener) {
        sortCustomerNameBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        OderTable.getSelectionModel().addListSelectionListener(listener);
    }

}
