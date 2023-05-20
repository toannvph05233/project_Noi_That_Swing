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


import entity.Product;
import service.ProductService;


public class ProductView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addProductBtn;
    private JButton editProductBtn;
    private JButton deleteProductBtn;
    private JButton clearProductBtn;

    private JButton backBtn;

    private JScrollPane jScrollPaneProductTable;

    private JTable ProductTable;

    private JLabel idLabel;
    private JLabel ProductLabel;
    private JLabel PriceProductLabel;
    private JLabel QuantityProductLabel;
    private JLabel contentProductLabel;

    private JTextField idProductField;
    private JTextField ProductField;
    private JTextField PriceProductField;
    private JTextField QuantityProductField;
    private JTextField contentProductField;


    private JLabel titleProductLabel;


    private String[] columnProduct = new String[]{
            "Id", "Name", "Price", "Quantity", "Content", "Date"};

    private Object data = new Object[][]{};

    public ProductView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addProductBtn = new JButton("Add");
        editProductBtn = new JButton("Edit");
        deleteProductBtn = new JButton("Delete");
        clearProductBtn = new JButton("Clear");
        backBtn = new JButton("Back");


        jScrollPaneProductTable = new JScrollPane();
        ProductTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        ProductLabel = new JLabel("Name");
        PriceProductLabel = new JLabel("Price");
        QuantityProductLabel = new JLabel("Quantity");
        contentProductLabel = new JLabel("Content");


        titleProductLabel = new JLabel("Danh Sách Sản Phẩm");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleProductLabel.setFont(font);

        idProductField = new JTextField(15);
        idProductField.setEditable(false);
        ProductField = new JTextField(15);

        PriceProductField = new JTextField(15);
        QuantityProductField = new JTextField(15);
        contentProductField = new JTextField(15);

        // cài đặt các cột và data cho bảng Product
        ProductTable.setModel(new DefaultTableModel((Object[][]) data, columnProduct));
        jScrollPaneProductTable.setViewportView(ProductTable);
        jScrollPaneProductTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Product
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneProductTable);

        panel.add(addProductBtn);
        panel.add(editProductBtn);
        panel.add(deleteProductBtn);
        panel.add(clearProductBtn);


        panel.add(backBtn);

        panel.add(idLabel);
        panel.add(ProductLabel);
        panel.add(QuantityProductLabel);
        panel.add(contentProductLabel);

        panel.add(PriceProductLabel);

        panel.add(titleProductLabel);

        panel.add(idProductField);
        panel.add(ProductField);
        panel.add(QuantityProductField);

        panel.add(PriceProductField);
        panel.add(QuantityProductField);
        panel.add(contentProductField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ProductLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, PriceProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, PriceProductLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, QuantityProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, QuantityProductLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, contentProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, contentProductLabel, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleProductLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleProductLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, backBtn, 790, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, backBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idProductField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ProductField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, QuantityProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, QuantityProductField, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, PriceProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, PriceProductField, 120, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, contentProductField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, contentProductField, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneProductTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneProductTable, 60, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addProductBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addProductBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editProductBtn, 70, SpringLayout.WEST, addProductBtn);
        layout.putConstraint(SpringLayout.NORTH, editProductBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteProductBtn, 70, SpringLayout.WEST, editProductBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteProductBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearProductBtn, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearProductBtn, 75, SpringLayout.WEST, deleteProductBtn);


        this.add(panel);
        this.pack();
        this.setTitle("Quản lý sản phẩm");
        this.setSize(950, 380);
        // disable Edit and Delete buttons
        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);

        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list Product vào bảng ProductTable
     *
     * @param list
     */
    public void showListProducts(List<Product> list) {
        int size = list.size();
        Object[][] Products = new Object[size][6];
        for (int i = 0; i < size; i++) {
            Products[i][0] = list.get(i).getId();
            Products[i][1] = list.get(i).getName();
            Products[i][2] = list.get(i).getPrice();
            Products[i][3] = list.get(i).getQuantity();
            Products[i][4] = list.get(i).getContent();
            Products[i][5] = formatter.format(list.get(i).getDate());

        }
        ProductTable.setModel(new DefaultTableModel(Products, columnProduct));
    }

    public void clearProductInfo() {
        idProductField.setText("");
        ProductField.setText("");
        PriceProductField.setText("");
        QuantityProductField.setText("");
        contentProductField.setText("");

        editProductBtn.setEnabled(false);
        deleteProductBtn.setEnabled(false);
        addProductBtn.setEnabled(true);
    }


    public Product getProductInfo() {
        try {
            String name = ProductField.getText();
            int price = Integer.parseInt(PriceProductField.getText());
            int quantity = Integer.parseInt(QuantityProductField.getText());
            String content = contentProductField.getText();
            String id = idProductField.getText();
            if (id.equals("")) {
                return new Product(name, content, price, quantity);
            }
            int idP = Integer.parseInt(id);
            return new Product(idP, name, content, price, quantity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Product();

        }
    }


    public void fillProductFromSelectedRow() {
        ProductService ProductFunc = new ProductService();
        // lấy chỉ số của hàng được chọn
        int row = ProductTable.getSelectedRow();
        if (row >= 0) {
            idProductField.setText(ProductTable.getModel().getValueAt(row, 0).toString());
            ProductField.setText(ProductTable.getModel().getValueAt(row, 1).toString());
            PriceProductField.setText(ProductTable.getModel().getValueAt(row, 2).toString());
            QuantityProductField.setText(ProductTable.getModel().getValueAt(row, 3).toString());
            contentProductField.setText(ProductTable.getModel().getValueAt(row, 4).toString());

            editProductBtn.setEnabled(true);
            deleteProductBtn.setEnabled(true);
            addProductBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddProductListener(ActionListener listener) {
        addProductBtn.addActionListener(listener);
    }

    public void addEditProductListener(ActionListener listener) {
        editProductBtn.addActionListener(listener);
    }

    public void addDeleteProductListener(ActionListener listener) {
        deleteProductBtn.addActionListener(listener);
    }

    public void addClearProductListener(ActionListener listener) {
        clearProductBtn.addActionListener(listener);
    }

    public void backProductListener(ActionListener listener) {
        backBtn.addActionListener(listener);
    }


    public void addListProductSelectionListener(ListSelectionListener listener) {
        ProductTable.getSelectionModel().addListSelectionListener(listener);
    }


}
