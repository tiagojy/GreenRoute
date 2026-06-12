package com.greenroute.controller;

import com.greenroute.repository.CidadeRepository;
import java.util.Scanner;

public class CidadeController {

    private CidadeRepository cidadeRepository = new CidadeRepository();
    private Scanner scanner = new Scanner(System.in);

    public void menuCidade(){

        int opcao;

        do {
            System.out.println("=== MENU CIDADE ===");
            System.out.println("1 - Cadastrar Cidade");
            System.out.println("2 - Listar Cidade");
            System.out.println("3 - Buscar Cidade");
            System.out.println("4 - Atualizar Cidade");
            System.out.println("5 - Remover Cidade");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarCidade();
                    break;

                case 2:
                    listarCidade();
                    break;

                case 3:
                    buscarCidade();
                    break;

                case 4:
                    atualizarCidade();
                    break;

                case 5:
                    removerCidade();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }

        while (opcao != 0);
    }

    private void cadastrarCidade(){

    }

    private void listarCidade(){

    }

    private void buscarCidade(){

    }

    private void atualizarCidade(){

    }

    private void removerCidade(){

    }
}
