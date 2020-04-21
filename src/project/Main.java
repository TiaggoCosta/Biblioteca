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
                    liber.novoCliente();
                    break;
                case 2:
                    System.out.println ( "Você selecionou a opção 2" );
                    liber.selecionaRelatorio();
                    break;
                case 3:
                    System.out.println ( "Você selecionou a opção 3" );
                    break;
                default:
                    System.err.println ( "Opção inválida!" );
            }
        }
    }

    public static void display_menu() {
        System.out.println("---------------------------Menu Principal---------------------------");
        System.out.println ( "0) Desligar sistema \n1) Novo Cliente \n2) Gerar Relatório\n3) Option 3" );
        System.out.print ( "Seleção " );
    }
}
