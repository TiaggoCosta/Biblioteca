package project;

import java.util.Scanner;
import project.models.Cliente;

public class BibliotecaFacade {

    Biblioteca biblioteca = Biblioteca.getInstance();
        
    public void novoCliente (){
        System.out.println("Entre com os dados do novo cliente: ");
        Cliente novoCliente = leDadosCliente();
        System.out.println("Autenticando novo cliente...");
        int indiceCliente = Biblioteca.buscaIndiceCliente(novoCliente.getEmail());
        if(indiceCliente == -1) {
            System.out.println("Inserindo cliente aos registros...");
            biblioteca.insereCliente(novoCliente);
            System.out.println("Cliente registrado com sucesso!");
        } else {
            System.out.println("Cadastro rejeitado! Cliente já registrado no sistema: ");
            Cliente registrado = biblioteca.buscaPorEmail(novoCliente.getEmail());
            System.out.println(registrado.toString());
        }
    }
    
    Scanner scanner = new Scanner(System.in);
    
    public Cliente leDadosCliente(){
        String nome = null, email = null;
        System.out.println("Digite o nome do cliente: ");
        nome =  scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        email =  scanner.nextLine();                     // leitura do nome e email(validar? @ e .com)
        Cliente novoCliente = new Cliente(nome,email,1); // criar id serializavel na classe cliente
        return novoCliente;
    }
}
