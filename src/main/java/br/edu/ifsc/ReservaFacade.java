package br.edu.ifsc;

import br.edu.ifsc.DAO.ClienteDAO;
import br.edu.ifsc.DAO.QuartoDAO;
import br.edu.ifsc.DAO.ReservaDAO;
import br.edu.ifsc.enuns.TemporadaEnum;
import br.edu.ifsc.models.Cliente;
import br.edu.ifsc.models.Quarto;
import br.edu.ifsc.models.Reserva;
import java.time.LocalDate;

public class ReservaFacade {
    ClienteDAO clienteDAO;
    QuartoDAO quartoDAO;
    ReservaDAO reservaDAO;

    public ReservaFacade() {
        this.clienteDAO = ClienteDAO.getInstance();
        this.quartoDAO = QuartoDAO.getInstance();
        this.reservaDAO = ReservaDAO.getInstance();
    }

    public Reserva fazerReserva(int idCliente, int idQuarto, int nrPessoas, LocalDate checkIn, LocalDate checkOut, TemporadaEnum temporada) throws Exception {
        if(quartoDisponivel(idQuarto, checkIn, checkOut)) {
            Cliente cliente = clienteDAO.getById(idCliente);
            Quarto quarto = quartoDAO.getById(idQuarto);
            Reserva reserva =  new Reserva.Builder()
                    .cliente(cliente)
                    .quarto(quarto)
                    .numeroPessoas(nrPessoas)
                    .checkIn(checkIn)
                    .checkOut(checkOut)
                    .temporada(temporada)
                    .build();

            reservaDAO.save(reserva);
            return reserva;
        }
        else{
            throw new Exception("Quarto não disponível para está data");
        }
    }

    public boolean quartoDisponivel(int idQuarto, LocalDate checkIn, LocalDate checkOut){
        return reservaDAO.getByQuarto(idQuarto).stream().noneMatch(q -> (q.getCheckIn().isBefore(checkIn) && q.getCheckOut().isAfter(checkIn))
                                                                        || (q.getCheckIn().isBefore(checkOut) && q.getCheckOut().isAfter(checkOut))
                                                                        || q.getCheckIn().equals(checkIn) || q.getCheckOut().equals(checkIn)
                                                                        || q.getCheckIn().equals(checkOut) && q.getCheckOut().equals(checkOut));
    }
}
