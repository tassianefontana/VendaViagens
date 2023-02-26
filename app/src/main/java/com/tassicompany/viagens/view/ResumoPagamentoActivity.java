package com.tassicompany.viagens.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.model.Pacote;
import com.tassicompany.viagens.util.DataUtil;
import com.tassicompany.viagens.util.MoedaUtil;
import com.tassicompany.viagens.util.ResourcesUtil;

import java.math.BigDecimal;

public class ResumoPagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("Sao Paulo", "sao_paulo_sp", 2,
                new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);

        mostraImagem(pacoteSaoPaulo);

        mostraData(pacoteSaoPaulo);

        mostraPreco(pacoteSaoPaulo);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        preco.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        data.setText(DataUtil.periodoEmTxt(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView ivImagem = findViewById(R.id.resumo_compra_imagem);
        ivImagem.setImageDrawable(ResourcesUtil.devolveDrawable(this, pacote.getImagem()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView tvLocal = findViewById(R.id.resumo_compra_local);
        tvLocal.setText(pacote.getLocal());
    }
}