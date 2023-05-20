import view.CustomerView;
import view.OderDetailView;
import view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductView detailView = new ProductView();
        CustomerView customerView = new CustomerView();
        customerView.setVisible(true);
    }
}
