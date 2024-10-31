package br.edu.ifsc.enuns;

public enum QuartoEnum {
    SINGLE_ROOM(1, "Quarto para solteiros"),
    TWIN_ROOM(2, "Quarto para duas pesaoas com cama separadas"),
    DOUBLE_ROOM(2, "Qaurto para casais"),
    FAMILY_ROOM(4, "quarto para a familia, contem uma cama para casual e duas de solteiro");

    public final int capacidade;
    public final String descricao;

    private QuartoEnum(int capacidade, String descricao) {
        this.capacidade = capacidade;
        this.descricao = descricao;
    }
}
