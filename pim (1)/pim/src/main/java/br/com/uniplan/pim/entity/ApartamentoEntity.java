package br.com.uniplan.pim.entity;

import br.com.uniplan.pim.entity.MoradorEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_APARTAMENTO")
public class ApartamentoEntity {

    @Id
    @Column(name = "id_apartamento")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "id_morador")
    private MoradorEntity moradorEntity;


    public MoradorEntity getMoradorEntity() {
        return moradorEntity;
    }

    public void setMoradorEntity(MoradorEntity moradorEntity) {
        this.moradorEntity = moradorEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
