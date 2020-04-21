package project;

import java.util.Scanner;
import project.models.Livro;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Bem vindo, bibliotecário!");
        Scanner scanner = new Scanner(System.in);
        BibliotecaFacade liber = new BibliotecaFacade();
        
        /* Livro teste = new Livro.Builder().withTitulo("teste").build();
        System.out.println(teste.toString());
        
        Biblioteca.getInstance().insereLivro(teste); */
        
        //Biblioteca biblioteca = Biblioteca.getInstance();
        //biblioteca.insereLivro(teste);
        //biblioteca.insereLivro(new Livro.Builder().build());
        //Livro busca = biblioteca.buscaPorTitulo("teste");
        //System.out.println(busca.toString());
        
        /* liber.novoCliente();
        liber.novoCliente(); // para testar a facade insira dois clientes com o mesmo email
        liber.selecionaRelatorio(); */
        boolean ligado = true;
        while(ligado) {
            display_menu();
            switch ( scanner.nextInt() ) {
                case 0:
                    System.out.println ( "Desligando o sistema..." );
                    ligado = false;
                    break;
                case 1:
                    System.out.println ( "Você selecionou a opção 1" );
                    liber.novoCliente();
                    break;
                case 2:
                    System.out.println ( "Você selecionou a opção 2" );
                    break;
                case 3:
                    System.out.println ( "Você selecionou a opção 3" );
                    break;
                default:
                    System.err.println ( "Opção inválida!" );
                    break;
            }
        }
    }

    public static void display_menu() {
        System.out.println ( "0) Desligar sistema \n1) Novo Cliente \n2) Option 2\n3) Option 3" );
        System.out.print ( "Seleção " );
    }
}
