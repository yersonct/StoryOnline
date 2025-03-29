package OnliX.TiendaOnline.DTO;

import java.time.LocalDate;

public class requestRegisterOrder {
        /*
        * Agregar al DTO solo los elementos a exponer según
        * la petición o respuesta
        */
        public int id;
        public LocalDate date;
        public double total;
        public requestRegisterOrder(int id, LocalDate date, double total) {
            this.id = id;
            this.date = date;
            this.total = total;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public LocalDate getDate() {
            return date;
        }
        public void setDate(LocalDate date) {
            this.date = date;
        }
        public double getTotal() {
            return total;
        }
        public void setTotal(double total) {
            this.total = total;
        }
        
        
}
