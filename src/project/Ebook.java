package project;

import java.util.Date;

public class Ebook {
    
    private String titulo;
    private Date dataPublicacao;
    private String autor;
    private String editora;
    private Integer numPaginas;
    private String asin;
    
    private Ebook(Builder builder) {
        this.titulo = builder.titulo;
        this.dataPublicacao = builder.dataPublicacao;
        this.autor = builder.autor;
        this.editora = builder.editora;
        this.numPaginas = builder.numPaginas;
        this.asin = builder.asin;
    }
    
    public static class Builder {
        private String titulo;
        private Date dataPublicacao;
        private String autor;
        private String editora;
        private Integer numPaginas;
        private String asin;
        
        public Builder(){
            
        }
        
        public Builder withTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }
        
        public Builder withDataPublicacao(Date dataPublicacao) {
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
        
        public Builder withAsin(String asin) {
            this.asin = asin;
            return this;
        }
        
        public Ebook build() {
            return new Ebook(this);
        }
        
    }

	public String getTitulo() {
		return titulo;
	}

	public Date getDataPublicacao() {
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

	public String getAsin() {
		return asin;
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
		sb.append(", asin=");
		sb.append(asin);
		sb.append("]");
		return sb.toString();
	}
}