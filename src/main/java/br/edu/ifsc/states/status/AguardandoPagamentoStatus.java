package br.edu.ifsc.states.status;

import br.edu.ifsc.models.Reserva;

public class AguardandoPagamentoStatus extends Status {


    public AguardandoPagamentoStatus(Reserva reserva) {
        super(reserva);
        this.nome = "Aguardando pagamento";
    }

    @Override
    public void proximo() {
        reserva.setStatus(new ReservadoStatus(reserva));
    }

    @Override
    public void cancela() {
        reserva.setStatus(new CanceladoStatus(reserva));
    }
}
