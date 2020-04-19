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
		for(Periodico periodico : periodicos) {
			System.out.println(periodico.toString());
		}
	}

}
