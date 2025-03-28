package OnliX.TiendaOnline.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product",nullable = false)
    private int id_product;
    @Column(name="name_product",length = 200,nullable = false)
    private String name_product;
    @Column(name="description",length = 200,nullable= false)
    private String description;
    @Column(name="price",nullable=false)
    private double price;
    public product(int id_product, String name_product, String description, double price) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.description = description;
        this.price = price;
    }
    public int getId_product() {
        return id_product;
    }
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }
    public String getName_product() {
        return name_product;
    }
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name="id_supplier",nullable = false)
    private supplier supplier;

    @ManyToOne
    @JoinColumn(name="id_category",nullable = false)
    private category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<review> reviews;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<orderDetail> orderDetails; 

    @OneToMany(mappedBy ="detailCart",cascade = CascadeType.ALL)
    private List<detailCart> detailCarts;
}
/*
 * @ManyToOne:
Cada Producto pertenece a un solo Proveedor.
@JoinColumn(name = "proveedor_id"):
Crea una clave foránea en la tabla Producto que referencia al id del Proveedor.
nullable = false asegura que cada producto debe tener un proveedor.
 */