package project;

import project.report.IReportStrategy;
import project.report.ReportFactory;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void operacoesCliente(BibliotecaFacade facade) {
        Integer opcao;
        boolean ligado = true;
    
        while(ligado) {
            System.out.println("--------------------------- Menu Clientes ---------------------------");
            System.out.println ( "0) Sair \n1) Novo Cliente \n2) Pesquisar Clientes \n3) Excluir Clientes" );
            System.out.print ( "Seleção: " );
                
            opcao = Integer.valueOf(scanner.nextInt());
            
            switch (opcao) {
                case 0:
                    ligado = false;
                    break;
                case 1:
                    facade.novoCliente();
                    break;
                case 2:
                    facade.buscaCliente();
                    break;
                case 3:
                    // facade.excluiCliente();
                    break;                      
                default:
                    System.err.println ( "Opção inválida!" );
            }
        }
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