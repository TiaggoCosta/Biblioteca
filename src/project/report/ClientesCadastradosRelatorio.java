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
        boolean clientesCadastrados = false;
        List<Cliente> clientes = Biblioteca.getInstance().getClientes();

        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.printf("%35s %40s %20s", "Nome", "E-mail", "ID");
        System.out.println();
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        for (Cliente cliente : clientes) {
            clientesCadastrados = true;
            System.out.format("%35s %40s %20s", cliente.getNome(), cliente.getEmail(), cliente.getId());
            System.out.println();
        }

        if (!clientesCadastrados) {
            System.out.printf("%60s", "Não há Clientes Cadastrados");
            System.out.println();
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------------");
    }

}