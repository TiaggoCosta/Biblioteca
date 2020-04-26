package project.report;

public class ReportFactory {

	public static IReportStrategy getRelatorio(Integer idRelatorio) {
		IReportStrategy strategy = null;

		if (idRelatorio.equals(Integer.valueOf(1))) {
			strategy = new AcervoLivrosRelatorio();
		} else if (idRelatorio.equals(Integer.valueOf(2))) {
			strategy = new LivrosEntregaAtrasadaRelatorio();
		} else if (idRelatorio.equals(Integer.valueOf(3))) {
			strategy = new LivrosEmprestadosRelatorio();
		} else if (idRelatorio.equals(Integer.valueOf(4))) {
			strategy = new ClientesCadastradosRelatorio();
		}

		return strategy;
	}
}