package project;

import project.models.Livro;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello goorm!");
        
        Livro teste = new Livro.Builder().withTitulo("teste").build();
        
        System.out.println(teste.toString());
        
        Biblioteca biblioteca = Biblioteca.getInstance();
        
        biblioteca.insereLivro(teste);
        biblioteca.insereLivro(new Livro.Builder().build());
        Livro busca = biblioteca.buscaPorTitulo("teste");
        System.out.println(busca.toString());
        
    }

}
