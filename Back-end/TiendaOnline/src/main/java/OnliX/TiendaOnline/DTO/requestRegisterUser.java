package OnliX.TiendaOnline.DTO;

public class requestRegisterUser {
     /*
     * Agregar al DTO solo los elementos a exponer según
     * la petición o respuesta
     */

     private int id;
     private String name;
     private String email;
     private String role;

     public requestRegisterUser(){

     }

     public requestRegisterUser(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
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

     public String getRole() {
         return role;
     }

     public void setRole(String role) {
         this.role = role;
     }

     

     
}
