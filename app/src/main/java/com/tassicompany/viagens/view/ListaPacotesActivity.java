package com.tassicompany.viagens.view;

import static com.tassicompany.viagens.view.PacoteActivity.CHAVE_PACOTE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.adapter.ListaPacotesAdapter;
import com.tassicompany.viagens.dao.PacoteDAO;
import com.tassicompany.viagens.model.Pacote;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        mContext = this.getApplicationContext();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_list_view);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        vaiParaResumoPacote(listaPacotes, pacotes);
    }

    private void vaiParaResumoPacote(ListView listaPacotes, List<Pacote> pacotes) {
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Pacote pacoteClicado = pacotes.get(posicao);
                Intent intent = new Intent(mContext, ResumoPacoteActivity.class);
                intent.putExtra(CHAVE_PACOTE, pacoteClicado);
                startActivity(intent);
            }
        });
    }

}