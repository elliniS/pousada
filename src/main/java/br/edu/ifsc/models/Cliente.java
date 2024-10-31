package br.edu.ifsc.models;

import br.edu.ifsc.IEntidade;

public class Cliente implements IEntidade {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(Builder builder) {
        this.nome = builder.nome;
        this.cpf = builder.cpf;
        this.telefone = builder.telefone;
        this.email = builder.email;
    }

    public Cliente() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    public static class Builder {
        private String nome;
        private String cpf;
        private String telefone;
        private String email;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Cliente build() {
            return new Cliente(this);
        }
    }
}
