package br.com.uniplan.pim.controller;

import br.com.uniplan.pim.entity.TipoReservaEntity;
import br.com.uniplan.pim.service.TipoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-reserva")
public class TipoReservaController {

    @Autowired
    private TipoReservaService tipoReservaService;

    @GetMapping("/recuperar-todos")
    public ResponseEntity<List<TipoReservaEntity>> recuperarTodos() {
        return ResponseEntity.ok(tipoReservaService.recuperarTodos());
    }

   @GetMapping("/recuperar-por-id/{id}")
   public ResponseEntity<TipoReservaEntity> recuperarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok((TipoReservaEntity) tipoReservaService.recuperarPorId(id));
  }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<TipoReservaEntity> cadastrar(@RequestBody TipoReservaEntity entity) {
        return ResponseEntity.ok(tipoReservaService.cadastrar(entity));
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<TipoReservaEntity> alterar(@PathVariable Long id, @RequestBody TipoReservaEntity entity){
            return ResponseEntity.ok(tipoReservaService.alterar(id, entity));
    }


}
