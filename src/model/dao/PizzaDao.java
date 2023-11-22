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

import model.Pizza;

public class PizzaDao {
    // a conexão com o banco de dados

    private ConnectionFactory connectionFactory;
    private final String insert = "insert into pizzas (forma, tamanho, sabor1, sabor2) values (?,?,?,?)";
    private final String select = "select * from pizzas";
    private final String update = "update pizzas set forma=?, tamanho=?, sabor1=?, sabor2=? WHERE id=?";
    private final String delete = "delete from pizzas WHERE id=?";

    public PizzaDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public void inserir(Pizza pizza) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAdiciona = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        ) {
            // seta os valores
            stmtAdiciona.setString(1, pizza.getForma());
            stmtAdiciona.setDouble(2, pizza.getTamanho());
            stmtAdiciona.setString(3, pizza.getSabor1());
            stmtAdiciona.setString(4, pizza.getSabor2());
            // executa
            stmtAdiciona.execute();
            // Setando o id da pizza
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            long i = rs.getLong(1);
            pizza.setId(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pizza> getLista() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtLista = connection.prepareStatement(select);
             ResultSet rs = stmtLista.executeQuery();
        ) {
            List<Pizza> pizzas = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String forma = rs.getString("forma");
                double tamanho = rs.getDouble("tamanho");
                String sabor1 = rs.getString("sabor1");
                String sabor2 = rs.getString("sabor2");

                pizzas.add(new Pizza(id, forma, tamanho, sabor1, sabor2));
            }

            return pizzas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Pizza pizza) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtAtualiza = connection.prepareStatement(update);
        ) {

            stmtAtualiza.setString(1, pizza.getForma());
            stmtAtualiza.setDouble(2, pizza.getTamanho());
            stmtAtualiza.setString(3, pizza.getSabor1());
            stmtAtualiza.setString(4, pizza.getSabor2());
            stmtAtualiza.setLong(5, pizza.getId());
            stmtAtualiza.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Pizza pizza) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmtExcluir = connection.prepareStatement(delete);
        ) {
            stmtExcluir.setLong(1, pizza.getId());
            stmtExcluir.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
