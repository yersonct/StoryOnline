package OnliX.TiendaOnline.DTO;

public class requestRegistetPaymentMethod {
    public int id;
    public String guy;
    public String paymentDate;
    public requestRegistetPaymentMethod(int id, String guy, String paymentDate) {
        this.id = id;
        this.guy = guy;
        this.paymentDate = paymentDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGuy() {
        return guy;
    }
    public void setGuy(String guy) {
        this.guy = guy;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    
}
