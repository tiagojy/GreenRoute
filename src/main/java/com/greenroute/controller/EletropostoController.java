package com.greenroute.controller;

import com.greenroute.model.Eletroposto;
import com.greenroute.repository.EletropostoRepository;

import java.util.Scanner;

public class EletropostoController {

    private EletropostoRepository eletropostoRepository = new EletropostoRepository();
    private Scanner scanner = new Scanner(System.in);

    public void menuEletroposto(){

        int opcao;

        do {
            System.out.println("=== MENU ELETROPOSTO ===");
            System.out.println("1 - Cadastrar Eletroposto");
            System.out.println("2 - Listar Eletropostos");
            System.out.println("3 - Buscar Eletroposto");
            System.out.println("4 - Atualizar Eletroposto");
            System.out.println("5 - Remover Eletroposto");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();

            switch (opcao){

                case 1:
                    cadastrarEletroposto();
                    break;

                case 2:
                    listarEletropostos();
                    break;

                case 3:
                    buscarEletroposto();
                    break;

                case 4:
                    atualizarEletroposto();
                    break;

                case 5:
                    removerEletroposto();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarEletroposto(){

        System.out.print("Digite o ID do eletroposto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (eletropostoRepository.buscarEletroposto(id) != null){
            System.out.println("Já existe um eletroposto com esse ID!");
            return;
        }

        System.out.print("Digite o nome do eletroposto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a localização: ");
        String localizacao = scanner.nextLine();

        System.out.print("Digite o ID da cidade: ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite os conectores disponíveis: ");
        String tiposConectoresDisponiveis = scanner.nextLine();

        System.out.print("Digite a potência de carga (kW): ");
        double potenciaCargaKw = scanner.nextDouble();

        System.out.print("Digite o preço por kWh: ");
        double precoPorKwh = scanner.nextDouble();

        System.out.print("Digite a quantidade de vagas disponíveis: ");
        int vagasDisponiveis = scanner.nextInt();

        Eletroposto eletroposto = new Eletroposto(
                id,
                nome,
                localizacao,
                cidadeId,
                tiposConectoresDisponiveis,
                potenciaCargaKw,
                precoPorKwh,
                vagasDisponiveis
        );

        eletropostoRepository.cadastrarEletroposto(eletroposto);

        System.out.println("Eletroposto cadastrado com sucesso!");
    }

    private void listarEletropostos(){
        eletropostoRepository.listarEletropostos();
    }

    private void buscarEletroposto(){

        System.out.print("Digite o ID do eletroposto que deseja buscar: ");
        int id = scanner.nextInt();

        Eletroposto eletroposto = eletropostoRepository.buscarEletroposto(id);

        if (eletroposto != null){
            System.out.println(eletroposto);
        } else {
            System.out.println("Eletroposto não encontrado!");
        }
    }

    private void atualizarEletroposto(){

        System.out.print("Digite o ID do eletroposto que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (eletropostoRepository.buscarEletroposto(id) == null){
            System.out.println("Eletroposto não encontrado!");
            return;
        }

        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a nova localização: ");
        String localizacao = scanner.nextLine();

        System.out.print("Digite o novo ID da cidade: ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite os novos conectores disponíveis: ");
        String tiposConectoresDisponiveis = scanner.nextLine();

        System.out.print("Digite a nova potência de carga (kW): ");
        double potenciaCargaKw = scanner.nextDouble();

        System.out.print("Digite o novo preço por kWh: ");
        double precoPorKwh = scanner.nextDouble();

        System.out.print("Digite a nova quantidade de vagas disponíveis: ");
        int vagasDisponiveis = scanner.nextInt();

        Eletroposto eletropostoAtualizado = new Eletroposto(
                id,
                nome,
                localizacao,
                cidadeId,
                tiposConectoresDisponiveis,
                potenciaCargaKw,
                precoPorKwh,
                vagasDisponiveis
        );

        boolean atualizou = eletropostoRepository.atualizarEletroposto(eletropostoAtualizado);

        if (atualizou){
            System.out.println("Eletroposto atualizado com sucesso!");
        } else {
            System.out.println("Eletroposto não encontrado!");
        }
    }

    private void removerEletroposto(){

        System.out.print("Digite o ID do eletroposto que deseja remover: ");
        int id = scanner.nextInt();

        boolean removeu = eletropostoRepository.removerEletroposto(id);

        if (removeu){
            System.out.println("Eletroposto removido com sucesso!");
        } else {
            System.out.println("Eletroposto não encontrado!");
        }
    }
}