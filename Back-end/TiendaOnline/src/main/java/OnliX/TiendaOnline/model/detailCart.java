package OnliX.TiendaOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="detailCart")
public class detailCart {
    @Id
    @Column(name = "id_detailCart",nullable = false)
    private int id_detailCart;
    @Column(name="amount",nullable = false)
    private double amount;
    public detailCart(int id_detailCart, double amount) {
        this.id_detailCart = id_detailCart;
        this.amount = amount;
    }
    public int getId_detailCart() {
        return id_detailCart;
    }
    public void setId_detailCart(int id_detailCart) {
        this.id_detailCart = id_detailCart;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    

    @ManyToOne
    @JoinColumn(name="id_cart",nullable = false)
    private cart cart;

    @ManyToOne
    @JoinColumn(name="id_product",nullable = false)
    private product product;
}
