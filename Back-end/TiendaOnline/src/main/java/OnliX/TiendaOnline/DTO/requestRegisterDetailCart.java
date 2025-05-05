package OnliX.TiendaOnline.DTO;

public class requestRegisterDetailCart {

    public int id_detailCart;
    public double amount;
    public requestRegisterDetailCart(int id, double amount) {
        this.id_detailCart = id;
        this.amount = amount;
    }
    public int getId() {
        return id_detailCart;
    }
    public void setId(int id) {
        this.id_detailCart = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
