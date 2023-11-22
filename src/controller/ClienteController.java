/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

import model.Cliente;
import model.dao.ClienteDao;
import view.cliente.JanelaClienteView;

public class ClienteController {
    private JanelaClienteView view;
    private ClienteDao modelDao;

    public ClienteController(JanelaClienteView view, ClienteDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController(){
        this.view.setController(this);
        this.view.initView();
    }

    public void criarCliente() {
        try{
            Cliente contato = view.getClienteFormulario();
            modelDao.inserir(contato);
            view.inserirClienteView(contato);
            view.apresentaInfo("Adicionado com sucesso!!!");

        }catch(Exception ex){
            view.apresentaErro("Erro ao criar contato.");
        }
    }

    public void atualizarCliente() {
        try{

            Cliente contato = view.getClienteParaAtualizar();
            if(contato==null){
                view.apresentaInfo("Selecione um contato na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(contato);
            view.atualizarCliente(contato);

        }catch(Exception ex){
            view.apresentaErro("Erro ao atualizar contato.");
        }
    }

    public void excluirCliente() {
        try{
            List<Cliente> listaParaExcluir = view.getClientesParaExcluir();
            modelDao.exluirLista(listaParaExcluir);
            view.excluirClientesView(listaParaExcluir);
        }catch(Exception ex){
            view.apresentaErro("Erro ao excluir contatos.");
        }
    }

    public void listarCliente() {
        try{
            view.limparClienteAtualizar();
            List<Cliente> lista = this.modelDao.getLista();
            view.mostrarListaClientes(lista);
        }catch(Exception ex){
            ex.printStackTrace();
            view.apresentaErro("Erro ao listar contatos.");
        }
    }


}
