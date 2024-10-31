package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public class CanceladoStatus extends Status {
    public CanceladoStatus(Reserva reserva) {
        super(reserva);
        this.reserva = reserva;
    }

    @Override
    public void proximo() {
        System.out.println("Esta reseva foi cancelada.");
    }

    @Override
    public void cancela() {
        System.out.println("Esta reserva já está cancelada.");
    }
}
