package view.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pedido;

public class PedidoTableModel extends AbstractTableModel {
    private String[] colunas = new String[]{"id", "Cliente", "Data Pedido"};

    private List<Pedido> lista = new ArrayList<>();

    public PedidoTableModel(List<Pedido> lista) {
        this.lista = lista;
    }

    public PedidoTableModel() {
    }

    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pedido.getId();
            case 1:
                return pedido.getCliente().getNome(); // Aqui você deve adaptar para obter o nome do cliente
            case 2:
                return pedido.getDataPedido();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        // Implemente conforme necessário
    }

    public boolean removePedido(Pedido pedido) {
        int linha = this.lista.indexOf(pedido);
        boolean result = this.lista.remove(pedido);
        this.fireTableRowsDeleted(linha, linha);
        return result;
    }

    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        this.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }

    public void setListaPedidos(List<Pedido> pedidos) {
        this.lista = pedidos;
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size() - 1;
        if (indice < 0)
            indice = 0;
        this.lista = new ArrayList<>();
        this.fireTableRowsDeleted(0, indice);
    }

    public Pedido getPedido(int linha) {
        return lista.get(linha);
    }

    void removePedidos(List<Pedido> listaParaExcluir) {
        listaParaExcluir.forEach(this::removePedido);
    }
}
