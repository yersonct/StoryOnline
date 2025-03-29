package OnliX.TiendaOnline.DTO;

public class requestRegisterSupplier {
        /*
        * Agregar al DTO solo los elementos a exponer según
        * la petición o respuesta
        */
        private int id;
        private String name;
        private String contact;
        public requestRegisterSupplier() {
        }
        public requestRegisterSupplier(int id, String name, String contact) {
            this.id = id;
            this.name = name;
            this.contact = contact;
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
        public String getContact() {
            return contact;
        }
        public void setContact(String contact) {
            this.contact = contact;
        }
        
        
}
