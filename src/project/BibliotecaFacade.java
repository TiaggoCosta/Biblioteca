package project;

import java.util.Scanner;

import project.models.Cliente;
import project.report.IReportStrategy;
import project.report.ReportFactory;

public class BibliotecaFacade {

    Biblioteca biblioteca = Biblioteca.getInstance();
    Scanner scanner = new Scanner(System.in);
        
    public void novoCliente () {
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

    public void buscaCliente() {
        Cliente cliente = null;
        System.out.println("Selecione o campo de pesquisa: ");
        System.out.println ( "0) Sair \n1) ID \n2) Email " );
        switch (scanner.nextInt()) {
            case 0:
                break;
            case 1:
                System.out.println("Digite o ID do cliente: ");
                Integer idCliente = scanner.nextInt();
                cliente = biblioteca.buscaPorId(idCliente);
                break;
            case 2:
                System.out.println("Digite o email do cliente: ");
                String emailCliente = scanner.nextLine();
                cliente = biblioteca.buscaPorEmail(emailCliente);
                break;
            default:
                System.err.println ( "Opção inválida!" );
                break;
        }
        if(cliente != null) {
            System.out.println("Cliente encontrado: ");
            System.out.println(cliente.toString());
        } else {
            System.out.println("Nenhum cliente atende ao campo pesquisado!");
        }
        System.out.println("Retornando ao menu inicial...");
    }
    
    private Cliente leDadosCliente() {
        String nome = "", email = "";
        System.out.println("Digite o nome do cliente: ");
        while(nome.isEmpty())
            nome =  scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        while(email.isEmpty())
            email =  scanner.nextLine();                     // leitura do nome e email(validar? @ e .com)
        Cliente novoCliente = new Cliente(nome,email,1); // criar id serializavel na classe cliente
        return novoCliente;
    }
    
    public void selecionaRelatorio() {
        Integer opcao;
        IReportStrategy reportStrategy = null;

        boolean ligado = true;
    
        while(ligado) {
            System.out.println("\nSelecione o Relatório desejado: ");
            System.out.println(" 1 - Acervo Livros");
            System.out.println(" 2 - Acervo Periodicos");
            System.out.println(" 3 - Livros Atrasados");
            System.out.println(" 0 - Sair");
                
            opcao = Integer.valueOf(scanner.nextInt());
            
            switch (opcao) {
                case 1:
                case 2:
                case 3:
                    showRelatorio(opcao, reportStrategy);
                    break;
                                        
                case 0:
                    ligado = false;
                    break;
                    
                default:
                    System.err.println ( "Opção inválida!" );
            }
            
        }
    }
    
    private void showRelatorio(Integer opcao, IReportStrategy reportStrategy) {
        reportStrategy = ReportFactory.getRelatorio(opcao);
        reportStrategy.showData();
    }
}
