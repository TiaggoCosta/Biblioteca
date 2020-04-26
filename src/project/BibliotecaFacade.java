package project;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import project.models.Cliente;
import project.models.Emprestimo;
import project.models.Livro;
import project.report.IReportStrategy;
import project.report.ReportFactory;

public class BibliotecaFacade {

    private Biblioteca biblioteca = Biblioteca.getInstance();
    private Scanner scanner = new Scanner(System.in);
    private Cliente ultimoCliente = null;
    private Livro ultimoLivro = null;

    // operacoes clientes
    public void adicionaCliente() {
        System.out.println("Entre com os dados do novo cliente: ");
        Cliente novoCliente = lerDadosCliente();

        System.out.println("Autenticando novo cliente...");
        Cliente cliente = biblioteca.buscaPorEmail(novoCliente.getEmail());
        
        if (cliente == null) {
            System.out.println("Inserindo cliente aos registros...");
            biblioteca.insereCliente(novoCliente);
            ultimoCliente = novoCliente;
            System.out.println("Cliente registrado com sucesso!");
        } else {
            System.out.println("Cadastro rejeitado! Cliente já registrado no sistema: ");
            Cliente registrado = biblioteca.buscaPorEmail(novoCliente.getEmail());
            ultimoCliente = registrado;
            System.out.println(registrado.toString());
        }
    }

    private Cliente lerDadosCliente() {
        String nome = "";
        System.out.println("Digite o nome do cliente: ");
        while (nome.isEmpty())
            nome = scanner.nextLine();

        String email = "";
        System.out.println("Digite o email do cliente: ");
        while (email.isEmpty())
            email = scanner.next();

        return new Cliente(nome, email);
    }

    public void buscaCliente() {
        Cliente cliente = null;
        boolean pesquisado = false;
        int opt = -1;
        while (opt != 0 && pesquisado == false) {
            System.out.println("Selecione o campo de pesquisa: ");
            System.out.println("1) ID \n2) Email ");
            System.out.print("Seleção: ");
            opt = scanner.nextInt();
            switch (opt) {
                case 0:
                    break;
                case 1:
                    Integer idCliente = null;
                    System.out.println("Digite o ID do cliente: ");
                    idCliente = scanner.nextInt();
                    cliente = biblioteca.buscaPorId(idCliente);
                    pesquisado = true;
                    break;
                case 2:
                    String emailCliente = "";
                    System.out.println("Digite o email do cliente: ");
                    while (emailCliente.isEmpty())
                        emailCliente = scanner.next();
                    cliente = biblioteca.buscaPorEmail(emailCliente);
                    pesquisado = true;
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
        if (pesquisado) {
            if (cliente != null) {
                System.out.println("Cliente encontrado: ");
                System.out.println(cliente.toString());
                ultimoCliente = cliente;
            } else {
                System.out.println("Nenhum cliente atende ao campo pesquisado!");
            }
        }
        System.out.println("Retornando...");
    }

    public void excluiCliente() {
        boolean excluindo = true;
        while (excluindo) {
            if (ultimoCliente != null) {
                System.out.println("Deseja excluir o cadastro do seguinte cliente?");
                System.out.println(ultimoCliente.toString());
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int selecao = 0;
                selecao = scanner.nextInt();
                switch (selecao) {
                    case 1:
                        System.out.println("Excluindo...");
                        biblioteca.removeCliente(ultimoCliente);
                        ultimoCliente = null;
                        System.out.println("Cliente removido com sucesso!");
                        excluindo = false;
                        break;
                    case 2:
                        System.out.println("Encaminhando para busca do cliente...");
                        ultimoCliente = null;
                        break;
                    default:
                        System.err.println("Opção inválida!");
                        break;
                }
            } else {
                System.err.println("Deseja buscar cliente para excluir?");
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int opt = scanner.nextInt();
                if (opt == 2) {
                    break;
                } else {
                    buscaCliente();
                }
            }
        }
        System.out.println("Retornando ao menu cliente...");
    }

    // operacoes livros
    public void adicionaLivro() {
        System.out.println("Entre com os dados do novo livro: ");
        Livro novoLivro = lerDadosLivro();

        System.out.println("Autenticando novo livro...");
        Livro livro = biblioteca.buscaPorISBN(novoLivro.getIsbn());

        if (livro == null) {
            System.out.println("Adicionando livro no acervo...");
            biblioteca.insereLivro(novoLivro);
            ultimoLivro = novoLivro;
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("Cadastro rejeitado! Livro já consta no acervo: ");
            Livro registrado = biblioteca.buscaPorISBN(novoLivro.getIsbn());
            ultimoLivro = registrado;
            System.out.println(registrado.toString());
        }
    }

    private Livro lerDadosLivro() {
        String titulo = "";
        System.out.println("Digite o titulo do livro: ");
        while (titulo.isEmpty())
            titulo = scanner.nextLine();

        String autor = "";
        System.out.println("Digite o autor do livro: ");
        while (autor.isEmpty())
            autor = scanner.nextLine();

        String editora = "";
        System.out.println("Digite a editora do livro: ");
        while (editora.isEmpty())
            editora = scanner.nextLine();

        String isbn = "";
        System.out.println("Digite o isbn do livro: ");
        while (isbn.isEmpty())
            isbn = scanner.nextLine();

        System.out.println("Digite a quantidade de páginas do livro: ");
        Integer numeroPaginas = scanner.nextInt();

        String data = "";
        System.out.println("Digite a data de publicação do livro no formato DD-MM-AA: ");
        while (data.isEmpty())
            data = scanner.next();

        String arr[] = data.split("-");
        LocalDate dataPublicacao = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]),
                Integer.parseInt(arr[0]));

        return new Livro.Builder().withTitulo(titulo).withAutor(autor).withEditora(editora).withIsbn(isbn)
                .withNumeroPaginas(numeroPaginas).withDataPublicacao(dataPublicacao).build();
    }

    public void buscaLivro() {
        Livro livro = null;
        boolean pesquisado = false;
        int opt = -1;

        while (opt != 0 && pesquisado == false) {
            System.out.println("Selecione o campo de pesquisa: ");
            System.out.println("1) ISBN \n2) Titulo ");
            System.out.print("Seleção: ");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = "";
                    while (isbn.isEmpty())
                        isbn = scanner.nextLine();
                    livro = biblioteca.buscaPorISBN(isbn);
                    pesquisado = true;
                    break;
                case 2:
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = "";
                    while (titulo.isEmpty())
                        titulo = scanner.nextLine();
                    livro = biblioteca.buscaPorTitulo(titulo);
                    pesquisado = true;
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        }
        if (pesquisado) {
            if (livro != null) {
                System.out.println("Livro encontrado: ");
                System.out.println(livro.toString());
                ultimoLivro = livro;
            } else {
                System.out.println("Nenhum livro atende ao campo pesquisado!");
            }
        }
        System.out.println("Retornando...");
    }

    public void excluiLivro() {
        boolean excluindo = true;
        while (excluindo) {
            if (ultimoLivro != null) {
                System.out.println("Deseja excluir o cadastro do seguinte livro?");
                System.out.println(ultimoLivro.toString());
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int selecao = 0;
                selecao = scanner.nextInt();
                switch (selecao) {
                    case 1:
                        System.out.println("Excluindo...");
                        biblioteca.removeLivro(ultimoLivro);
                        ultimoLivro = null;
                        System.out.println("Livro removido com sucesso!");
                        excluindo = false;
                        break;
                    case 2:
                        System.out.println("Encaminhando para busca do livro...");
                        ultimoLivro = null;
                        break;
                    default:
                        System.err.println("Opção inválida!");
                        break;
                }
            } else {
                System.err.println("Deseja buscar livro para excluir?");
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int opt = scanner.nextInt();
                if (opt == 2) {
                    break;
                } else {
                    buscaLivro();
                }
            }
        }
        System.out.println("Retornando ao menu livro...");
    }

    // operacoes emprestimos
    public void registraRetirada() {
        Cliente clienteRetirando = null;
        boolean buscouCliente = true;
        while (clienteRetirando == null) {
            if (ultimoCliente != null) {
                System.out.println("Este cliente está requisitando a retirada?");
                System.out.println(ultimoCliente.toString());
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int selecao = 0;
                selecao = scanner.nextInt();
                switch (selecao) {
                    case 1:
                        clienteRetirando = ultimoCliente;
                        break;
                    case 2:
                        System.out.println("Encaminhando para busca do cliente...");
                        ultimoCliente = null;
                        break;
                    default:
                        System.err.println("Opção inválida!");
                        break;
                }
            } else {
                System.err.println("Deseja buscar cliente para retirada?");
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int opt = scanner.nextInt();
                if (opt == 2) {
                    buscouCliente = false;
                    break;
                } else {
                    System.out.println("Encaminhando para busca do cliente...");
                    buscaCliente();
                }
            }
        }
        if (buscouCliente) {
            System.out.println("Checando status do cliente...");
            List<Emprestimo> emprestimosCliente = biblioteca.getEmprestimos().stream()
                    .filter(emprestimo -> emprestimo.getCliente().getId() == ultimoCliente.getId())
                    .filter(emprestimo -> emprestimo.getDataDevolucao().isBefore(LocalDate.now()))
                    .collect(Collectors.toList());

            if (!emprestimosCliente.isEmpty()) {
                System.out.println("Cliente possui os seguintes livros atrasados:");
                emprestimosCliente.stream().forEach(e -> System.out.println(e.getLivro().toString()));
                System.out.println("Por favor realize a regularização antes de efetuar nova retirada!");

            } else {
                System.out.println("Cliente regularizado");
                System.out.println("Encaminhando para busca de livros...");
                boolean adicionandoLivros = true;
                Livro livroRetirado = null;
                String livrosRetirados = "";
                while (adicionandoLivros) {
                    buscaLivro();
                    livroRetirado = ultimoLivro;
                    biblioteca.registraRetirada(clienteRetirando, livroRetirado, LocalDate.now());
                    livrosRetirados += livroRetirado.toString() + "\n";
                    System.err.println("Deseja retirar mais livros?");
                    System.out.println("1) Sim \n2) Não ");
                    System.out.print("Seleção: ");
                    int escolha = 0;
                    escolha = scanner.nextInt();
                    if (escolha == 1) {
                        continue;
                    } else {
                        adicionandoLivros = false;
                    }
                }
                System.out.println("Registrando retirada...");
                System.out.println("Dados da retirada: ");
                System.out.println(clienteRetirando.toString());
                System.out.println(livrosRetirados);
                System.out.println("Data de devolução: " + LocalDate.now().plusMonths(1));
            }
        }
        System.out.println("Retornando...");
    }

    public void registraDevolucao() {
        Cliente clienteDevolvendo = null;
        boolean buscouCliente = true;
        while (clienteDevolvendo == null) {
            if (ultimoCliente != null) {
                System.out.println("Este cliente está requisitando a devolução?");
                System.out.println(ultimoCliente.toString());
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int selecao = 0;
                selecao = scanner.nextInt();
                switch (selecao) {
                    case 1:
                        clienteDevolvendo = ultimoCliente;
                        break;
                    case 2:
                        System.out.println("Encaminhando para busca do cliente...");
                        ultimoCliente = null;
                        break;
                    default:
                        System.err.println("Opção inválida!");
                        break;
                }
            } else {
                System.err.println("Deseja buscar cliente para devolução?");
                System.out.println("1) Sim \n2) Não ");
                System.out.print("Seleção: ");
                int opt = scanner.nextInt();
                if (opt == 2) {
                    buscouCliente = false;
                    break;
                } else {
                    System.out.println("Encaminhando para busca do cliente...");
                    buscaCliente();
                }
            }
        }
        if (buscouCliente) {
            System.out.println("Buscando empréstimos do cliente...");
            int id = clienteDevolvendo.getId();
            List<Emprestimo> emprestimosPendentes = biblioteca.getEmprestimos().stream()
                    .filter(emprestimo -> emprestimo.getCliente().getId() == id).collect(Collectors.toList());
            boolean adicionandoLivros = true;
            while (adicionandoLivros) {
                for (Emprestimo emprestimo : emprestimosPendentes) {
                    System.err.println("Deseja devolver este livro?");
                    System.out.println(emprestimo.getLivro().toString());
                    System.out.println("1) Sim \n2) Não ");
                    System.out.print("Seleção: ");
                    int escolha = 0;
                    escolha = scanner.nextInt();
                    if (escolha == 1) {
                        System.out.println("Calculando multa... ");
                        Double multa = emprestimo.getValorMulta();
                        if (multa > 0) {
                            System.out.println("Multa de R$ " + multa + " pelo atraso!");
                        } else {
                            System.out.println("Entrega no prazo. Sem multa por este empréstimo!");
                        }
                        biblioteca.registraDevolucao(emprestimo.getCliente(), emprestimo.getLivro());
                    } else {
                        System.out.println("Buscando outro empréstimo...");
                    }
                }
                System.out.println("Sem mais empréstimos para este cliente!");
                adicionandoLivros = false;
            }
        }
        System.out.println("Retornando...");
    }

    // operacoes relatorios
    public void showRelatorio(Integer opcao) {
        IReportStrategy reportStrategy = ReportFactory.getRelatorio(opcao);
        reportStrategy.showData();
    }
}
