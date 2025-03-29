package OnliX.TiendaOnline.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="shipment")
public class shipment {
    @Id
    @Column(name="id_shipment",nullable = false)
    private int id_shipment;
    @Column(name="address",length = 30,nullable = false)
    private String address;
    @Column(name="state",nullable = false)
    private boolean state;
    @Column(name="companyShipping",length = 40,nullable = false)
    private String companyShipping;
    @Column(name="shippingDate",length = 40,nullable = false)
    private String shippingDate;
    @Column(name="deliveryDate",length = 40,nullable = false)
    private String deliveryDate;
    
    public shipment(int id_shipment, String address, boolean state, String companyShipping, String shippingDate,
            String deliveryDate) {
        this.id_shipment = id_shipment;
        this.address = address;
        this.state = state;
        this.companyShipping = companyShipping;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
    }
    public int getId_shipment() {
        return id_shipment;
    }
    public void setId_shipment(int id_shipment) {
        this.id_shipment = id_shipment;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getCompanyShipping() {
        return companyShipping;
    }
    public void setCompanyShipping(String companyShipping) {
        this.companyShipping = companyShipping;
    }
    public String getShippingDate() {
        return shippingDate;
    }
    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }
    public String getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    
}
