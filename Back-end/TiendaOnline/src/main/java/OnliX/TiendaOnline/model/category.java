package OnliX.TiendaOnline.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "category")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_category",nullable = false)
    private int id_category;
    @Column(name="name",length = 1000,nullable = false)
    private String name;
    @Column(name="description",length = 1000,nullable = false)
    private String description;

    public category() {
    }
    

    public category(int id_category, String name, String description) {
        this.id_category = id_category;
        this.name = name;
        this.description = description;
    }
    public int getId_category() {
        return id_category;
    }
    public void setId_category(int id_category) {
        this.id_category = id_category;
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
    

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL)
    private List<product> products;
}
