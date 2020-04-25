package project.report;

import java.util.List;

import project.Biblioteca;
import project.models.Livro;

public class AcervoLivrosRelatorio implements IReportStrategy {

	public String getNomeRelatorio() {
		return "Acervo Livros";
	}

	public void showData() {
		List<Livro> livros = Biblioteca.getInstance().getLivros();

		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("%20s %20s %20s %20s", "Titulo", "Autor", "Numero Paginas", "Editora");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");

		for (Livro livro : livros) {
			System.out.format("%20s %20s %20s %20s", livro.getTitulo(), livro.getAutor(), livro.getNumeroPaginas(),
					livro.getEditora());
			System.out.println();
		}

		System.out.println("----------------------------------------------------------------------------------------");
	}
}