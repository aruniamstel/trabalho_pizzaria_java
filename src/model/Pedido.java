package model;

import java.time.LocalDate;
import java.util.List;

import model.dao.ClienteDao;

public class Pedido {
    private long id;
    private Cliente cliente;
    private Long idCliente;
    private LocalDate data;
    private double total;
    private List<Pizza> pizzas; // Supondo que um pedido pode ter várias pizzas

    // Construtor
    public Pedido(long id, Cliente cliente, LocalDate data, double total, List<Pizza> pizzas) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.total = total;
        this.pizzas = pizzas;
    }
    
    public Pedido(long id, long idCliente, LocalDate data, double total, List<Pizza> pizzas) {
        this.id = id;
        this.idCliente = idCliente;
        this.data = data;
        this.total = total;
        this.pizzas = pizzas;
    }
    
    // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    // Outros métodos, se necessário
}
