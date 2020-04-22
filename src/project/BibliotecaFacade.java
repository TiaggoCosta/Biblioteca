package project;

import java.time.LocalDate;
import java.util.Scanner;

import project.models.Cliente;
import project.models.Livro;
import project.models.MeioPublicacao;

public class BibliotecaFacade {

    Biblioteca biblioteca = Biblioteca.getInstance();
    Scanner scanner = new Scanner(System.in);
        
    public void novoCliente () {
        System.out.println("Entre com os dados do novo cliente: ");
        Cliente novoCliente = leDadosCliente();
        System.out.println("Autenticando novo cliente...");
        int indiceCliente = Biblioteca.buscaIndiceCliente(novoCliente.getEmail());
        if(indiceCliente == -1) {
            System.out.println("Inserindo cliente aos registros...");
            biblioteca.insereCliente(novoCliente);
            System.out.println("Cliente registrado com sucesso!");
        } else {
            System.out.println("Cadastro rejeitado! Cliente já registrado no sistema: ");
            Cliente registrado = biblioteca.buscaPorEmail(novoCliente.getEmail());
            System.out.println(registrado.toString());
        }
    }

    public void buscaCliente() {
        Cliente cliente = null;
        String emailCliente = null;
        Integer idCliente = null;
        System.out.println("Selecione o campo de pesquisa: ");
        System.out.println ( "0) Sair \n1) ID \n2) Email " );
        switch (scanner.nextInt()) {
            case 0:
                break;
            case 1:
                System.out.println("Digite o ID do cliente: ");
                idCliente = scanner.nextInt();
                //cliente = biblioteca.buscaPorId(idCliente);
                break;
            case 2:
                System.out.println("Digite o email do cliente: ");
                while(emailCliente == null)
                    emailCliente = scanner.nextLine();
                cliente = biblioteca.buscaPorEmail(emailCliente);
                break;
            default:
                System.err.println ( "Opção inválida!" );
                break;
        }
        if (emailCliente != null ||  idCliente != null) {
            if(cliente != null) {
                System.out.println("Cliente encontrado: ");
                System.out.println(cliente.toString());
            } else {
                System.out.println("Nenhum cliente atende ao campo pesquisado!");
            }
        }
        System.out.println("Retornando ao menu inicial...");
    }
    
    private Cliente leDadosCliente() {
        String nome = "", email = "";
        System.out.println("Digite o nome do cliente: ");
        while(nome.isEmpty())
            nome =  scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        while(email.isEmpty())
            email =  scanner.nextLine(); // leitura do nome e email(validar? @ e .com)
        Cliente novoCliente = new Cliente(nome,email);
        return novoCliente;
    }
    
    public void adicionaNovoLivro() {
        System.out.println("Entre com os dados do novo livro: ");
        Livro novoLivro = lerDadosLivro();
        System.out.println("Autenticando novo cliente...");
        int indiceCliente = biblioteca.buscaIndiceLivro(novoLivro.getIsbn());
    
        if(indiceCliente == -1) {
            System.out.println("Adicionando livro no acervo...");
            biblioteca.insereLivro(novoLivro);
            System.out.println("Livro adicionado com sucesso!");
            System.out.println(novoLivro.toString());
        } else {
            System.out.println("Cadastro rejeitado! Livro já consta no acervo: ");
            Livro registrado = biblioteca.buscaPorISBN(novoLivro.getIsbn());
            System.out.println(registrado.toString());
        }
    }
    
    private Livro lerDadosLivro() {
        String titulo = "";
        LocalDate dataPublicacao = null;
        String autor = "";
        String editora = "";
        Integer numeroPaginas = null;
        Integer isbn = null;
        MeioPublicacao meioPublicacao;
    
        System.out.println("Digite o titulo do livro: ");
        while(titulo.isEmpty())
            titulo =  scanner.nextLine();
    
        System.out.println("Digite o autor do livro: ");
        while(autor.isEmpty())
            autor =  scanner.nextLine();
    
        System.out.println("Digite a editora do livro: ");
        while(editora.isEmpty())
            editora =  scanner.nextLine();
    
        System.out.println("Digite o isbn do livro: ");
        while(isbn == null)
            isbn =  scanner.nextInt();
    
        System.out.println("Digite a quantidade de páginas do livro: ");
        while(numeroPaginas == null)
            numeroPaginas =  scanner.nextInt();
    
        System.out.println("Digite a data de publicação do livro no formato DD-MM-AA: ");
        String data = "";
        while(data.isEmpty()){
            data =  scanner.nextLine();
        }

        String arr[] = data.split("-");
        dataPublicacao = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
    
        return new Livro.Builder().withTitulo(titulo).withAutor(autor)
                    .withEditora(editora).withIsbn(isbn).withNumeroPaginas(numeroPaginas)
                    .withDataPublicacao(dataPublicacao).build();
    }
}
