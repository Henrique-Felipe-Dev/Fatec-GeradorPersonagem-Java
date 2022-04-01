package com.company.model.bean;

public class ClasseRpg {

    private int id;
    private String tipo;
    private String arma;
    private double bonusHp;
    private double bonusDano;

    public ClasseRpg(int id) {
        this.id = id;
    }

    public ClasseRpg(String tipo) {
        this.tipo = tipo;
    }

    public ClasseRpg(String tipo, String arma, double bonusHp, double bonusDano) {
        this.tipo = tipo;
        this.arma = arma;
        this.bonusHp = bonusHp;
        this.bonusDano = bonusDano;
    }

    public ClasseRpg(int id, String tipo, String arma, double bonusHp, double bonusDano) {
        this.id = id;
        this.tipo = tipo;
        this.arma = arma;
        this.bonusHp = bonusHp;
        this.bonusDano = bonusDano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public double getBonusHp() {
        return bonusHp;
    }

    public void setBonusHp(double bonusHp) {
        this.bonusHp = bonusHp;
    }

    public double getBonusDano() {
        return bonusDano;
    }

    public void setBonusDano(double bonusDano) {
        this.bonusDano = bonusDano;
    }

    @Override
    public String toString() {
        return "ClasseRpg{" +
                "tipo='" + tipo + '\'' +
                ", arma='" + arma + '\'' +
                ", bonusHp='" + bonusHp + '\'' +
                ", bonusDano=" + bonusDano +
                '}';
    }
}
