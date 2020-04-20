package project.report;

import java.util.List;

import project.Biblioteca;
import project.models.Periodico;

public class AcervoPeriodicosRelatorio implements IReportStrategy {

	@Override
	public String getNomeRelatorio() {
		return "Acervo Periodicos";
	}

	@Override
	public void showData() {
		List<Periodico> periodicos = Biblioteca.getInstance().getPeriodicos();
		
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%20s %30s %20s", "ISSN", "Nome", "Editora");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		
		for(Periodico periodico : periodicos) {
			System.out.format("%20s %30s %20s",
					periodico.getIssn(), periodico.getNome(), periodico.getEditora());
	        System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------------------------");
	}

}
