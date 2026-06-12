package com.greenroute.repository;

import com.greenroute.model.Eletroposto;

public class EletropostoRepository {
    private Eletroposto[] eletropostos = new Eletroposto[5];
    private int quantidadeEletropostos;

    public void cadastrarEletroposto(Eletroposto eletroposto){
        if (quantidadeEletropostos < eletropostos.length){
            eletropostos[quantidadeEletropostos] = eletroposto;
            quantidadeEletropostos++;
        }
        else {
            Eletroposto[] arrayEletropostoMaior = new Eletroposto[quantidadeEletropostos * 2];

            for (int i = 0; i < eletropostos.length; i++){
                arrayEletropostoMaior[i] = eletropostos[i];
            }

            eletropostos = arrayEletropostoMaior;
            eletropostos[quantidadeEletropostos] = eletroposto;
            quantidadeEletropostos++;
        }
    }

    //LISTAR OS ELETROPOSTOS CADASTRADOS NO ARRAY
    public void listarEletropostos(){
        for (int i = 0; i < quantidadeEletropostos; i++){
            System.out.println(eletropostos[i]);
        }
    }

    //REMOVER O ELETROPOSTO CADASTRADO NO ARRAY
    public void removerEletroposto(int id){
        for (int i = 0; i < quantidadeEletropostos; i++){
            if (id == eletropostos[i].getId()){

                for (int j = i; j < quantidadeEletropostos - 1; j++){
                    eletropostos[j] = eletropostos[j + 1];
                }

                eletropostos[quantidadeEletropostos - 1] = null;
                quantidadeEletropostos--;
                break;
            }
        }
    }

    //ATUALIZAR O ELETROPOSTO NO ARRAY PELO ID
    public boolean atualizarEletroposto(Eletroposto eletropostoAtualizado){
        for (int i = 0; i < quantidadeEletropostos; i++){
            if (eletropostoAtualizado.getId() == eletropostos[i].getId()){
                eletropostos[i] = eletropostoAtualizado;
                return true;
            }
        }
        return false;
    }

    //BUSCAR O ELETROPOSTO CADASTRADO NO ARRAY PELO ID
    public Eletroposto buscarEletroposto(int id){
        for (int i = 0; i < quantidadeEletropostos; i++){
            if (id == eletropostos[i].getId()){
                return eletropostos[i];
            }
        }
        return null;
    }
}
