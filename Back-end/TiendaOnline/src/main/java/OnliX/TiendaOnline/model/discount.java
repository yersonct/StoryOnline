package OnliX.TiendaOnline.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "discount")
public class discount {
    @Id
    @Column(name="id_discount",nullable=false)
    private int id_discount;
    @Column(name="code",nullable = false)
    private String code;
    @Column(name="porcentage",nullable = false)
    private double porcentage;
    @Column(name="startDate",length = 30,nullable = false)
    private LocalDate starDate;
    @Column(name = "endDate",length = 30,nullable = false)
    private LocalDate endDate;
    public discount(int id_discount, String code, double porcentage, LocalDate starDate, LocalDate endDate) {
        this.id_discount = id_discount;
        this.code = code;
        this.porcentage = porcentage;
        this.starDate = starDate;
        this.endDate = endDate;
    }
    public int getId_discount() {
        return id_discount;
    }
    public void setId_discount(int id_discount) {
        this.id_discount = id_discount;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getPorcentage() {
        return porcentage;
    }
    public void setPorcentage(double porcentage) {
        this.porcentage = porcentage;
    }
    public LocalDate getStarDate() {
        return starDate;
    }
    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
