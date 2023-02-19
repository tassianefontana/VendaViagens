package com.tassicompany.viagens.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        @SuppressLint("ViewHolder") View viewCriada = LayoutInflater.from(context).
                inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraQtdDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        BigDecimal precodoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro
                .format(precodoPacote)
                .replace("R$", "R$ ");
        preco.setText(moedaBrasileira);
    }

    private void mostraQtdDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = "";
        int qtdDias = pacote.getDias();

        if (qtdDias > 1) {
            diasEmTexto = qtdDias + " dias";
        } else {
            diasEmTexto = qtdDias + " dia";
        }
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_cidade);
        local.setText(pacote.getLocal());
    }
}
