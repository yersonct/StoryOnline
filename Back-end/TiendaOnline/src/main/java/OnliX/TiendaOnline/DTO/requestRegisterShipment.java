package OnliX.TiendaOnline.DTO;

public class requestRegisterShipment {
        /*
        * Agregar al DTO solo los elementos a exponer según
        * la petición o respuesta
        */

    private int id;
    private String companyShipping;
    private String shippingDate;
    private String deliveryDate;
    public requestRegisterShipment() {
    }
    public requestRegisterShipment(int id, String companyShipping, String shippingDate, String deliveryDate) {
        this.id = id;
        this.companyShipping = companyShipping;
        this.shippingDate = shippingDate;
        this.deliveryDate = deliveryDate;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
