/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ClienteController;
import model.dao.ConnectionFactory;
import model.dao.ClienteDao;
import view.cliente.JanelaClienteView;

public class Main {
    public static void main(String[] args){
    	JanelaClienteView view = new JanelaClienteView();
        ClienteDao modelDao = new ClienteDao(new ConnectionFactory());
        ClienteController controller = new ClienteController(view,modelDao);

    }

}
