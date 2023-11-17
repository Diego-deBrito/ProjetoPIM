package br.com.uniplan.pim.service;

import br.com.uniplan.pim.entity.TipoReservaEntity;
import br.com.uniplan.pim.repository.TipoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoReservaService {

    @Autowired
    private TipoReservaRepository tipoReservaRepository;

    public List<TipoReservaEntity> recuperarTodos() {
        return tipoReservaRepository.findAll();
    }

    public Object recuperarPorId(Long id) {
        return tipoReservaRepository.findById(id);
    }

    public void deletar(Long id) {
        tipoReservaRepository.deleteById(id);
    }

    public TipoReservaEntity cadastrar(TipoReservaEntity entity) {
        return tipoReservaRepository.save(entity);
    }

    public TipoReservaEntity alterar(Long id, TipoReservaEntity entity) {
        TipoReservaEntity t = tipoReservaRepository.getOne(id);
        t.setNome(entity.getNome());
        return  tipoReservaRepository.save(t);
    }

}
