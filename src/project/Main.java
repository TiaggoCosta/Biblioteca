package project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo, bibliotecário!");
        Scanner scanner = new Scanner(System.in);
        BibliotecaFacade facade = new BibliotecaFacade();
        Menu menu = new Menu();

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
                    menu.selecionaRelatorio();
                    break;
                case 2:
                    System.out.println ( "Você selecionou a opção 2" );
                    menu.operacoesCliente(facade);
                    break;
                case 3:
                    System.out.println ( "Você selecionou a opção 3" );
                    
                    break;
                case 4:
                    System.out.println ( "Você selecionou a opção 4" );
                    
                    break;
                default:
                    System.err.println ( "Opção inválida!" );
            }
        }
        scanner.close();
    }

    public static void display_menu() {
        System.out.println("---------------------------Menu Principal---------------------------");
        System.out.println ( "0) Desligar sistema \n1) Relatórios \n2) Clientes \n3) Livros \n4) Empréstimos" );
        System.out.print ( "Seleção: " );
    }
}
