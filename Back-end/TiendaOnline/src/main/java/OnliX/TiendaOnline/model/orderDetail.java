package OnliX.TiendaOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "orderDetail")
public class orderDetail {
    @Id
    @Column(name = "id_orderDetail", nullable = false)
    private int idOrderDetail;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;
    @Column(name = "subtotal", nullable = false)
    private double subtotal;

    public orderDetail() {
    }

    public orderDetail(int idOrderDetail, double amount, double unitPrice, double subtotal) {
        this.idOrderDetail = idOrderDetail;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public int getId_orderDetail() {
        return idOrderDetail;
    }

    public void setId_orderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
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
    @JoinColumn(name = "id_order", nullable = false, referencedColumnName = "id_order")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private product product;
}