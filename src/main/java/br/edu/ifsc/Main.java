package br.edu.ifsc;

import br.edu.ifsc.DAO.ClienteDAO;
import br.edu.ifsc.DAO.QuartoDAO;
import br.edu.ifsc.enuns.QuartoEnum;
import br.edu.ifsc.enuns.TemporadaEnum;
import br.edu.ifsc.models.Cliente;
import br.edu.ifsc.models.Quarto;
import br.edu.ifsc.models.Reserva;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDao = ClienteDAO.getInstance();
        QuartoDAO quartoDao = QuartoDAO.getInstance();

        Cliente cc = new Cliente.Builder()
                .cpf("34534553453453")
                .email("rrrrrrrrr")
                .telefone("234324234234")
                .nome("efffffffff")
                .build();

        Quarto qq = new Quarto.Builder().numero(231)
                .descricao("rwererw")
                .tipo(QuartoEnum.DOUBLE_ROOM)
                .precoBase(200)
                .build();

        int dd = qq.getTipo().capacidade;

        cc = clienteDao.save(cc);
        qq = quartoDao.save(qq);

        ReservaFacade reservaFacade = new ReservaFacade();

        try {

            LocalDate checkIn = LocalDate.of(2024, 11, 20);
            LocalDate checkOut = LocalDate.of(2024, 11, 24);

            Reserva re = reservaFacade.fazerReserva(cc.getId(), qq.getId(), 2, checkIn, checkOut, TemporadaEnum.MEDIA);

            re.proximoStatus();
            re.cancelarReserva();
            re.proximoStatus();
            re.cancelarReserva();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {

            LocalDate checkIn = LocalDate.of(2024, 11, 20);
            LocalDate checkOut = LocalDate.of(2024, 11, 24);

            Reserva re = reservaFacade.fazerReserva(cc.getId(), qq.getId(), 2, checkIn, checkOut, TemporadaEnum.MEDIA);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            LocalDate checkIn = LocalDate.of(2024, 12, 20);
            LocalDate checkOut = LocalDate.of(2024, 12, 24);

            Reserva re = reservaFacade.fazerReserva(cc.getId(), qq.getId(), 2, checkIn, checkOut, TemporadaEnum.MEDIA);

            re.proximoStatus();
            re.proximoStatus();
            re.proximoStatus();
            re.proximoStatus();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
