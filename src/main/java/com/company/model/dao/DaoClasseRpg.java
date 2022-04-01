package com.company.model.dao;

import com.company.model.bean.ClasseRpg;
import com.company.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoClasseRpg {

    private final Connection c;

    public DaoClasseRpg() throws SQLException, ClassNotFoundException {
        this.c = new Conexao().getConnection();
    }

    public ClasseRpg inserir(ClasseRpg classe) throws SQLException{
        String sql = "insert into classe_rpg" +
                " (tipo, arma, bonusHp, bonusDano)" +
                " values (?,?,?,?,?,?,?)";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,classe.getTipo());
        stmt.setString(2,classe.getArma());
        stmt.setDouble(4, classe.getBonusHp());
        stmt.setDouble(5, classe.getBonusDano());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            classe.setId(id);
        }
        stmt.close();
        return classe;
    }

    public ClasseRpg alterar(ClasseRpg classe) throws SQLException{
        String sql = "UPDATE classe_rpg SET " +
                "tipo = ?, arma = ?, bonusHp = ?, bonusDano = ?" +
                " WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,classe.getTipo());
        stmt.setString(2,classe.getArma());
        stmt.setDouble(4, classe.getBonusHp());
        stmt.setDouble(5, classe.getBonusDano());
        stmt.setInt(6, classe.getId());

        // executa
        stmt.execute();
        stmt.close();
        return classe;
    }

    public ClasseRpg excluir(ClasseRpg classe) throws SQLException{
        String sql = "delete from classe_rpg WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,classe.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return classe;
    }

    public ClasseRpg buscar(ClasseRpg classe) throws SQLException{
        String sql = "select * from classe_rpg WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,classe.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        ClasseRpg classeSaida = null;
        while (rs.next()) {
            // criando o objeto Usuario
            classeSaida = new ClasseRpg(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getDouble(5));
            // adiciona o usu à lista de usus
        }
        stmt.close();
        return classeSaida;
    }

    public List<ClasseRpg> listar(ClasseRpg classeEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<ClasseRpg> classes = new ArrayList<>();

        String sql = "select * from classe_rpg where tipo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + classeEnt.getTipo() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto Usuario
            ClasseRpg classe = new ClasseRpg(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4),
                    rs.getDouble(5));
            // adiciona o usu à lista de usus
            classes.add(classe);
        }

        rs.close();
        stmt.close();
        return classes;

    }
    
}
