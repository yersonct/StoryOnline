package OnliX.TiendaOnline.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "Orders")
public class Orders {
    @Id
    @Column(name = "id_order", nullable = false)
    private int id_order;
    @Column(name = "date", length = 20, nullable = false)
    private LocalDate date;
    @Column(name = "total", nullable = false)
    private double total;
    @Column(name = "state", nullable = false)
    private boolean state;

    public Orders() {
    
    }
    public Orders(int id_order, LocalDate date, double total, boolean state) {
        this.id_order = id_order;
        this.date = date;
        this.total = total;
        this.state = state;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users users; // Changed from Users Users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paymentMethod", referencedColumnName = "id_paymentMethod")
    private paymentMethod paymentMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_shipment", referencedColumnName = "id_shipment")
    private shipment shipment;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL) // Corrected mappedBy
    private List<orderDetail> ordersDetails;
}