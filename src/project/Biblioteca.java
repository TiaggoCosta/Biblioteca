package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import project.models.Cliente;
import project.models.Emprestimo;
import project.models.Livro;

public class Biblioteca {
    private static Biblioteca instance = new Biblioteca();

    public static Biblioteca getInstance() {
        return instance;
    }

    private Biblioteca() {
    }

    private List<Livro> livros = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    // Livros
    public List<Livro> getLivros() {
        return livros;
    }

    public void insereLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        int indice = livros.indexOf(livro);
        livros.remove(indice);
    }
    
    public Livro buscaPorTitulo(String tituloLivro) {
        return livros.stream().filter(livro -> livro.getTitulo().equals(tituloLivro)).findAny().orElse(null);
    }

    public Livro buscaPorISBN(String isbn) {
        return livros.stream().filter(livro -> livro.getIsbn().equals(isbn)).findAny().orElse(null);
    }

    // Clientes
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void insereCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente) {
        int indice = clientes.indexOf(cliente);
        clientes.remove(indice);
    }

    public Cliente buscaPorEmail(String emailCliente) {
        return clientes.stream().filter(cliente -> cliente.getEmail().equals(emailCliente)).findAny().orElse(null);
    }

    public Cliente buscaPorId(int idCliente) {
        return clientes.stream().filter(cliente -> cliente.getId() == idCliente).findAny().orElse(null);
    }

    // Emprestimos
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void registraRetirada(Cliente cliente, Livro livro, LocalDate dataRetirada) {
        Emprestimo emprestimo = new Emprestimo(cliente, livro, dataRetirada);
        emprestimos.add(emprestimo);
    }

    public void registraDevolucao(Cliente cliente, Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente) && emprestimo.getLivro().equals(livro)) {
                emprestimos.remove(emprestimo);
                break;
            }
        }
    }
}
