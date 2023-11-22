package view.pedido;

import java.util.List;

import javax.swing.JOptionPane;

import controller.PedidoController;
import model.Pedido;

public class JanelaPedidoView extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPedidoView
     */
    public JanelaPedidoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botoesPedidoView = new view.pedido.BotoesPedidoView();
        tabelaPedidoView = new view.pedido.TabelaPedidoView();
        formularioPedidoView = new view.pedido.FormularioPedidoView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botoesPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabelaPedidoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formularioPedidoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botoesPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioPedidoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.pedido.BotoesPedidoView botoesPedidoView;
    private view.pedido.FormularioPedidoView formularioPedidoView;
    private view.pedido.TabelaPedidoView tabelaPedidoView;
    // End of variables declaration//GEN-END:variables

    public void setController(PedidoController controller) {
        botoesPedidoView.setController(controller);
    }

    public void initView() {
        tabelaPedidoView.setJanelaView(this);
        java.awt.EventQueue.invokeLater(() ->  this.setVisible(true));
    }

    public Pedido getPedidoFormulario() {
        return this.formularioPedidoView.getPedidoFormulario();
    }

    public void inserirPedidoView(Pedido pedido) {
        tabelaPedidoView.inserirPedidoTabela(pedido);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarListaPedidos(List<Pedido> lista) {
        tabelaPedidoView.setListaPedidosTabela(lista);
    }

    public List<Pedido> getPedidosParaExcluir() {
        return this.tabelaPedidoView.getPedidosParaExcluirDaTabela();
    }

    public void excluirPedidosView(List<Pedido> listaParaExcluir) {
        tabelaPedidoView.excluirPedidosDaTabela(listaParaExcluir);
    }

    public Pedido getPedidoParaAtualizar() {
        return formularioPedidoView.getPedidoParaAtualizar();
    }

    public void atualizarPedido(Pedido pedido) {
        tabelaPedidoView.atualizarPedidoNaTabela(pedido);
    }

    public void limparPedidoAtualizar() {
        formularioPedidoView.limparPedidoAtualizar();
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public BotoesPedidoView getBotoesPedidoView() {
        return botoesPedidoView;
    }

    public FormularioPedidoView getFormularioPedidoView() {
        return formularioPedidoView;
    }

    public TabelaPedidoView getTabelaPedidoView() {
        return tabelaPedidoView;
    }
}
