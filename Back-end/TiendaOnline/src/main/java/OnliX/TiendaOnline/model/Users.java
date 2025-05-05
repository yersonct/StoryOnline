package OnliX.TiendaOnline.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private int id_user;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(name = "address", length = 100, nullable = false)
    private String address;
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;
    @Column(name = "role", length = 20, nullable = false)
    private String role;

    public Users() {
    }

    public Users(int id_user, String name, String email, String password, String address, String phone, String role) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private cart cart;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)  // Cambiado de "user" a "User"
    private List<review> reviews;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Orders> Orders;
}
