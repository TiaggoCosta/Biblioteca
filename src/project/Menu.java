package project;

import project.report.IReportStrategy;
import project.report.ReportFactory;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void operacoesCliente(BibliotecaFacade facade) {
        Integer opcao;
        boolean ligado = true;

        while (ligado) {
            System.out.println("--------------------------- Menu Clientes ---------------------------");
            System.out.println("0) Sair \n1) Novo Cliente \n2) Pesquisar Clientes \n3) Excluir Clientes");
            System.out.print("Seleção: ");

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
                    facade.excluiCliente();
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }

    public void operacoesLivros(BibliotecaFacade facade) {
        Integer opcao;
        boolean ligado = true;

        while (ligado) {
            System.out.println("--------------------------- Menu Livros ---------------------------");
            System.out.println("0) Sair \n1) Novo Livro \n2) Pesquisar Livros \n3) Excluir Livros");
            System.out.print("Seleção: ");

            opcao = Integer.valueOf(scanner.nextInt());

            switch (opcao) {
                case 0:
                    ligado = false;
                    break;
                case 1:
                    facade.adicionaNovoLivro();
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
        Integer opcao;
        boolean ligado = true;

        while (ligado) {
            System.out.println("--------------------------- Menu Empréstimos ---------------------------");
            System.out.println("0) Sair \n1) Registrar Retirada \n2) Registrar Devolução \n3) Consultar Empréstimos");
            System.out.print("Seleção: ");

            opcao = Integer.valueOf(scanner.nextInt());

            switch (opcao) {
                case 0:
                    ligado = false;
                    break;
                case 1:
                    facade.registraRetirada();
                    break;
                case 2:
                    // facade.devolveLivro();
                    break;
                case 3:
                    // facade.consultaEmprestimo;
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }

    public void selecionaRelatorio() {
        Integer opcao;
        IReportStrategy reportStrategy = null;

        boolean ligado = true;

        while (ligado) {
            System.out.println("--------------------------- Menu Relatórios ---------------------------");
            System.out.println("0) Sair \n1) Acervo Livros \n2) Acervo Periodicos \n3) Livros Atrasados");
            System.out.print("Seleção: ");

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
                    System.err.println("Opção inválida!");
            }
        }
    }

    private void showRelatorio(Integer opcao, IReportStrategy reportStrategy) {
        reportStrategy = ReportFactory.getRelatorio(opcao);
        reportStrategy.showData();
    }
}