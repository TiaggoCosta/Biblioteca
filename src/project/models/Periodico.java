package project.models;

import java.util.List;

public class Periodico {
	
	private Integer issn;
	private String editora;
	private String nome;
	private List<Artigo> artigos;
	private MeioPublicacao meioPublicacao;
	
	private Periodico(Builder builder) {
		this.issn = builder.issn;
		this.editora = builder.editora;
		this.nome = builder.nome;
		this.artigos = builder.artigos;
		this.meioPublicacao = builder.meioPublicacao;
	}
	
	public static class Builder {
		private Integer issn;
		private String editora;
		private String nome;
		private List<Artigo> artigos;
		private MeioPublicacao meioPublicacao;
		
		public Builder() {
			
		}
		
		public Builder withIssn(Integer issn) {
			this.issn = issn;
			return this;
		}
		
		public Builder withEditora(String editora) {
			this.editora = editora;
			return this;
		}
		
		public Builder withNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder withArtigos(List<Artigo> artigos) {
			this.artigos = artigos;
			return this;
		}
		
		public Builder withMeioPublicacao(MeioPublicacao meioPublicacao) {
			this.meioPublicacao = meioPublicacao;
			return this;
		}
		
		public Periodico build() {
			return new Periodico(this);
		}
	}

	public Integer getIssn() {
		return issn;
	}

	public String getEditora() {
		return editora;
	}

	public String getNome() {
		return nome;
	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public MeioPublicacao getMeioPublicacao() {
		return meioPublicacao;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Periodico [issn=");
		sb.append(issn);
		sb.append(", editora=");
		sb.append(editora);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", artigos=");
		sb.append(artigos);
		sb.append(", meioPublicacao=");
		sb.append(meioPublicacao);
		sb.append("]");
		return sb.toString();
	}	
}
