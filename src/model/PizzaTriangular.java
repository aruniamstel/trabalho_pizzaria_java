package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaTriangular extends Pizza {
    // Construtor
    public PizzaTriangular(long id, double ladoTriangulo, String sabor1, String sabor2) {
        super(id, "triangular", ladoTriangulo, sabor1, sabor2);
    }

    // Método para calcular a área da pizza triangular
    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * getTamanho() * getTamanho();
    }

    // Outros métodos, se necessário

    // Método para criar uma instância de PizzaTriangular a partir de um ResultSet
    public static PizzaTriangular toPizzaTriangular(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        double ladoTriangulo = rs.getDouble("tamanho");
        String sabor1 = rs.getString("sabor1");
        String sabor2 = rs.getString("sabor2");

        return new PizzaTriangular(id, ladoTriangulo, sabor1, sabor2);
    }
}
