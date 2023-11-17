package br.com.uniplan.pim.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RESERVA")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;


    public ReservaEntity(ReservaDTO data){
        this.image = data.image();
        this.title = data.title();
    }


    public ReservaEntity(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public ReservaEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
