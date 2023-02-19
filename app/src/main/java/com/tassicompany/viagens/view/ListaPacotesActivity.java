package com.tassicompany.viagens.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.tassicompany.viagens.R;
import com.tassicompany.viagens.adapter.ListaPacotesAdapter;
import com.tassicompany.viagens.model.Pacote;
import com.tassicompany.viagens.dao.PacoteDAO;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        ListView listaPacotes = findViewById(R.id.lista_pacotes_list_view);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }


}