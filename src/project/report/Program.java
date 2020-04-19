package project.report;

import java.util.Scanner;

public class Program {
	 public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Digite o nome do Relatório: ");
	String nomeRelatorio = scanner.nextLine();
	IReportStrategy rs = ReportFactory.GetRelatorio(nomeRelatorio);
	  
	
	if (rs != null){
		rs.showData();
	} else
		System.out.println("Relatório "+ nomeRelatorio + " não encontrado.");
		  
		System.out.println("\nPressione Enter para Sair...");
		scanner.nextLine();
	}
}