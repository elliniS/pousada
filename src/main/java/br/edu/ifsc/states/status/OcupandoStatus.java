package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public class OcupandoStatus extends Status{
    public OcupandoStatus(Reserva reserva) {
        super(reserva);
        this.nome = "ocupado";
    }

    @Override
    public void proximo() {
        reserva.setStatus(new FinalizadoStatus(reserva));
    }

    @Override
    public void cancela() {
        System.out.println("O cancelamento não pode ser feito depois da hospedagem já ter começado");
    }
}
