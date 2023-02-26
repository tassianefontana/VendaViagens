package com.tassicompany.viagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tassicompany.viagens.model.Pacote;
import com.tassicompany.viagens.util.MoedaUtil;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("Sao Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));
        mostraPreco(pacoteSaoPaulo);

    }

    private void mostraPreco(Pacote pacote) {
        TextView tvPreco = findViewById(R.id.activity_pagamento_valor);
        String moedaBr = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        tvPreco.setText(moedaBr);
    }
}