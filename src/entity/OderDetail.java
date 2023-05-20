package entity;


public class OderDetail {
    private int id;
    private int quantity;
    private Product product;
    private Oder oder;

    public OderDetail(int quantity, Product product, Oder oder) {
        this.quantity = quantity;
        this.product = product;
        this.oder = oder;
    }

    public OderDetail(int id, int quantity, Product product, Oder oder) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.oder = oder;
    }

    public OderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }
}
