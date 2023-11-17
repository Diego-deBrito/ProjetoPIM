//package br.com.uniplan.pim.service;
//
//import br.com.uniplan.pim.entity.ReservaDTO;
//import br.com.uniplan.pim.entity.ReservaEntity;
//import br.com.uniplan.pim.exception.NaoEncontradoException;
//import br.com.uniplan.pim.repository.ApartamentoRepository;
//import br.com.uniplan.pim.repository.ReservaRepository;
//import br.com.uniplan.pim.repository.TipoReservaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ReservaService {
//
//    @Autowired
//    private ReservaRepository reservaRepository;
//
//
//    @Autowired
//    private ApartamentoRepository apartamentoRepository;
//
//    @Autowired
//    private TipoReservaRepository tipoReservaRepository;
//
//
//    public ReservaEntity cadastrarReserva(ReservaEntity reserva){
//        return reservaRepository.save(reserva);
//    }
//
//    public List<ReservaEntity> recuperarTodos() {
//        return reservaRepository.findAll();
//    }
//
//    public void removerReserva(Long id) throws NaoEncontradoException {
//        if (!reservaRepository.existsById(id)) {
//            throw new NaoEncontradoException();
//        }
//        reservaRepository.deleteById(id);
//    }
//
//    public ReservaEntity editarReserva(ReservaEntity reserva) throws NaoEncontradoException {
//        if (!reservaRepository.existsById(reserva.getId())) {
//            throw new NaoEncontradoException();
//        }
//        return reservaRepository.save(reserva);
//    }
//
////    public ReservaEntity cadastrarReservaDTO(ReservaDTO reservaDTO) {
////        ReservaEntity reserva = new ReservaEntity();
////        reserva.setApartamentoEntity(apartamentoRepository.findById(reservaDTO.getApartamentoId()).get());
////        reserva.setTipoReservaEntity(tipoReservaRepository.findById(reservaDTO.getTipoReservaId()).get());
////        reserva.setDataInicio(reservaDTO.getDataInicio());
////        reserva.setDataFim(reservaDTO.getDataFim());
////        reserva.setStatus(reservaDTO.isStatus());
////
////        return reservaRepository.save(reserva);
////    }
//}
//
