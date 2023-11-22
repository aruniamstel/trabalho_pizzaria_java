/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.ConnectionFactory;

import model.Cliente;

public class ClienteDao {
// a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    private final String insert = "insert into clientes (nome,email,Telefone,dataNascimento) values (?,?,?,?)";
    private final String select = "select * from clientes";
    private final String select_id = "select * from clientes where id=?";
    private final String update = "update clientes set nome=?, email=?, Telefone=?, dataNascimento=? WHERE id=?";
    private final String delete = "delete from clientes WHERE id=?";

    public ClienteDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Cliente cliente) {
        //https://pt.stackoverflow.com/questions/172909/como-funciona-o-try-with-resources
        try (Connection connection=ConnectionFactory.getConnection();
             PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            )
        {
            // seta os valores
            stmtAdiciona.setString(1, cliente.getNome());
            stmtAdiciona.setString(2, cliente.getEmail());
            stmtAdiciona.setString(3, cliente.getTelefone());
            stmtAdiciona.setDate(4, Date.valueOf(cliente.getDataNascimento()));
            // executa
            stmtAdiciona.execute();
            //Seta o id do cliente
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            cliente.setId(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getLista() throws SQLException{
        try (Connection connection=ConnectionFactory.getConnection();
             PreparedStatement stmtLista = connection.prepareStatement(select);
             ResultSet rs = stmtLista.executeQuery();
            ){
            List<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                // criando o objeto cliente
                //cliente cliente = new cliente();
                long id = rs.getLong("id");
                String nome= rs.getString("nome");
                String email = rs.getString("email");
                String Telefone = rs.getString("Telefone");
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();

                // adicionando o objeto à lista
                clientes.add(new Cliente(id,nome,dataNascimento,email,Telefone));
            }

            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public Cliente getClienteById(long Id) throws SQLException{
        try (Connection connection=ConnectionFactory.getConnection();
             PreparedStatement stmtCliente = connection.prepareStatement(select_id);
            ){
    		stmtCliente.setLong(1, Id);
            ResultSet rs = stmtCliente.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                // criando o objeto cliente
                //cliente cliente = new cliente();
                long id = rs.getLong("id");
                String nome= rs.getString("nome");
                String email = rs.getString("email");
                String Telefone = rs.getString("Telefone");
                LocalDate dataNascimento = rs.getDate("dataNascimento").toLocalDate();

                // adicionando o objeto à lista
                cliente = new Cliente(id,nome,dataNascimento,email,Telefone);
            }

            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void atualizar(Cliente contact) throws SQLException{
        try(    Connection connection=ConnectionFactory.getConnection();
                PreparedStatement stmtAtualiza = connection.prepareStatement(update);
                ){

            stmtAtualiza.setString(1, contact.getNome());
            stmtAtualiza.setString(2, contact.getEmail());
            stmtAtualiza.setString(3, contact.getTelefone());
            stmtAtualiza.setDate(4,Date.valueOf(contact.getDataNascimento()));
            stmtAtualiza.setLong(5, contact.getId());
            stmtAtualiza.executeUpdate();
        }
    }

    public void exluirLista(List<Cliente> clientes) throws SQLException {
        for(Cliente cliente:clientes){
            excluir(cliente);
        }
    }

    public void excluir(Cliente contact) throws SQLException {

        try (Connection connection=ConnectionFactory.getConnection();
             PreparedStatement stmtExcluir = connection.prepareStatement(delete);
            ){
            stmtExcluir.setLong(1, contact.getId());
            stmtExcluir.executeUpdate();
        }
    }
}
