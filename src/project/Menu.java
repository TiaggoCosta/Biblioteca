package project;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void displayMenuPrincipal() {
        System.out.println("--------------------------- Menu Principal ---------------------------");
        System.out.println("0) Desligar sistema \n1) Relatórios \n2) Clientes \n3) Livros \n4) Empréstimos");
        System.out.print("Seleção: ");
    }

    public void operacoesCliente(BibliotecaFacade facade) {
        int opt = -1;

        while (opt != 0) {
            System.out.println("--------------------------- Menu Clientes ---------------------------");
            System.out.println("0) Sair \n1) Novo Cliente \n2) Pesquisar Clientes \n3) Excluir Clientes");
            System.out.print("Seleção: ");

            opt = scanner.nextInt();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    facade.adicionaCliente();
                    break;
                case 2:
                    facade.buscaCliente();
                    break;
                case 3:
                    facade.excluiCliente();
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }

    public void operacoesLivros(BibliotecaFacade facade) {
        int opt = -1;

        while (opt != 0) {
            System.out.println("--------------------------- Menu Livros ---------------------------");
            System.out.println("0) Sair \n1) Novo Livro \n2) Pesquisar Livros \n3) Excluir Livros");
            System.out.print("Seleção: ");

            opt = scanner.nextInt();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    facade.adicionaLivro();
                    break;
                case 2:
                    facade.buscaLivro();
                    break;
                case 3:
                    facade.excluiLivro();
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }

    public void operacoesEmprestimos(BibliotecaFacade facade) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--------------------------- Menu Empréstimos ---------------------------");
            System.out.println("0) Sair \n1) Registrar Retirada \n2) Registrar Devolução");
            System.out.print("Seleção: ");

            opcao = Integer.valueOf(scanner.nextInt());

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    facade.registraRetirada();
                    break;
                case 2:
                    facade.registraDevolucao();
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }

    public void selecionaRelatorio(BibliotecaFacade facade) {
        int opt = -1;
        while (opt != 0) {
            System.out.println("--------------------------- Menu Relatórios ---------------------------");
            System.out.println(
                    "0) Sair \n1) Acervo Livros \n2) Livros Atrasados \n3) Livros Emprestados \n4) Clientes Cadastrados");
            System.out.print("Seleção: ");

            opt = Integer.valueOf(scanner.nextInt());

            switch (opt) {
                case 1:
                case 2:
                case 3:
                case 4:
                    facade.showRelatorio(opt);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }
}