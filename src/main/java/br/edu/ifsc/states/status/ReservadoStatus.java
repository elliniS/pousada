package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public class ReservadoStatus extends Status {

    public ReservadoStatus(Reserva reserva) {
        super(reserva);
        this.nome = "Reservado";
    }

    @Override
    public void proximo() {
        reserva.setStatus(new OcupandoStatus(reserva));
    }

    @Override
    public void cancela() {
        reserva.setStatus(new CanceladoStatus(reserva));
    }
}
