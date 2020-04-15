package project;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.util.Date;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f

public class Livro {
    
    private String titulo;
<<<<<<< HEAD
    private LocalDate dataPublicacao;
=======
    private Date dataPublicacao;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
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
<<<<<<< HEAD
        private LocalDate dataPublicacao;
=======
        private Date dataPublicacao;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
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
        
<<<<<<< HEAD
        public Builder withDataPublicacao(LocalDate dataPublicacao) {
=======
        public Builder withDataPublicacao(Date dataPublicacao) {
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
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

<<<<<<< HEAD
	public LocalDate getDataPublicacao() {
=======
	public Date getDataPublicacao() {
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
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