package br.com.uniplan.pim.entity;

import jakarta.persistence.*;

// este objeto representa o bd
@Entity
@Table(name = "TB_TIPO_RESERVA")
public class TipoReservaEntity {

    @Id
    @Column(name = "id_tipo_reserva")
    private Long id;

    @Column(name = "nome", nullable = false)
    private  String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
