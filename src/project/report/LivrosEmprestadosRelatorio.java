package project.report;

import java.util.List;

import project.Biblioteca;
import project.models.Emprestimo;

public class LivrosEmprestadosRelatorio implements IReportStrategy {

    @Override
    public String getNomeRelatorio() {
        return "Livros Emprestados";
    }

    @Override
    public void showData() {
        boolean livrosEmprestados = false;
        List<Emprestimo> emprestimos = Biblioteca.getInstance().getEmprestimos();

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%40s %15s %35s %20s", "Titulo Livro", "ISBN Livro", "Cliente", "Data Devolução");
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");

        for (Emprestimo emprestimo : emprestimos) {
            livrosEmprestados = true;
            System.out.format("%40s %15s %35s %20s", emprestimo.getLivro().getTitulo(), emprestimo.getLivro().getIsbn(),
                    emprestimo.getCliente().getNome(), emprestimo.getDataDevolucao());
            System.out.println();
        }

        if (!livrosEmprestados) {
            System.out.printf("%70s", "Não há Livros Emprestados");
            System.out.println();
        }

        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------");
    }

}