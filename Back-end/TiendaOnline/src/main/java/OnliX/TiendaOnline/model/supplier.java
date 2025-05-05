package OnliX.TiendaOnline.model;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="supplier")
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_supplier",nullable = false)
    private int id_supplier;
    @Column(name="name",length = 1000,nullable=false)
    private String name;
    @Column(name="contact_supplier",length=1000,nullable=false)
    private String contact_supplie;
    @Column(name="phone",length = 1000,nullable = false)
    private String phone;

    public supplier() {
    }
    public supplier(int id_supplier, String name_supplier, String contact_supplie, String phone) {
        this.id_supplier = id_supplier;
        this.name = name_supplier;
        this.contact_supplie = contact_supplie;
        this.phone = phone;
    }
    public int getId_supplier() {
        return id_supplier;
    }
    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }
    public String getName_supplier() {
        return name;
    }
    public void setName_supplier(String name_supplier) {
        this.name = name_supplier;
    }
    public String getContact_supplie() {
        return contact_supplie;
    }
    public void setContact_supplie(String contact_supplie) {
        this.contact_supplie = contact_supplie;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<product> products;

}
/*
 * @OneToMany(mappedBy = "proveedor"):
Un Proveedor puede tener muchos Productos.
mappedBy = "proveedor" indica que Producto es dueño de la relación.
cascade = CascadeType.ALL: Si se elimina un proveedor, también se eliminan sus productos.
 */