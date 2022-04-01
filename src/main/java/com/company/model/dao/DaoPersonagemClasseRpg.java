package com.company.model.dao;

import com.company.model.bean.PersonagemClasseRpg;
import com.company.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonagemClasseRpg {

    private final Connection c;

    public DaoPersonagemClasseRpg() throws SQLException, ClassNotFoundException{
        this.c = new Conexao().getConnection();
    }

    public PersonagemClasseRpg excluir(PersonagemClasseRpg pcEntrada) throws SQLException {
        String sql = "delete from personagem_classe_rpg WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pcEntrada.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pcEntrada;
    }

    public PersonagemClasseRpg alterar(PersonagemClasseRpg pcEntrada) throws SQLException {
        String sql = "UPDATE personagem_classe_rpg " +
                "SET idPersonagem = ?, idClasse = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pcEntrada.getIdPersonagem());
        stmt.setInt(2,pcEntrada.getIdClasse());
        stmt.setString(3,pcEntrada.getObs());
        stmt.setInt(4,pcEntrada.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pcEntrada;

    }

    public List<PersonagemClasseRpg> listar(PersonagemClasseRpg pcEntrada) throws SQLException {
        // usus: array armazena a lista de registros

        List<PersonagemClasseRpg> listapc = new ArrayList<>();

        String sql = "select * from personagem_classe_rpg where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pcEntrada.getObs() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            PersonagemClasseRpg pc = new PersonagemClasseRpg(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4)
            );
            // adiciona o usu à lista de usus
            listapc.add(pc);
        }

        rs.close();
        stmt.close();

        return listapc;
    }

    public PersonagemClasseRpg buscar(PersonagemClasseRpg pcEntrada) throws SQLException {
        String sql = "select * from personagem_classe_rpg WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pcEntrada.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        PersonagemClasseRpg retorno = null;
        while (rs.next()) {
            // criando o objeto Usuario
            retorno = new PersonagemClasseRpg(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return retorno;
    }

    public PersonagemClasseRpg inserir(PersonagemClasseRpg pcEntrada) throws SQLException {
        String sql = "insert into personagem_classe_rpg" +
                " (idPersonagem, idClasse, observacao)" + " values (?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,pcEntrada.getIdPersonagem());
        stmt.setInt(2,pcEntrada.getIdClasse());
        stmt.setString(3,pcEntrada.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pcEntrada.setId(id);
        }
        stmt.close();
        return pcEntrada;
    }
}
