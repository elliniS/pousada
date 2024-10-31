package br.edu.ifsc.models;

import br.edu.ifsc.IEntidade;
import br.edu.ifsc.enuns.QuartoEnum;

public class Quarto implements IEntidade {
    private int id;
    private int numero;
    private String descricao;
    private QuartoEnum tipo;
    private double precoBase;

    public Quarto(Builder builder) {
        this.numero = builder.numero;
        this.descricao = builder.descricao;
        this.tipo = builder.tipo;
        this.precoBase = builder.precoBase;
    }

    public Quarto() {}

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public QuartoEnum getTipo() {
        return tipo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public static class Builder {
        private int numero;
        private String descricao;
        private QuartoEnum tipo;
        private double precoBase;

        public Builder numero(int numero) {
            this.numero = numero;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder tipo(QuartoEnum tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder precoBase(double precoBase) {
            this.precoBase = precoBase;
            return this;
        }

        public Quarto build() {
            return new Quarto(this);
        }
    }
}
