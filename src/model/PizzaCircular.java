package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaCircular extends Pizza {
    // Construtor
    public PizzaCircular(long id, double raio, String sabor1, String sabor2) {
        super(id, "circular", raio, sabor1, sabor2);
    }

    // Método para calcular a área da pizza circular
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(getTamanho(), 2);
    }

    // Outros métodos, se necessário

    // Método para criar uma instância de PizzaCircular a partir de um ResultSet
    public static PizzaCircular toPizzaCircular(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        double raio = rs.getDouble("tamanho");
        String sabor1 = rs.getString("sabor1");
        String sabor2 = rs.getString("sabor2");

        return new PizzaCircular(id, raio, sabor1, sabor2);
    }
}
