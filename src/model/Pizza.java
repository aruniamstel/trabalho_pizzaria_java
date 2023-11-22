package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pizza {
    private long id;
    private String forma;
    private double tamanho;
    private String sabor1;
    private String sabor2;

    // Construtor
    public Pizza(long id, String forma, double tamanho, String sabor1, String sabor2) {
        this.id = id;
        this.forma = forma;
        setTamanho(tamanho);
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
    }

    // Getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForma() {
        return forma;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        if (validarTamanho(tamanho)) {
            this.tamanho = tamanho;
        } else {
            throw new IllegalArgumentException("Tamanho inválido para a forma de pizza " + forma);
        }
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }

    // Método abstrato para calcular a área da pizza
    public double calcularArea() {
        if (forma.equalsIgnoreCase("quadrada")) {
            return tamanho * tamanho;
        } else if (forma.equalsIgnoreCase("triangular")) {
            return (Math.sqrt(3) / 4) * tamanho * tamanho;
        } else if (forma.equalsIgnoreCase("circular")) {
            return Math.PI * tamanho * tamanho;
        } else {
            return 0; // Retornar 0 para formas desconhecidas
        }
    }

    // Método para validar o tamanho da pizza de acordo com as regras estabelecidas
    private boolean validarTamanho(double tamanho) {
        if (forma.equalsIgnoreCase("quadrada")) {
            return tamanho >= 10 && tamanho <= 40;
        } else if (forma.equalsIgnoreCase("triangular")) {
            return tamanho >= 20 && tamanho <= 60;
        } else if (forma.equalsIgnoreCase("circular")) {
            return tamanho >= 7 && tamanho <= 23;
        } else {
            return false;
        }
    }

    // Método para criar uma instância de Pizza a partir de um ResultSet
    public static Pizza toPizza(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String forma = rs.getString("forma");
        double tamanho = rs.getDouble("tamanho");
        String sabor1 = rs.getString("sabor1");
        String sabor2 = rs.getString("sabor2");

        return new Pizza(id, forma, tamanho, sabor1, sabor2);
    }

    // Outros métodos, se necessário
}
