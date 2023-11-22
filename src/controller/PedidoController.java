package controller;

import java.util.List;

import model.Pedido;
import model.dao.PedidoDao;
import view.pedido.JanelaPedidoView;

public class PedidoController {
    private JanelaPedidoView view;
    private PedidoDao modelDao;

    public PedidoController(JanelaPedidoView view, PedidoDao modelDao) {
        this.view = view;
        this.modelDao = modelDao;
        initController();
    }

    private void initController() {
        this.view.setController(this);
        this.view.initView();
    }

    public void criarPedido() {
        try {
            Pedido pedido = view.getPedidoFormulario();
            modelDao.inserir(pedido);
            view.inserirPedidoView(pedido);
            view.apresentaInfo("Pedido adicionado com sucesso!");

        } catch (Exception ex) {
            view.apresentaErro("Erro ao criar pedido.");
        }
    }

    public void atualizarPedido() {
        try {
            Pedido pedido = view.getPedidoParaAtualizar();
            if (pedido == null) {
                view.apresentaInfo("Selecione um pedido na tabela para atualizar.");
                return;
            }
            modelDao.atualizar(pedido);
            view.atualizarPedido(pedido);

        } catch (Exception ex) {
            view.apresentaErro("Erro ao atualizar pedido.");
        }
    }

    public void excluirPedido() {
        try {
            List<Pedido> listaParaExcluir = view.getPedidosParaExcluir();
            modelDao.excluirLista(listaParaExcluir);
            view.excluirPedidosView(listaParaExcluir);
        } catch (Exception ex) {
            view.apresentaErro("Erro ao excluir pedidos.");
        }
    }

    public void listarPedido() {
        try {
            view.limparPedidoAtualizar();
            List<Pedido> lista = this.modelDao.getLista();
            view.mostrarListaPedidos(lista);
        } catch (Exception ex) {
            ex.printStackTrace();
            view.apresentaErro("Erro ao listar pedidos.");
        }
    }
}
