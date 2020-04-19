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
		for(Livro livro : livros) {
			System.out.println(livro.toString());
		}
	}
}