package OnliX.TiendaOnline.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity(name="cart")
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cart",nullable=false)
    private int id_cart;
    @Column(name="updateDate",length=100,nullable = false)
    private String updateData;
    public cart(int id_cart, String updateData) {
        this.id_cart = id_cart;
        this.updateData = updateData;
    }
    public int getId_cart() {
        return id_cart;
    }
    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }
    public String getUpdateData() {
        return updateData;
    }
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }
    
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private user user;

    @OneToMany(mappedBy ="detailCart",cascade = CascadeType.ALL)
    private List<detailCart> detailCarts;

}
