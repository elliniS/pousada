package br.edu.ifsc.DAO;

import br.edu.ifsc.models.Cliente;

public class ClienteDAO extends DefaultDAO<Cliente>{
    private static ClienteDAO instance;
    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    private ClienteDAO() {}

    public Cliente getByCPF(String cpf) {
        return getAllList().stream().filter(cliente -> cliente.getCpf().equals(cpf)).findFirst().orElse(null);
    }
}
