package project.report;

import java.time.LocalDate;
import java.util.List;

import project.Biblioteca;
import project.models.Emprestimo;

public class LivrosEntregaAtrasadaRelatorio implements IReportStrategy {

	@Override
	public String getNomeRelatorio() {
		return "Livros com Entregas Atrasadas";
	}

	@Override
	public void showData() {
		boolean livrosAtrasados = false;
		List<Emprestimo> emprestimos = Biblioteca.getInstance().getEmprestimos();
		
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %30s %20s", "Cliente", "Data Devolução", "Livro");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    
		for(Emprestimo emprestimo : emprestimos){
			if(emprestimo.getDataDevolucao().isBefore(LocalDate.now()))	{
				livrosAtrasados = true;
				 System.out.format("%10s %30s %20s",
			                emprestimo.getCliente().getNome(), emprestimo.getDataDevolucao(), emprestimo.getLivro().getTitulo());
			        System.out.println();
			}
		}
		
		if(!livrosAtrasados) {
			System.out.printf("%45s", "Não há Livros Atrasados");
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------------------------");
	}

}
