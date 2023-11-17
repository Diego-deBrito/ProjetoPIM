package br.com.uniplan.pim.repository;

import br.com.uniplan.pim.entity.MoradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {


}
