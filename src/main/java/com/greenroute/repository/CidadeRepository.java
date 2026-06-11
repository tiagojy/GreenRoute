package com.greenroute.repository;

import com.greenroute.model.Cidade;

public class CidadeRepository {

    private Cidade[] cidades = new Cidade[5];
    private int quantidadeCidade;

    public CidadeRepository(){

    }

    public void cadastrarCidade(Cidade cidade){

        if (quantidadeCidade < cidades.length){
            cidades[quantidadeCidade] = cidade;
            quantidadeCidade++;
        }
        else {
            Cidade[] arrayCidadeMaior = new Cidade[quantidadeCidade * 2];

            for (int i = 0; i < cidades.length; i++){
                arrayCidadeMaior[i] = cidades[i];
            }

            cidades = arrayCidadeMaior;
            cidades[quantidadeCidade] = cidade;
            quantidadeCidade++;
        }

    }
//LISTAR AS CIDADES CADASTRADAS NO ARRAY
    public void listarCidade(){
        for (int i = 0; i < quantidadeCidade; i++){
            System.out.println(cidades[i]);
        }
    }

//REMOVER CIDADE DO ARRAY
    public void removerCidade(int id){
        for (int i = 0; i < quantidadeCidade; i++){
            if (id == cidades[i].getId()){

                for (int j = i; j < quantidadeCidade - 1; j++){
                    cidades[j] = cidades[j + 1];
                }

                quantidadeCidade--;
                break;
            }
        }
    }

}