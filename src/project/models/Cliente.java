package project.models;

public class Cliente {
	
	private String nome;
	private String email;
	private Integer id;
	
	public Cliente(String nome, String email, Integer id) {
		this.nome = nome;
		this.email = email;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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