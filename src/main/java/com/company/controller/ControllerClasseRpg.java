package com.company.controller;

import com.company.model.bean.ClasseRpg;
import com.company.model.dao.DaoClasseRpg;

import java.sql.SQLException;
import java.util.List;

public class ControllerClasseRpg {

    DaoClasseRpg daoClasse = null;

    public ClasseRpg excluir(ClasseRpg classeEntrada) throws SQLException, ClassNotFoundException {
        daoClasse = new DaoClasseRpg();
        return daoClasse.excluir(classeEntrada);
    }

    public ClasseRpg alterar(ClasseRpg classeEntrada) throws SQLException, ClassNotFoundException {
        daoClasse = new DaoClasseRpg();
        return daoClasse.alterar(classeEntrada);
    }

    public ClasseRpg inserir(ClasseRpg classeEntrada) throws SQLException, ClassNotFoundException {
        daoClasse = new DaoClasseRpg();
        return daoClasse.inserir(classeEntrada);
    }

    public ClasseRpg buscar(ClasseRpg classeEntrada) throws SQLException, ClassNotFoundException {
        daoClasse = new DaoClasseRpg();
        return daoClasse.buscar(classeEntrada);
    }

    public List<ClasseRpg> listar(ClasseRpg classeEntrada) throws SQLException, ClassNotFoundException {
        daoClasse = new DaoClasseRpg();
        return daoClasse.listar(classeEntrada);
    }
    
}
