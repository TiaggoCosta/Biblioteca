package project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo, bibliotecário!");
        Scanner scanner = new Scanner(System.in);
        BibliotecaFacade facade = new BibliotecaFacade();
        Menu menu = new Menu();
        int opt = -1;

        while (opt != 0) {
            display_menu();
            opt = scanner.nextInt();
            switch (opt) {
                case 0:
                    System.out.println("Desligando o sistema...");
                    scanner.close();
                    break;
                case 1:
                    menu.selecionaRelatorio();
                    break;
                case 2:
                    menu.operacoesCliente(facade);
                    break;
                case 3:
                    menu.operacoesLivros(facade);
                    break;
                case 4:
                    menu.operacoesEmprestimos(facade);
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    public static void display_menu() {
        System.out.println("--------------------------- Menu Principal ---------------------------");
        System.out.println("0) Desligar sistema \n1) Relatórios \n2) Clientes \n3) Livros \n4) Empréstimos");
        System.out.print("Seleção: ");
    }
}
