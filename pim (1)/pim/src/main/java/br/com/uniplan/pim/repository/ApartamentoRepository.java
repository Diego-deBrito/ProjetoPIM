package br.com.uniplan.pim.repository;
import br.com.uniplan.pim.entity.ApartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<ApartamentoEntity, Long> {


}
