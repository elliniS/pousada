package br.edu.ifsc.enuns;

public enum TemporadaEnum {
    ALTA(1.5),
    MEDIA(1),
    BAIXA(0.7);

    public final double multiplicador;

    private TemporadaEnum(double multiplicador) {
        this.multiplicador = multiplicador;
    }
}
