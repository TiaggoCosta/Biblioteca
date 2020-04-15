package project;

<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.util.Date;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f

public class Ebook {
    
    private String titulo;
<<<<<<< HEAD
    private LocalDate dataPublicacao;
    private String autor;
    private String editora;
    private Integer numPaginas;
    private Integer isbn;
=======
    private Date dataPublicacao;
    private String autor;
    private String editora;
    private Integer numPaginas;
    private String asin;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
    
    private Ebook(Builder builder) {
        this.titulo = builder.titulo;
        this.dataPublicacao = builder.dataPublicacao;
        this.autor = builder.autor;
        this.editora = builder.editora;
        this.numPaginas = builder.numPaginas;
<<<<<<< HEAD
        this.isbn = builder.isbn;
=======
        this.asin = builder.asin;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
    }
    
    public static class Builder {
        private String titulo;
<<<<<<< HEAD
        private LocalDate dataPublicacao;
        private String autor;
        private String editora;
        private Integer numPaginas;
        private Integer isbn;
=======
        private Date dataPublicacao;
        private String autor;
        private String editora;
        private Integer numPaginas;
        private String asin;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
        
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
        
<<<<<<< HEAD
        public Builder withAsin(Integer isbn) {
            this.isbn = isbn;
=======
        public Builder withAsin(String asin) {
            this.asin = asin;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
            return this;
        }
        
        public Ebook build() {
            return new Ebook(this);
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

<<<<<<< HEAD
	public Integer getIsbn() {
		return isbn;
=======
	public String getAsin() {
		return asin;
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ebook [titulo=");
		sb.append(titulo);
		sb.append(", dataPublicacao=");
		sb.append(dataPublicacao);
		sb.append(", autor=");
		sb.append(autor);
		sb.append(", editora=");
		sb.append(editora);
		sb.append(", numPaginas=");
		sb.append(numPaginas);
<<<<<<< HEAD
		sb.append(", isbn=");
		sb.append(isbn);
=======
		sb.append(", asin=");
		sb.append(asin);
>>>>>>> 8097326fd1bf6543453f01d191b7d19aa87b758f
		sb.append("]");
		return sb.toString();
	}
}