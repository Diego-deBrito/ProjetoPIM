package br.com.uniplan.pim.controller;

import br.com.uniplan.pim.entity.ReservaDTO;
import br.com.uniplan.pim.entity.ReservaEntity;
import br.com.uniplan.pim.exception.NaoEncontradoException;
import br.com.uniplan.pim.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

   @Autowired
    private ReservaRepository reservaRepository;




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveReserva(@RequestBody ReservaDTO data){
        ReservaEntity reservaData = new ReservaEntity(data);
        reservaRepository.save(reservaData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ReservaDTO> getAll(){
        return reservaRepository.findAll().stream().map(reservaEntity -> new ReservaDTO(reservaEntity)).collect(Collectors.toList());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }



//    @PostMapping("/cadastrar-reservaDTO")
//    public ResponseEntity<ReservaEntity> cadastrarReservaDTO(@RequestBody ReservaDTO reserva) throws NaoEncontradoException, URISyntaxException {
//        ReservaEntity novaReserva = reservaService.cadastrarReservaDTO(reserva);
//        return ResponseEntity.created(new URI("/reserva/" + novaReserva.getId())).body(novaReserva);
//    }

}
