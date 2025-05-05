package OnliX.TiendaOnline.DTO;

public class requestRegisterCategory {
    public int id_category;
    public String name;
    public String description;
    public requestRegisterCategory(int id, String name, String description) {
        this.id_category = id;
        this.name = name;
        this.description = description;
    }
    public int getId() {
        return id_category;
    }
    public void setId(int id) {
        this.id_category = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
