package OnliX.TiendaOnline.DTO;

public class requestRegisterDetailCart {

    public int id;
    public double amount;
    public requestRegisterDetailCart(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
