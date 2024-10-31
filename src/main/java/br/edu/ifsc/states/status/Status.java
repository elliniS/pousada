package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public abstract class Status {

    public Status(Reserva reserva) {
        this.reserva = reserva;
    }

    protected Reserva reserva;
    public String nome;
    public abstract void proximo();
    public abstract void cancela();
}
