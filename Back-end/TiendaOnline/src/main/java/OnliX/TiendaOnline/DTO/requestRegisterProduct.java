package OnliX.TiendaOnline.DTO;

public class requestRegisterProduct {
    public int id_product;
    public String name;
    public String description;
    public double price;
    public requestRegisterProduct(int id, String name, String description, double price) {
        id_product = id;
        name = name;
        description = description;
        this.price = price;
    }
    public int getId() {
        return id_product;
    }
    public void setId(int id) {
        id_product = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
