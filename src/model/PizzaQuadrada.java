package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaQuadrada extends Pizza {
    // Construtor
    public PizzaQuadrada(long id, double lado, String sabor1, String sabor2) {
        super(id, "quadrada", lado, sabor1, sabor2);
    }

    // Método para calcular a área da pizza quadrada
    @Override
    public double calcularArea() {
        return getTamanho() * getTamanho();
    }

    // Outros métodos, se necessário

    // Método para criar uma instância de PizzaQuadrada a partir de um ResultSet
    public static PizzaQuadrada toPizzaQuadrada(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        double lado = rs.getDouble("tamanho");
        String sabor1 = rs.getString("sabor1");
        String sabor2 = rs.getString("sabor2");

        return new PizzaQuadrada(id, lado, sabor1, sabor2);
    }
}
