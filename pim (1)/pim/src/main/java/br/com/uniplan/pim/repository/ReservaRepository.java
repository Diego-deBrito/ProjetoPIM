package br.com.uniplan.pim.repository;

import br.com.uniplan.pim.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
}
