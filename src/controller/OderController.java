package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.Oder;
import service.OderService;
import service.ProductService;
import view.OderView;
import view.OderDetailView;

public class OderController {
    private ProductService productService;
    private OderService oderService;
    private OderView oderView;
    private OderDetailView oderDetailView;

    public OderController(OderView view) {
        this.oderView = view;
        oderService = new OderService();
        productService = new ProductService();
        oderDetailView = new OderDetailView();

        view.addAddStudentListener(new AddStudentListener());
        view.searchCustomerListener(new searchCustomerListener());
        view.showAllCustomerListener(new showAllCustomerListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
    }

    public void showOderView() {
        List<Oder> oders = oderService.getOders();
        oderView.setVisible(true);
        oderView.showListOder(oders);
    }

    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            oderView.showMessage("Không thể thêm tại đây");
        }
    }

    class searchCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = oderView.getNameSearch();
            if (name != null) {
                oderView.showListOder(oderService.findByName(name));
            } else {
                oderView.showMessage("chưa nhập name search!");
            }
        }
    }

    class showAllCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            oderView.showListOder(oderService.getOders());

        }
    }

    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Oder oder = oderView.getOderInfo();
            if (oder != null) {
                oderService.edit(oder);
                oderView.showOder(oder);
                oderView.showListOder(oderService.getOders());
                oderView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Oder oder = oderView.getOderInfo();
            if (oder != null) {
                oderService.delete(oder.getId());
                oderView.clearStudentInfo();
                oderView.showListOder(oderService.getOders());
                oderView.showMessage("Xóa thành công!");
            }
        }
    }

//    class DiagnoseDetail implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            oderDetailController.showProducts();
//            oderView.setVisible(false);
//            oderDetailView.setVisible(true);
//
//        }
//    }


    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            oderView.clearStudentInfo();
        }
    }


    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            oderService.sortByDate();
            oderView.showListOder(oderService.getOders());
        }
    }

    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            oderView.fillOderFromSelectedRow();
        }
    }

}