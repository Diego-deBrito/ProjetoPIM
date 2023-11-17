package br.com.uniplan.pim.repository;

import br.com.uniplan.pim.entity.TipoReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoReservaRepository extends JpaRepository<TipoReservaEntity,Long> {

    TipoReservaEntity findByIdAndNome(Long id, String nome);

}
