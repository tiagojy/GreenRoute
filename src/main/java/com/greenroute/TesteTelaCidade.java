package com.greenroute;

import com.greenroute.controller.CidadeController;
import com.greenroute.view.cidade.TelaCidade;

public class TesteTelaCidade {

    public static void main(String[] args) {

        CidadeController cidadeController = new CidadeController();

        TelaCidade telaCidade = new TelaCidade(cidadeController);

        telaCidade.setVisible(true);

    }
}
