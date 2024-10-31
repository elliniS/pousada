package br.edu.ifsc.models;

import br.edu.ifsc.IEntidade;
import br.edu.ifsc.enuns.TemporadaEnum;
import br.edu.ifsc.states.status.AguardandoPagamentoStatus;
import br.edu.ifsc.states.status.Status;

import java.time.LocalDate;
import java.time.Period;

public class Reserva implements IEntidade {
    private int id;
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numeroPessoas;
    private TemporadaEnum temporada;
    private double preco;
    private Status status;

    public Reserva(Builder builder) {
        this.cliente = builder.cliente;
        this.quarto = builder.quarto;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.numeroPessoas = builder.numeroPessoas;
        this.temporada = builder.temporada;
        this.status = new AguardandoPagamentoStatus(this);
        this.preco = quarto.getPrecoBase() * temporada.multiplicador * ( 1.0 + ((5.0 * numeroPessoas))/100.0);
    }


    public void proximoStatus(){
        status.proximo();
    }

    public void cancelarReserva(){
        status.cancela();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPreco(){
        return preco;
    }

    public int getNumeroPessoas(){
        return numeroPessoas;
    }

    public int getDias(){
        return Period.between(checkIn, checkOut).getDays();
    }

    public TemporadaEnum getTemporada() {
        return temporada;
    }

    public Status getStatus() {
        return status;
    }

    public static class Builder {
        private Cliente cliente;
        private Quarto quarto;
        private LocalDate checkIn;
        private LocalDate checkOut;
        private int numeroPessoas;
        private TemporadaEnum temporada;

        public Builder cliente (Cliente cliente){
            this.cliente = cliente;
            return this;
        }

        public Builder quarto (Quarto quarto){
            this.quarto = quarto;
            return this;
        }

        public Builder checkIn (LocalDate checkIn){
            this.checkIn = checkIn;
            return this;
        }

        public Builder checkOut (LocalDate checkOut){
            this.checkOut = checkOut;
            return this;
        }

        public Builder numeroPessoas (int numeroPessoas){
            this.numeroPessoas = numeroPessoas;
            return this;
        }

        public Builder temporada (TemporadaEnum temporada){
            this.temporada = temporada;
            return this;
        }

        public Reserva build(){
            return new Reserva(this);
        }
    }
}
