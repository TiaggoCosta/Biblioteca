package project;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

import project.models.Cliente;
import project.models.Livro;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo, bibliotecário!");
        Scanner scanner = new Scanner(System.in);
        BibliotecaFacade facade = new BibliotecaFacade();
        Menu menu = new Menu();
        int opt = -1;

        adicionaClientesIniciais();
        adicionaLivrosIniciais();

        while (opt != 0) {
            menu.displayMenuPrincipal();
            opt = scanner.nextInt();
            switch (opt) {
                case 0:
                    System.out.println("Desligando o sistema...");
                    scanner.close();
                    break;
                case 1:
                    menu.selecionaRelatorio(facade);
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
    }

    private static void adicionaLivrosIniciais() {
        Biblioteca biblioteca = Biblioteca.getInstance();

        biblioteca.insereLivro(new Livro.Builder().withTitulo("O Silmarillion").withAutor("J. R. R. Tolkien")
                .withEditora("HarperCollins").withIsbn("8595084378").withNumeroPaginas(496)
                .withDataPublicacao(LocalDate.of(2019, 03, 19)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("O Hobbit").withAutor("J. R. R. Tolkien")
                .withEditora("HarperCollins").withIsbn("8595084742").withNumeroPaginas(336)
                .withDataPublicacao(LocalDate.of(2019, 07, 15)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("O Senhor dos Anéis: A Sociedade do Anel")
                .withAutor("J. R. R. Tolkien").withEditora("HarperCollins").withIsbn("8595084750")
                .withNumeroPaginas(576).withDataPublicacao(LocalDate.of(2019, 11, 24)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("Harry Potter e a Pedra Filosofal")
                .withAutor("J.K. Rowling").withEditora("Rocco").withIsbn("8532530273").withNumeroPaginas(256)
                .withDataPublicacao(LocalDate.of(2016, 05, 31)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("Harry Potter e o prisioneiro de Azkaban")
                .withAutor("J.K. Rowling").withEditora("Rocco").withIsbn("853253080X").withNumeroPaginas(288)
                .withDataPublicacao(LocalDate.of(2017, Month.AUGUST, 19)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("Harry Potter e a Câmara Secreta")
                .withAutor("J.K. Rowling").withEditora("Rocco").withIsbn("8532530796").withNumeroPaginas(224)
                .withDataPublicacao(LocalDate.of(2017, Month.AUGUST, 19)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("O diário de Anne Frank").withAutor("Anne Frank")
                .withEditora("Record").withIsbn("8501044458").withNumeroPaginas(352)
                .withDataPublicacao(LocalDate.of(1995, Month.SEPTEMBER, 29)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("A Menina Que Roubava Livros").withAutor("Markus Zusak")
                .withEditora("Intrinseca").withIsbn("8598078379").withNumeroPaginas(382)
                .withDataPublicacao(LocalDate.of(2008, 01, 01)).build());

        biblioteca.insereLivro(new Livro.Builder().withTitulo("O Pequeno Príncipe")
                .withAutor("Antoine de Saint-Exupéry").withEditora("Melhoramentos").withIsbn("8506073251")
                .withNumeroPaginas(128).withDataPublicacao(LocalDate.of(2017, 10, 18)).build());
    }

    private static void adicionaClientesIniciais() {
        Biblioteca biblioteca = Biblioteca.getInstance();
        biblioteca.insereCliente(new Cliente("Karolina Pacheco", "karolinacp@edu.unisinos.br"));
        biblioteca.insereCliente(new Cliente("Nadine Schneider", "nadine_schneider@hotmail.com"));
        biblioteca.insereCliente(new Cliente("Tiago Costa", "tiagocsilva@edu.unisinos.br"));
    }

}
