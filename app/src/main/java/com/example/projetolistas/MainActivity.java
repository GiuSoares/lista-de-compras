package com.example.projetolistas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.projetolistas.JavaClasses.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends Activity {
	private FloatingActionButton addLista;

	ListView MinhasListas;
	List<Produto> Lista;
	AdapterProduto adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.i("adalto", "oi Zé Luis");

		addLista = (FloatingActionButton) findViewById(R.id.addLista);

		MinhasListas = (ListView) findViewById(R.id.minhasListas);

		addLista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, AddprodutoActivity.class));
			}
		});
	}

	private void carregarLista() {
		Log.i("adalto", "oi Zé");

		Lista = ProdutoDAO.listar(this);

		Log.i("cont", "total: " + Lista.size());

//manter        adapter = new ArrayAdapter(this,
//manter        android.R.layout.simple_list_item_1, lista );
		adapter = new AdapterProduto(this, Lista);
		MinhasListas.setAdapter(adapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		carregarLista();
	}


}
