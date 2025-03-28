package OnliX.TiendaOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="orderDetail")
public class orderDetail {
    @Id
    @Column(name="id_orderDetail",nullable = false)
    private int id_orderDetail;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="unitPrice",nullable = false)
    private double unitPrice;
    @Column(name="subtotal",nullable =  false)
    private double subtotal;

    public orderDetail() {
    }

    public orderDetail(int id_orderDetail, double amount, double unitPrice, double subtotal) {
        this.id_orderDetail = id_orderDetail;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public int getId_orderDetail() {
        return id_orderDetail;
    }

    public void setId_orderDetail(int id_orderDetail) {
        this.id_orderDetail = id_orderDetail;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    

    




    @ManyToOne
    @JoinColumn(name = "id_order",nullable = false,referencedColumnName = "id_order")
    private order order;

    @ManyToOne
    @JoinColumn(name="id_product",nullable = false)
    private product product;
}
