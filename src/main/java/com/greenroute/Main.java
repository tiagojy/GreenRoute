package com.greenroute;

import com.greenroute.controller.CidadeController;
import com.greenroute.controller.EletropostoController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CidadeController cidadeController = new CidadeController();
        EletropostoController eletropostoController = new EletropostoController();

        int opcao;

        do {

            System.out.println("\n=== GREEN ROUTE ===");
            System.out.println("1 - Gerenciar Cidades");
            System.out.println("2 - Gerenciar Eletropostos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cidadeController.menuCidade();
                    break;

                case 2:
                    eletropostoController.menuEletroposto();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
