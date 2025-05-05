package OnliX.TiendaOnline.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity(name="review")
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_review",nullable = false)
    private int id_review;

    @Column(name="qualification",length=1000,nullable=false)
    private int qualification;
    @Column(name="comment",length = 1000,nullable = true)
    private String comment;

    @Column(name="date",length = 1000,nullable = false)
    private LocalDate date;

    public review() {
    }

    public review(int id_review, int qualification, String comment, LocalDate date) {
        this.id_review = id_review;
        this.qualification = qualification;
        this.comment = comment;
        this.date = date;
    }

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    @ManyToOne
    @JoinColumn(name="id_user",nullable= false)
    private Users User;

    @ManyToOne
    @JoinColumn(name="id_product",nullable = false)
    private product product;
}
