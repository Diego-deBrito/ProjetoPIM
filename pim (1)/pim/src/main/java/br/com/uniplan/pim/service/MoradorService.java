package br.com.uniplan.pim.service;

import br.com.uniplan.pim.entity.MoradorEntity;
import br.com.uniplan.pim.exception.NaoEncontradoException;
import br.com.uniplan.pim.repository.ApartamentoRepository;
import br.com.uniplan.pim.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoradorService {

    @Autowired
    MoradorRepository moradorRepository;

    @Autowired
    ApartamentoRepository apartamentoRepository;


    public MoradorEntity criarNovoMorador(MoradorEntity morador){
            return moradorRepository.save(morador);
    }





    public List<MoradorEntity> recuperarTodos() {
        return moradorRepository.findAll();
    }

    public MoradorEntity atualizarMoradorNoSistema(MoradorEntity moradorEntity) throws NaoEncontradoException {
        if(!moradorRepository.existsById(moradorEntity.getId())){
            throw new NaoEncontradoException();
        }
        return moradorRepository.save(moradorEntity);
    }

    public void deletarMoradorDoSistema(Long moradorId) throws NaoEncontradoException {
        if(!moradorRepository.existsById(moradorId)){
            throw new NaoEncontradoException();
        }
        moradorRepository.deleteById(moradorId);
    }

}
