package com.tassicompany.viagens.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.model.Pacote;
import com.tassicompany.viagens.util.DataUtil;
import com.tassicompany.viagens.util.DiasUtil;
import com.tassicompany.viagens.util.MoedaUtil;
import com.tassicompany.viagens.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        mContext = this.getApplicationContext();

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);

            Button btnRealizaPgto = findViewById(R.id.activity_resumo_pacote_botao_pgto);
            btnRealizaPgto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PagamentoActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.activity_resumo_pacote_data);
        String dataFormatada = DataUtil.periodoEmTxt(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.activity_resumo_pacote_preco);
        preco.setText(MoedaUtil.formataParaBrasileiro(pacote.getPreco()));
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.activity_resumo_pacote_dias);
        dias.setText(DiasUtil.formataDiasEmTxt(pacote.getDias()));
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.activity_resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.activity_resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}