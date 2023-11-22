/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ufpr.contato;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.dao.ConnectionFactory;
import model.dao.ClienteDao;

/**
 *
 * @author rafae
 */
public class TestaContato {
    public static void main(String args[]) throws SQLException{
        List<Cliente> contatos = new ArrayList();
        ClienteDao dao = new ClienteDao(new ConnectionFactory());
        contatos = dao.getLista();
        for(Cliente c:contatos){
        System.out.println(c.getNome());
    }

        Cliente c = new Cliente(-1, "Gustavo", LocalDate.of(1990, 3, 3), "rafaew0", "Rua X");
        dao.inserir(c);
    }

}
