package OnliX.TiendaOnline.DTO;

public class requestRegisterCart {
    public int id;
    public String updateData;
    public requestRegisterCart(int id, String updateData) {
        this.id = id;
        this.updateData = updateData;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUpdateData() {
        return updateData;
    }
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

}
