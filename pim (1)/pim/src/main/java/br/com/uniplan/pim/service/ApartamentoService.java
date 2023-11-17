package br.com.uniplan.pim.service;


import br.com.uniplan.pim.entity.ApartamentoEntity;
import br.com.uniplan.pim.entity.MoradorEntity;
import br.com.uniplan.pim.exception.NaoEncontradoException;
import br.com.uniplan.pim.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.uniplan.pim.repository.ApartamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    public List<ApartamentoEntity> recuperarTodos() {
        return apartamentoRepository.findAll();
    }

    public Object recuperarPorId(Long id) {
        return apartamentoRepository.findById(id);
    }



    public ResponseEntity<String> adicionarMoradorAoAp(Long moradorId, Long apartamentoId){
        Optional<ApartamentoEntity> optionalApartamento = apartamentoRepository.findById(apartamentoId);
        Optional <MoradorEntity> optionalMorador = moradorRepository.findById(moradorId);

        if(optionalMorador.isPresent() && optionalApartamento.isPresent()){
            MoradorEntity morador = optionalMorador.get();
            ApartamentoEntity apartamento = optionalApartamento.get();

            apartamento.setMoradorEntity(morador);
            apartamentoRepository.save(apartamento);

            return ResponseEntity.ok("Morador adicionado ao apartamento com sucesso!");
        }else {
            return ResponseEntity.badRequest().body("Morador ou apartamento não encontrado!");
        }

    }



    public ApartamentoEntity cadastrarApartamento(ApartamentoEntity apartamento){
        return apartamentoRepository.save(apartamento);
    }

    public ApartamentoEntity atualizarApartamentoNoSistema(ApartamentoEntity apartamento) throws NaoEncontradoException {
        if (!apartamentoRepository.existsById(apartamento.getId())) {
            throw new NaoEncontradoException();
        }
        return apartamentoRepository.save(apartamento);
    }

    public void removerApartamentoDoSistema(Long id) throws NaoEncontradoException {
        if (!apartamentoRepository.existsById(id)) {
            throw new NaoEncontradoException();
        }
        apartamentoRepository.deleteById(id);
    }


}



