package project.report;

public class ReportFactory {
	
	public static IReportStrategy GetRelatorio(String nomeRelatorio){
		IReportStrategy strategy = null;
		
		if (nomeRelatorio.equals("Acervo Livros")) {
			strategy = new AcervoLivrosRelatorio();
		} else if (nomeRelatorio.equals("Acervo Periodicos")) {
			strategy = new AcervoPeriodicosRelatorio();
		}
		
		return strategy;
	}
}
