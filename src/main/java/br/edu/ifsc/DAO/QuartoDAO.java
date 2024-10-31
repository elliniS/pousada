package br.edu.ifsc.DAO;

import br.edu.ifsc.models.Quarto;

public class QuartoDAO extends DefaultDAO<Quarto>{
    private static QuartoDAO instance;
    public static QuartoDAO getInstance() {
        if (instance == null) {
            instance = new QuartoDAO();
        }
        return instance;
    }

    private QuartoDAO() {}

    public Quarto getByNumero(int numero) {
        return getAllList().stream().filter(x -> x.getNumero() == numero).findFirst().orElse(null);
    }


}
