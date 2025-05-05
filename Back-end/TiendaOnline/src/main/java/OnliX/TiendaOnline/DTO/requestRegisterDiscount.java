package OnliX.TiendaOnline.DTO;

public class requestRegisterDiscount {
 public int id_discount;
 public String code;
 public double porcentage;
 public requestRegisterDiscount(int id, String code, double porcentage) {
    this.id_discount = id;
    this.code = code;
    this.porcentage = porcentage;
 }
 public int getId() {
    return id_discount;
 }
 public void setId(int id) {
    this.id_discount = id;
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
 
}
