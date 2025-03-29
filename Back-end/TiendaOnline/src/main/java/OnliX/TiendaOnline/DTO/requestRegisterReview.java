package OnliX.TiendaOnline.DTO;

public class requestRegisterReview {
    public int id;
    public int qualification;
    public String comment;
    public requestRegisterReview(int id, int qualification, String comment) {
        this.id = id;
        this.qualification = qualification;
        this.comment = comment;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQualification() {
        return qualification;
    }
    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
