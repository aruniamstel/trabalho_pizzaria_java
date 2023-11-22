package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Pizza;

public class PedidoDao {
    private ConnectionFactory connectionFactory;
    private final String insert = "INSERT INTO pedidos (cliente_id, data, total) VALUES (?, ?, ?)";
    private final String select = "SELECT * FROM pedidos";
    private final String update = "UPDATE pedidos SET cliente_id=?, data=?, total=? WHERE id=?";
    private final String delete = "DELETE FROM pedidos WHERE id=?";

    public PedidoDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void inserir(Pedido pedido) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

            // seta os valores
            stmtAdiciona.setLong(1, pedido.getCliente().getId());
            stmtAdiciona.setDate(2, Date.valueOf(pedido.getData()));
            stmtAdiciona.setDouble(3, pedido.getTotal());

            // executa
            stmtAdiciona.execute();

            // Seta o id do pedido
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long id = rs.getLong(1);
            pedido.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> getLista() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtLista = connection.prepareStatement(select);
             ResultSet rs = stmtLista.executeQuery()) {

            List<Pedido> pedidos = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                long clienteId = rs.getLong("cliente_id");
                LocalDate data = rs.getDate("data").toLocalDate();
                double total = rs.getDouble("total");

                // Obter pizzas relacionadas ao pedido (método fictício, ajuste conforme necessário)
                List<Pizza> pizzas = getPizzasDoPedido(id);

                Pedido pedido = new Pedido(id, clienteId, data, total, pizzas);
                pedidos.add(pedido);
            }

            return pedidos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método fictício para obter pizzas relacionadas a um pedido
    private List<Pizza> getPizzasDoPedido(long pedidoId) {
        // Lógica para obter pizzas relacionadas a um pedido (pode variar conforme seu sistema)
        // Retorne a lista de pizzas associadas ao pedido com o ID fornecido
        return new ArrayList<>();
    }

    public void atualizar(Pedido pedido) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAtualiza = connection.prepareStatement(update)) {

            stmtAtualiza.setLong(1, pedido.getCliente().getId());
            stmtAtualiza.setDate(2, Date.valueOf(pedido.getData()));
            stmtAtualiza.setDouble(3, pedido.getTotal());
            stmtAtualiza.setLong(4, pedido.getId());
            stmtAtualiza.executeUpdate();
        }
    }

    public void excluirLista(List<Pedido> pedidos) throws SQLException {
        for (Pedido pedido : pedidos) {
            excluir(pedido);
        }
    }

    public void excluir(Pedido pedido) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtExcluir = connection.prepareStatement(delete)) {
            stmtExcluir.setLong(1, pedido.getId());
            stmtExcluir.executeUpdate();
        }
    }
}
