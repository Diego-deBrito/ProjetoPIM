package br.com.uniplan.pim.controller;


import br.com.uniplan.pim.exception.NaoEncontradoException;
import br.com.uniplan.pim.service.MoradorService;
import br.com.uniplan.pim.entity.TipoReservaEntity;
import br.com.uniplan.pim.entity.MoradorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping("/recuperar-todos")
    public ResponseEntity<List<MoradorEntity>> recuperarTodos() {
        return ResponseEntity.ok(moradorService.recuperarTodos());
    }


    @PostMapping("/criar-morador")
    public ResponseEntity <MoradorEntity> cadastrarNovoMorador(@RequestBody MoradorEntity morador){
        MoradorEntity salvarMorador = moradorService.criarNovoMorador(morador);
        return ResponseEntity.ok(salvarMorador);
    }



    @PutMapping("/atualizar-morador")
    public ResponseEntity <MoradorEntity> atualizarMorador(@RequestBody MoradorEntity morador) throws NaoEncontradoException {
        MoradorEntity moradorAtualizado = moradorService.atualizarMoradorNoSistema(morador);
        return ResponseEntity.ok(moradorAtualizado);
    }

    @DeleteMapping("deletar-morador")
    public ResponseEntity <Void> deletarMorador(@PathVariable Long moradorId) throws NaoEncontradoException {
        moradorService.deletarMoradorDoSistema(moradorId);
        return ResponseEntity.noContent().build();
    }
}
