package com.greenroute.controller;

import com.greenroute.repository.CidadeRepository;
import java.util.Scanner;
import com.greenroute.model.Cidade;

public class CidadeController {

    private CidadeRepository cidadeRepository = new CidadeRepository();
    private Scanner scanner = new Scanner(System.in);

    public void menuCidade(){

        int opcao;

        do {
            System.out.println("=== MENU CIDADE ===");
            System.out.println("1 - Cadastrar Cidade");
            System.out.println("2 - Listar Cidades");
            System.out.println("3 - Buscar Cidade");
            System.out.println("4 - Atualizar Cidade");
            System.out.println("5 - Remover Cidade");
            System.out.println("0 - Voltar");

            System.out.println("Escolha uma opção: ");
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

        System.out.print("Digite o ID da cidade que deseja cadastrar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (cidadeRepository.buscarCidade(id) != null){
            System.out.println("Já existe uma cidade com esse ID!");
            return;
        }

        System.out.print("Digite o nome da cidade: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();

        System.out.print("Digite a distância da capital: ");
        double distanciaDaCapital = scanner.nextDouble();

        Cidade cidade = new Cidade(id, nome, estado, distanciaDaCapital);

        cidadeRepository.cadastrarCidade(cidade);

        System.out.println("Cidade cadastrada com sucesso!");
    }

    private void listarCidade(){
        cidadeRepository.listarCidade();
    }

    private void buscarCidade(){
        System.out.print("Digite o ID da cidade: ");
        int id = scanner.nextInt();

        Cidade cidade = cidadeRepository.buscarCidade(id);

        if(cidade != null){
            System.out.println(cidade);
        } else {
            System.out.println("Cidade não encontrada!");
        }
    }

    private void atualizarCidade(){

        System.out.print("Digite o ID da cidade que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o novo nome da cidade: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o novo estado: ");
        String estado = scanner.nextLine();

        System.out.print("Digite a nova distância da capital: ");
        double distanciaDaCapital = scanner.nextDouble();

        Cidade cidadeAtualizada = new Cidade(
                id,
                nome,
                estado,
                distanciaDaCapital
        );

        boolean atualizou = cidadeRepository.atualizarCidade(cidadeAtualizada);

        if (atualizou){
            System.out.println("Cidade atualizada com sucesso!");
        } else {
            System.out.println("Cidade não encontrada!");
        }
    }

    private void removerCidade(){
        System.out.print("Digite o ID da cidade que deseja remover: ");
        int id = scanner.nextInt();

        boolean removeu = cidadeRepository.removerCidade(id);

        if(removeu){
            System.out.println("Cidade removida com sucesso!");
        } else {
            System.out.println("Cidade não encontrada!");
        }
    }
}
