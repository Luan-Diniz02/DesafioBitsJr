package br.com.desafiobitsjr.model;

import jakarta.validation.constraints.NotNull;

public class Duelista {
    private String id;
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Vitórias é obrigatório")
    private Integer vitorias;

    @NotNull(message = "Derrotas é obrigatório")
    private Integer derrotas;

    @NotNull(message = "Empates é obrigatório")
    private Integer empates;

    private Integer pontos;

    public Duelista() {
    }

    public Duelista(String nome, Integer vitorias, Integer derrotas, Integer empates) {
        this.nome = nome;
        this.vitorias = vitorias != null ? vitorias : 0;
        this.derrotas = derrotas != null ? derrotas : 0;
        this.empates = empates != null ? empates : 0;
        this.pontos = (this.vitorias * 3) + this.empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias != null ? vitorias : 0;
        calcularPontos();
    }

    private void calcularPontos() {
        this.pontos = (this.vitorias * 3) + (this.empates != null ? this.empates : 0);
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas != null ? derrotas : 0;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates != null ? empates : 0;
        calcularPontos();
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Duelistas{" +
                "nome='" + nome + '\'' +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                ", pontos=" + pontos +
                '}';
    }
}