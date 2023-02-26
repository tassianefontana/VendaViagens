package com.tassicompany.viagens.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.model.Pacote;
import com.tassicompany.viagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        mContext = this.getApplicationContext();

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraPreco(pacote);

            Button btnFinalizaCompra = findViewById(R.id.activity_pagamento_botao_finaliza_compra);
            btnFinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ResumoPagamentoActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView tvPreco = findViewById(R.id.activity_pagamento_valor);
        String moedaBr = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        tvPreco.setText(moedaBr);
    }
}