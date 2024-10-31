package br.edu.ifsc.DAO;

import br.edu.ifsc.models.Reserva;

import java.util.ArrayList;

public class ReservaDAO extends DefaultDAO<Reserva> {
    private static ReservaDAO instance;
    public static ReservaDAO getInstance() {
        if (instance == null) {
            instance = new ReservaDAO();
        }
        return instance;
    }

    private ReservaDAO() {}

    public ArrayList<Reserva> getByQuarto(int idQuarto){
        return new ArrayList<>(getAllList().stream().filter(r -> r.getQuarto().getId() == idQuarto).toList());
    }
}
