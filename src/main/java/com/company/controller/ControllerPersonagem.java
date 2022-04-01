package com.company.controller;

import com.company.model.bean.Personagem;
import com.company.model.dao.DaoPersonagem;

import java.sql.SQLException;
import java.util.List;

public class ControllerPersonagem {

    DaoPersonagem daoPerson = null;

    public Personagem excluir(Personagem personEntrada) throws SQLException, ClassNotFoundException {
        daoPerson = new DaoPersonagem();
        return daoPerson.excluir(personEntrada);
    }

    public Personagem alterar(Personagem personEntrada) throws SQLException, ClassNotFoundException {
        daoPerson = new DaoPersonagem();
        return daoPerson.alterar(personEntrada);
    }

    public Personagem inserir(Personagem personEntrada) throws SQLException, ClassNotFoundException {
        daoPerson = new DaoPersonagem();
        return daoPerson.inserir(personEntrada);
    }

    public Personagem buscar(Personagem personEntrada) throws SQLException, ClassNotFoundException {
        daoPerson = new DaoPersonagem();
        return daoPerson.buscar(personEntrada);
    }

    public List<Personagem> listar(Personagem personEntrada) throws SQLException, ClassNotFoundException {
        daoPerson = new DaoPersonagem();
        return daoPerson.listar(personEntrada);
    }
    
}
