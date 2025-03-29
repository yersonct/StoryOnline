package OnliX.TiendaOnline.DTO;

public class requestRegisterProduct {
    public int Id;
    public String Name;
    public String Description;
    public double price;
    public requestRegisterProduct(int id, String name, String description, double price) {
        Id = id;
        Name = name;
        Description = description;
        this.price = price;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
