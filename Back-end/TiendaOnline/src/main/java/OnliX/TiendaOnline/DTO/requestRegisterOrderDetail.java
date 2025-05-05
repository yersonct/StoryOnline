package OnliX.TiendaOnline.DTO;

public class requestRegisterOrderDetail {
    public int idOrderDetail;
    public double amount;
    public double unitPrice;
    public double subtotal;
    public requestRegisterOrderDetail(int id, double amount, double unitPrice, double subtotal) {
        this.idOrderDetail = id;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }
    public int getId() {
        return idOrderDetail;
    }
    public void setId(int id) {
        this.idOrderDetail = id;
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
}
