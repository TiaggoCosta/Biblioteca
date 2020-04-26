package project.models;

import java.time.LocalDate;

public class Livro {

    private String titulo;
    private LocalDate dataPublicacao;
    private String autor;
    private String editora;
    private Integer numeroPaginas;
    private String isbn;

    private Livro(Builder builder) {
        this.titulo = builder.titulo;
        this.dataPublicacao = builder.dataPublicacao;
        this.autor = builder.autor;
        this.editora = builder.editora;
        this.numeroPaginas = builder.numeroPaginas;
        this.isbn = builder.isbn;
    }

    public static class Builder {
        private String titulo;
        private LocalDate dataPublicacao;
        private String autor;
        private String editora;
        private Integer numeroPaginas;
        private String isbn;

        public Builder() {

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

        public Builder withNumeroPaginas(Integer numeroPaginas) {
            this.numeroPaginas = numeroPaginas;
            return this;
        }

        public Builder withIsbn(String isbn) {
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

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
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
        sb.append(", numeroPaginas=");
        sb.append(numeroPaginas);
        sb.append(", isbn=");
        sb.append(isbn);
        sb.append("]");
        return sb.toString();
    }
}