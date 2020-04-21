package project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo, bibliotecário!");
        Scanner scanner = new Scanner(System.in);
        BibliotecaFacade liber = new BibliotecaFacade();

        boolean ligado = true;

        while(ligado) {
            display_menu();
            switch (scanner.nextInt()) {
                case 0:
                    System.out.println ( "Desligando o sistema..." );
                    ligado = false;
                    scanner.close();
                    break;
                case 1:
                    System.out.println ( "Você selecionou a opção 1" );
                    liber.selecionaRelatorio();
                    break;
                case 2:
                    System.out.println ( "Você selecionou a opção 2" );
                    liber.novoCliente();
                    break;
                case 3:
                    System.out.println ( "Você selecionou a opção 3" );
                    liber.buscaCliente();
                    break;
                default:
                    System.err.println ( "Opção inválida!" );
            }
        }
        scanner.close();
    }

    public static void display_menu() {
        System.out.println("---------------------------Menu Principal---------------------------");
        System.out.println ( "0) Desligar sistema \n1) Gerar Relatório \n2) Novo Cliente\n3) Pesquisar Cliente" );
        System.out.print ( "Seleção " );
    }
}
