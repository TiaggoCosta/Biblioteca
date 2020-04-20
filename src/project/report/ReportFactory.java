package project.report;

public class ReportFactory {
	
	public static IReportStrategy GetRelatorio(String nomeRelatorio){
		IReportStrategy strategy = null;
		
		if (nomeRelatorio.equalsIgnoreCase("Acervo Livros")) {
			strategy = new AcervoLivrosRelatorio();
		} else if (nomeRelatorio.equalsIgnoreCase("Acervo Periodicos")) {
			strategy = new AcervoPeriodicosRelatorio();
		} else if (nomeRelatorio.equalsIgnoreCase("Livros Atrasados")) {
			strategy = new LivrosEntregaAtrasadaRelatorio();
		}
		
		return strategy;
	}
}
