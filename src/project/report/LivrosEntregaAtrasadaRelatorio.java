package project.report;

import java.time.LocalDate;
import java.util.List;

import project.Biblioteca;
import project.models.Emprestimo;

public class LivrosEntregaAtrasadaRelatorio implements IReportStrategy {

	@Override
	public String getNomeRelatorio() {
		return "Livros com Entregas Atrasadas";
	}

	@Override
	public void showData() {
		boolean livrosAtrasados = false;
		List<Emprestimo> emprestimos = Biblioteca.getInstance().getEmprestimos();

		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.printf("%30s %20s %20s  %20s", "Cliente", "Data Devolução", "Titulo Livro", "ISBN Livro");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------------");

		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDataDevolucao().isBefore(LocalDate.now())) {
				livrosAtrasados = true;
				System.out.format("%30s %20s %20s  %20s", emprestimo.getCliente().getNome(), emprestimo.getDataDevolucao(),
						emprestimo.getLivro().getTitulo(), emprestimo.getLivro().getIsbn());
				System.out.println();
			}
		}

		if (!livrosAtrasados) {
			System.out.printf("%65s", "Não há Livros Atrasados");
			System.out.println();
		}

		System.out.println("-----------------------------------------------------------------------------------------------------");
	}

}
