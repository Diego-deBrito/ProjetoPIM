package br.com.uniplan.pim.entity;
import br.com.uniplan.pim.controller.ReservaController;
import java.util.stream.Stream;
public record ReservaDTO(Long id, String title, String image) {

    public ReservaDTO(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;     }

    public ReservaDTO(ReservaEntity reserva){
        this(reserva.getId(), reserva.getTitle(), reserva.getImage() );
    }

}
