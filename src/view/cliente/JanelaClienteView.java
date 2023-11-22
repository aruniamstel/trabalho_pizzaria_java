/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import java.util.List;

import javax.swing.JOptionPane;

import controller.ClienteController;
import view.cliente.*;

import model.Cliente;

public class JanelaClienteView extends javax.swing.JFrame {


    /**
     * Creates new form JanelaClienteView
     */
    public JanelaClienteView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botoesClienteView = new view.cliente.BotoesClienteView();
        tabelaClienteView = new view.cliente.TabelaClienteView();
        formularioClienteView = new view.cliente.FormularioClienteView();

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
                        .addComponent(botoesClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabelaClienteView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(formularioClienteView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botoesClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.cliente.BotoesClienteView botoesClienteView;
    private view.cliente.FormularioClienteView formularioClienteView;
    private view.cliente.TabelaClienteView tabelaClienteView;
    // End of variables declaration//GEN-END:variables


    public void setController(ClienteController controller) {
        botoesClienteView.setController(controller);

    }

    public void initView() {
        /* Create and display the form */
        tabelaClienteView.setJanelaView(this);
        java.awt.EventQueue.invokeLater(() ->  this.setVisible(true));
    }

    public Cliente getClienteFormulario() {
       return this.formularioClienteView.getClienteFormulario();
    }

    public void inserirClienteView(Cliente contato) {
        tabelaClienteView.inserirClienteTabela(contato);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null,erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarListaClientes(List<Cliente> lista) {
        tabelaClienteView.setListaClientesTabela(lista);
    }

    public List<Cliente> getClientesParaExcluir() {
        return this.tabelaClienteView.getClientesParaExcluirDaTabela();
    }

    public void excluirClientesView(List<Cliente> listaParaExcluir) {
        tabelaClienteView.excluirClientesDaTabela(listaParaExcluir);
    }

    public Cliente getClienteParaAtualizar() {
        return formularioClienteView.getClienteParaAtualizar();
    }

    public void atualizarCliente(Cliente contato) {
        tabelaClienteView.atualizarClienteNaTabela(contato);
    }

    public void limparClienteAtualizar(){
        formularioClienteView.limparClienteAtualizar();
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null,info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public BotoesClienteView getBotoesClienteView() {
        return botoesClienteView;
    }

    public FormularioClienteView getFormularioClienteView() {
        return formularioClienteView;
    }

    public TabelaClienteView getTabelaClienteView() {
        return tabelaClienteView;
    }


}
