package com.company.model.bean;

public class PersonagemClasseRpg {

    private int id;
    private int idPersonagem;
    private int idClasse;
    private String obs;
    private Personagem personagem;
    private ClasseRpg classeRpg;

    public PersonagemClasseRpg(){

    }

    public PersonagemClasseRpg(int id) {
        this.id = id;
    }

    public PersonagemClasseRpg(String obs) {
        this.obs = obs;
    }

    public PersonagemClasseRpg(int idPersonagem, int idClasse, String obs) {
        this.idPersonagem = idPersonagem;
        this.idClasse = idClasse;
        this.obs = obs;
    }
    public PersonagemClasseRpg(int id, int idPersonagem, int idClasse, String obs) {
        this.id = id;
        this.idPersonagem = idPersonagem;
        this.idClasse = idClasse;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(int idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public ClasseRpg getClasseRpg() {
        return classeRpg;
    }

    public void setClasseRpg(ClasseRpg classeRpg) {
        this.classeRpg = classeRpg;
    }

    @Override
    public String toString() {
        return "PersonagemClasseRpg{" +
                "id=" + id +
                ", idPersonagem=" + idPersonagem +
                ", idClasse=" + idClasse +
                ", obs='" + obs + '\'' +
                ", personagem=" + personagem +
                ", classeRpg=" + classeRpg +
                '}';
    }
}
