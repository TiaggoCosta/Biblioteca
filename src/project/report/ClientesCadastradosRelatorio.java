package project.report;

import java.util.List;

import project.Biblioteca;
import project.models.Cliente;

public class ClientesCadastradosRelatorio implements IReportStrategy {

    @Override
    public String getNomeRelatorio() {
        return "Clientes Cadastrados";
    }

    @Override
    public void showData() {
        List<Cliente> clientes = Biblioteca.getInstance().getClientes();

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%30s %30s %20s", "Nome", "E-mail", "ID");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");

        for (Cliente cliente : clientes) {
            System.out.format("%30s %30s %20s", cliente.getNome(), cliente.getEmail(), cliente.getId());
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------------------------------");
    }

}