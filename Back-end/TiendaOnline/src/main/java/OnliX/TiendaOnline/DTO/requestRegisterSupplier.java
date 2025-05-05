package OnliX.TiendaOnline.DTO;

public class requestRegisterSupplier {
        /*
        * Agregar al DTO solo los elementos a exponer según
        * la petición o respuesta
        */
        private int id_supplier;
        private String name_supplier;
        private String contact_supplie;
        public requestRegisterSupplier() {
        }
        public requestRegisterSupplier(int id, String name, String contact) {
            this.id_supplier = id;
            this.name_supplier = name;
            this.contact_supplie = contact;
        }
        public int getId() {
            return id_supplier;
        }
        public void setId(int id) {
            this.id_supplier = id;
        }
        public String getName() {
            return name_supplier;
        }
        public void setName(String name) {
            this.name_supplier = name;
        }
        public String getContact() {
            return contact_supplie;
        }
        public void setContact(String contact) {
            this.contact_supplie = contact;
        }
        
        
}
