package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public class FinalizadoStatus extends Status {
    public FinalizadoStatus(Reserva reserva) {
        super(reserva);
        this.nome = "Finalizado";
    }

    @Override
    public void proximo() {
        System.out.println("Esta reserva já foi finalizada");
    }

    @Override
    public void cancela() {
        System.out.println("Não é possivel cancelar uma reserva finalizada");
    }
}
