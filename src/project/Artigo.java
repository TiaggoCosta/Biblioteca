package project;

import java.util.List;

public class Artigo {
	
	private String titulo;
	private Integer numeroPaginas;
	private List<String> autores;
	
	public Artigo(String titulo, Integer numeroPaginas, List<String> autores) {
		this.titulo = titulo;
		this.numeroPaginas = numeroPaginas;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Artigo [titulo=");
		sb.append(titulo);
		sb.append(", numeroPaginas=");
		sb.append(numeroPaginas);
		sb.append(", autores=");
		sb.append(autores);
		sb.append("]");
		return sb.toString();
	}
}
