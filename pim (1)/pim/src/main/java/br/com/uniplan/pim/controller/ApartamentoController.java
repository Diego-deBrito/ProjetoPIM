package br.com.uniplan.pim.controller;

import br.com.uniplan.pim.entity.ApartamentoEntity;
import br.com.uniplan.pim.exception.NaoEncontradoException;
import br.com.uniplan.pim.repository.ApartamentoRepository;
import br.com.uniplan.pim.service.ApartamentoService;
import br.com.uniplan.pim.service.MoradorService;
import br.com.uniplan.pim.entity.TipoReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;



    @PostMapping("/addMoradorAoApartamento/{moradorId}/{apartamentoId}")
    public ResponseEntity <String> adicionarMoradorAoAp(@PathVariable Long moradorId, @PathVariable Long apartamentoId){
        return apartamentoService.adicionarMoradorAoAp(moradorId, apartamentoId);
    }


    @GetMapping("/recuperar-todos")
    public ResponseEntity<List<ApartamentoEntity>> recuperarTodos() {
        return ResponseEntity.ok(apartamentoService.recuperarTodos());
    }


    @PostMapping("/cadastrar-apartamento")
    public ResponseEntity<ApartamentoEntity> cadastrarApartamento(@RequestBody ApartamentoEntity apartamento) throws NaoEncontradoException, URISyntaxException {
        ApartamentoEntity novoApartamento = apartamentoService.cadastrarApartamento(apartamento);
        return ResponseEntity.created(new URI("/apartamento/" + novoApartamento.getId())).body(novoApartamento);
    }

    @PutMapping("/atualizar-apartamento")
    public ResponseEntity<ApartamentoEntity> atualizarApartamento(@RequestBody ApartamentoEntity apartamento) throws NaoEncontradoException {
        ApartamentoEntity apartamentoAtualizado = apartamentoService.atualizarApartamentoNoSistema(apartamento);
        return ResponseEntity.ok(apartamentoAtualizado);
    }


    @DeleteMapping("/remover-apartamento")
    public ResponseEntity<Void> removerApartamento(@PathVariable Long id) throws NaoEncontradoException {
        apartamentoService.removerApartamentoDoSistema(id);
        return ResponseEntity.noContent().build();
    }

}
