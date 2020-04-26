package project.report;

import java.util.List;

import project.Biblioteca;
import project.models.Livro;

public class AcervoLivrosRelatorio implements IReportStrategy {

	public String getNomeRelatorio() {
		return "Acervo Livros";
	}

	public void showData() {
		boolean livrosCadastrados = false;
		List<Livro> livros = Biblioteca.getInstance().getLivros();

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%40s %15s %30s %10s %20s", "Titulo", "ISBN", "Autor", "Paginas", "Editora");
		System.out.println();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");

		for (Livro livro : livros) {
			livrosCadastrados = true;
			System.out.format("%40s %15s %30s %10s %20s", livro.getTitulo(), livro.getIsbn(), livro.getAutor(),
					livro.getNumeroPaginas(), livro.getEditora());
			System.out.println();
		}

		if (!livrosCadastrados) {
			System.out.printf("%70s", "Não há Livros Cadastrados");
			System.out.println();
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
	}
}