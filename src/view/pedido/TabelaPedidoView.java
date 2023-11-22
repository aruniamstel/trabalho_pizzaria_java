package view.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import model.Pedido;

public class TabelaPedidoView extends javax.swing.JPanel {
    private PedidoTableModel modeloTabelaPedido = new PedidoTableModel();
    private JanelaPedidoView janela;
    private int linhaClicadaParaAtualizacao = -1;

    /**
     * Creates new form TabelaPedidoView
     */
    public TabelaPedidoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();

        tabelaPedido.setModel(modeloTabelaPedido);
        tabelaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPedidoMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tabelaPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>

    private void tabelaPedidoMouseClicked(java.awt.event.MouseEvent evt) {
        // Pega a linha clicada
        linhaClicadaParaAtualizacao = this.tabelaPedido.rowAtPoint(evt.getPoint());
        // Pega o pedido da linha clicada
        Pedido pedido = modeloTabelaPedido.getPedido(linhaClicadaParaAtualizacao);
        // Seta os dados no formulário
        janela.getFormularioPedidoView().setPedido(pedido);
    }

    public JTable getTabelaPedido() {
        return tabelaPedido;
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tabelaPedido;
    // End of variables declaration

    public void setJanelaView(JanelaPedidoView janela) {
        this.janela = janela;
    }

    public void inserirPedidoTabela(Pedido pedido) {
        modeloTabelaPedido.adicionaPedido(pedido);
    }

    public void setListaPedidosTabela(List<Pedido> lista) {
        modeloTabelaPedido.setListaPedidos(lista);
    }

    public List<Pedido> getPedidosParaExcluirDaTabela() {
        int[] linhasSelecionadas = this.getTabelaPedido().getSelectedRows();
        List<Pedido> listaExcluir = new ArrayList<>();
        for (int element : linhasSelecionadas) {
            Pedido pedido = modeloTabelaPedido.getPedido(element);
            listaExcluir.add(pedido);
        }
        return listaExcluir;
    }

    public void excluirPedidosDaTabela(List<Pedido> listaParaExcluir) {
        modeloTabelaPedido.removePedidos(listaParaExcluir);
    }

    public void atualizarPedidoNaTabela(Pedido pedido) {
        modeloTabelaPedido.fireTableRowsUpdated(linhaClicadaParaAtualizacao, linhaClicadaParaAtualizacao);
    }
}
