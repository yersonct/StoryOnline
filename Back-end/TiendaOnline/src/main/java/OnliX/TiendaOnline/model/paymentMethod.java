package OnliX.TiendaOnline.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SuppressWarnings("unused")
@Entity(name="paymentMethod")

public class paymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_paymentMethod",nullable = false)
    private int id_paymentMethod;
    @Column(name="guy",length = 20,nullable = false)
    private String guy;
    @Column(name="state",nullable = false)
    private boolean state;
    @Column(name="paymentDate",length = 20,nullable = false)
    private String paymentDate;
    public paymentMethod(int id_paymentMethod, String guy, boolean state, String paymentDate) {
        this.id_paymentMethod = id_paymentMethod;
        this.guy = guy;
        this.state = state;
        this.paymentDate = paymentDate;
    }
    public int getId_paymentMethod() {
        return id_paymentMethod;
    }
    public void setId_paymentMethod(int id_paymentMethod) {
        this.id_paymentMethod = id_paymentMethod;
    }
    public String getGuy() {
        return guy;
    }
    public void setGuy(String guy) {
        this.guy = guy;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    
}
