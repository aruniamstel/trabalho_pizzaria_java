package view.pedido;

import controller.PedidoController;

public class BotoesPedidoPizzaView extends javax.swing.JPanel {

    public BotoesPedidoPizzaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoAdicionarPizza = new javax.swing.JButton();
        botaoAtualizarPedido = new javax.swing.JButton();
        botaoRemoverPizza = new javax.swing.JButton();
        botaoListarPedido = new javax.swing.JButton();

        botaoAdicionarPizza.setText("Adicionar Pizza");

        botaoAtualizarPedido.setText("Atualizar Pedido");

        botaoRemoverPizza.setText("Remover Pizza");

        botaoListarPedido.setText("Listar Pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoAdicionarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoAtualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoRemoverPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoListarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionarPizza)
                    .addComponent(botaoAtualizarPedido)
                    .addComponent(botaoRemoverPizza)
                    .addComponent(botaoListarPedido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarPizza;
    private javax.swing.JButton botaoAtualizarPedido;
    private javax.swing.JButton botaoRemoverPizza;
    private javax.swing.JButton botaoListarPedido;
    // End of variables declaration//GEN-END:variables

    public void setController(PedidoPizzaController controller) {
        this.botaoAdicionarPizza.addActionListener(e -> controller.adicionarPizzaAoPedido());
        this.botaoAtualizarPedido.addActionListener(e -> controller.atualizarPedido());
        this.botaoRemoverPizza.addActionListener(e -> controller.removerPizzaDoPedido());
        this.botaoListarPedido.addActionListener(e -> controller.listarPedido());
    }
}
