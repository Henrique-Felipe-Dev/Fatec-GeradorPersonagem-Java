package com.company.model.bean;

public class Personagem extends Pessoa{

    private String raca;
    private String sexo;
    private int idade;
    private double dano = 2;
    private double hp = 10;

    public Personagem(int id) {
        super(id);
    }

    public Personagem(String nome) {
        super(nome);
    }

    public Personagem(String nome, String raca, String sexo, int idade, double dano, double hp) {
        super(nome);
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.dano = dano;
        this.hp = hp;
    }

    public Personagem(int id, String nome, String raca, String sexo, int idade, double dano, double hp) {
        super(id, nome);
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.dano = dano;
        this.hp = hp;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome = " + getNome() + '\'' +
                "idade = " + getIdade() + '\'' +
                "raca='" + raca + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade='" + idade + '\'' +
                ", dano='" + dano + '\'' +
                ", hp='" + hp + '\'' +
                "} ";
    }
}
