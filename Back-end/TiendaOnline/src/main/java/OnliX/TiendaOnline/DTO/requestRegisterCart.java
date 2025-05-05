package OnliX.TiendaOnline.DTO;

public class requestRegisterCart {
    public int id_cart;
    public String updateData;
    public requestRegisterCart(int id, String updateData) {
        this.id_cart = id;
        this.updateData = updateData;
    }
    public int getId() {
        return id_cart;
    }
    public void setId(int id) {
        this.id_cart = id;
    }
    public String getUpdateData() {
        return updateData;
    }
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

}
