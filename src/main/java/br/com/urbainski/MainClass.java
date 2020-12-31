package br.com.urbainski;

import br.com.urbainski.network.INetwork;
import br.com.urbainski.network.exception.AbstractNetworkException;
import br.com.urbainski.network.impl.NetworkIntegerImpl;
import br.com.urbainski.util.StringUtils;

import java.util.Scanner;

/**
 * @author Cristian Urbainski
 * @since 29/12/2020
 */
public class MainClass {

    private INetwork<Integer> network;
    private TipoMenuEnum tipoMenuEnum;
    private final Scanner scanner;

    public MainClass() {

        tipoMenuEnum = TipoMenuEnum.PRINCIPAL;
        scanner = new Scanner(System.in);
    }

    public void execute() {

        while (true) {

            showMenuOpcoes(tipoMenuEnum);

            Integer op = readInteger();

            if (op == null) {

                continue;
            }

            tratarOpcao(tipoMenuEnum, op);
        }
    }

    private void tratarOpcao(TipoMenuEnum tipoMenuEnum, int op) {

        switch (tipoMenuEnum) {
            case PRINCIPAL:
                tratarOpcaoMenuPrincipal(op);
                break;
            case NETWORK:
                tratarOpcaoMenuNetwork(op);
                break;
        }
    }

    private void tratarOpcaoMenuNetwork(int op) {

        switch (op) {
            case 1:
                connectValues();
                break;
            case 2:
                consultValues();
                break;
            case 3:
                tipoMenuEnum = TipoMenuEnum.PRINCIPAL;
                network = null;
                break;
            case 4:
                encerrar();
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }

    private void consultValues() {

        System.out.println("Informe o primeiro valor: ");

        Integer v1 = readInteger();

        if (v1 == null) {

            return;
        }

        System.out.println("Informe o segundo valor: ");

        Integer v2 = readInteger();

        if (v2 == null) {

            return;
        }

        try {

            boolean result = network.consult(v1, v2);

            System.out.println(String.format("Resultado da consulta: %s", StringUtils.valueOf(result)));
        } catch (AbstractNetworkException ex) {

            System.out.println(ex.toString());
        }
    }

    private void connectValues() {

        System.out.println("Informe o primeiro valor: ");

        Integer v1 = readInteger();

        if (v1 == null) {

            return;
        }

        System.out.println("Informe o segundo valor: ");

        Integer v2 = readInteger();

        if (v2 == null) {

            return;
        }

        try {

            network.connect(v1, v2);

            System.out.println("Valores conectados!");
        } catch (AbstractNetworkException ex) {

            System.out.println(ex.toString());
        }
    }

    private void tratarOpcaoMenuPrincipal(int op) {

        switch (op) {
            case 1:
                inicializarNetwork();
                break;
            case 2:
                encerrar();
                break;
            default:
                System.out.println("Opção invalida!");
        }
    }

    private void encerrar() {

        System.out.println("Tchau Tchau");

        System.exit(0);
    }

    private void inicializarNetwork() {

        System.out.println("Informe o tamanho do Network que você deseja criar!");

        int size = readInteger();

        try {

            network = new NetworkIntegerImpl(size);
        } catch (AbstractNetworkException ex) {

            System.out.println(ex.toString());

            return;
        }

        tipoMenuEnum = TipoMenuEnum.NETWORK;
    }

    private Integer readInteger() {

        try {

            return scanner.nextInt();
        } catch (Throwable ex) {

            System.out.println("Não entendi, por favor informe novamente");

            return null;
        } finally {

            scanner.nextLine();
        }
    }

    private void showMenuOpcoes(TipoMenuEnum tipoMenuEnum) {

        switch (tipoMenuEnum) {
            case PRINCIPAL:
                showMenuOpcoesPrincipal();
                break;
            case NETWORK:
                showMenuOpcoesNetwork();
        }
    }

    private void showMenuOpcoesNetwork() {

        System.out.println("-- Menu -------------------------------------------");
        System.out.println(" 1 - Conectar valores");
        System.out.println(" 2 - Consultar valores");
        System.out.println(" 3 - Voltar ao menu anterior");
        System.out.println(" 4 - Encerar o sistema");
        System.out.println("----------------------------------------------------");
        System.out.println("Qual sua opção?");
    }

    private void showMenuOpcoesPrincipal() {

        System.out.println("-- Menu -------------------------------------------");
        System.out.println(" 1 - Inicialiar Network");
        System.out.println(" 2 - Encerar o sistema");
        System.out.println("----------------------------------------------------");
        System.out.println("Qual sua opção?");
    }

    private void showNetworkTamanho() {

        System.out.println(" Qual o tamanho do Network que você deseja criar?");
    }

    public static void main(String[] args) throws AbstractNetworkException {

        new MainClass().execute();
    }

    private static enum TipoMenuEnum {
        PRINCIPAL, NETWORK
    }

}