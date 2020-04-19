package project;

import java.time.LocalDate;

public class Livro {
    
    private String titulo;
    private LocalDate dataPublicacao;
    private String autor;
    private String editora;
    private Integer numPaginas;
    private Integer isbn;
    
    private Livro(Builder builder) {
        this.titulo = builder.titulo;
        this.dataPublicacao = builder.dataPublicacao;
        this.autor = builder.autor;
        this.editora = builder.editora;
        this.numPaginas = builder.numPaginas;
        this.isbn = builder.isbn;
    }
    
    public static class Builder {
        private String titulo;
        private LocalDate dataPublicacao;
        private String autor;
        private String editora;
        private Integer numPaginas;
        private Integer isbn;
        
        public Builder(){
            
        }
        
        public Builder withTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }
        
        public Builder withDataPublicacao(LocalDate dataPublicacao) {
            this.dataPublicacao = dataPublicacao;
            return this;
        }
        
        public Builder withAutor(String autor) {
            this.autor = autor;
            return this;
        }
        
        public Builder withEditora(String editora) {
        	this.editora = editora;
        	return this;
        }
        
        public Builder withNumPaginas(Integer numPaginas) {
        	this.numPaginas = numPaginas;
        	return this;
        }
        
        public Builder withIsbn(Integer isbn) {
            this.isbn = isbn;
            return this;
        }
        
        public Livro build() {
            return new Livro(this);
        }
    }

	public String getTitulo() {
		return titulo;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditora() {
		return editora;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public Integer getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Livro [titulo=");
		sb.append(titulo);
		sb.append(", dataPublicacao=");
		sb.append(dataPublicacao);
		sb.append(", autor=");
		sb.append(autor);
		sb.append(", editora=");
		sb.append(editora);
		sb.append(", numPaginas=");
		sb.append(numPaginas);
		sb.append(", isbn=");
		sb.append(isbn);
		sb.append("]");
		return sb.toString();
	}
}