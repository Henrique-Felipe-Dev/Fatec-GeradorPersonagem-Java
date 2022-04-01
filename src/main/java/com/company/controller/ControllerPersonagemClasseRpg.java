package com.company.controller;

import com.company.model.bean.ClasseRpg;
import com.company.model.bean.Personagem;
import com.company.model.bean.PersonagemClasseRpg;
import com.company.model.dao.DaoPersonagemClasseRpg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPersonagemClasseRpg {

    DaoPersonagemClasseRpg daopc = null;

    public PersonagemClasseRpg excluir(PersonagemClasseRpg pcEntrada) throws SQLException, ClassNotFoundException {
        daopc = new DaoPersonagemClasseRpg();
        return daopc.excluir(pcEntrada);
    }

    public PersonagemClasseRpg alterar(PersonagemClasseRpg pcEntrada) throws SQLException, ClassNotFoundException {
        daopc = new DaoPersonagemClasseRpg();
        return daopc.alterar(pcEntrada);
    }

    public List<PersonagemClasseRpg> listar(PersonagemClasseRpg pcEntrada) throws SQLException, ClassNotFoundException {
        daopc = new DaoPersonagemClasseRpg();
        List<PersonagemClasseRpg> listapc = daopc.listar(pcEntrada);
        List<PersonagemClasseRpg> listapcAux = new ArrayList<>();
        for (PersonagemClasseRpg pc : listapc) {
            listapcAux.add(buscar(pc));
        }
        return listapcAux;
    }

    public PersonagemClasseRpg buscar(PersonagemClasseRpg pcEntrada) throws SQLException, ClassNotFoundException {
        daopc = new DaoPersonagemClasseRpg();
        PersonagemClasseRpg pc = daopc.buscar(pcEntrada);

        ControllerPersonagem contP = new ControllerPersonagem();
        Personagem pEntrada = new Personagem(pc.getIdPersonagem());
        pc.setPersonagem(contP.buscar(pEntrada));

        ControllerClasseRpg contC = new ControllerClasseRpg();
        ClasseRpg CEntrada = new ClasseRpg(pc.getIdClasse());
        pc.setClasseRpg(contC.buscar(CEntrada));

        return pc;
    }

    public PersonagemClasseRpg inserir(PersonagemClasseRpg pcEntrada) throws SQLException, ClassNotFoundException {
        daopc = new DaoPersonagemClasseRpg();
        return daopc.inserir(pcEntrada);
    }

}
