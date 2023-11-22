package view.pedido;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Pedido;

public class FormularioPedidoView extends javax.swing.JPanel {

    private Pedido pedidoSelecionadoParaAtualizacao;

    public FormularioPedidoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoDataPedido = new javax.swing.JFormattedTextField();
        labelDataPedido = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        campoCliente = new javax.swing.JTextField();

        try {
            campoDataPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        labelDataPedido.setText("Data do Pedido");

        labelCliente.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDataPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDataPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataPedido)
                    .addComponent(campoDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoDataPedido;
    private javax.swing.JTextField campoCliente;
    private javax.swing.JLabel labelDataPedido;
    private javax.swing.JLabel labelCliente;
    // End of variables declaration//GEN-END:variables

    public void setPedido(Pedido pedido) {
        this.pedidoSelecionadoParaAtualizacao = pedido;
        campoDataPedido.setText(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        campoCliente.setText(pedido.getCliente().getNome());
    }

    public void limparPedidoAtualizar() {
        pedidoSelecionadoParaAtualizacao = null;
    }

    public Pedido getPedidoParaAtualizar() {
        if (pedidoSelecionadoParaAtualizacao == null) {
            return null;
        }
        pedidoSelecionadoParaAtualizacao.setDataPedido(LocalDate.parse(campoDataPedido.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        // Aqui você deve obter o cliente associado ao campoCliente e atribuir ao pedido
        return pedidoSelecionadoParaAtualizacao;
    }

    public Pedido getPedidoFormulario() {
        LocalDate dataPedido = LocalDate.parse(campoDataPedido.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // Aqui você deve obter o cliente associado ao campoCliente e atribuir ao pedido
        return new Pedido(-1, dataPedido, null); // Substitua 'null' pelo cliente correto
    }
}
