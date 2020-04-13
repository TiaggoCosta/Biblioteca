package project;

public class Cliente {
	
	private String nome;
	private String email;
	private Integer id;
	
	private Cliente(Builder builder) {
		this.nome = builder.nome;
		this.email = builder.email;
		this.id = builder.id;
	}
	
	public static class Builder {
		private String nome;
		private String email;
		private Integer id;
		
		public Builder() {
			
		}
		
		public Builder withNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Cliente build() {
			return new Cliente(this);
		}
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente [nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
}