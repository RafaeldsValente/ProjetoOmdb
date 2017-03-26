package com.example.rafael.projetoomdb;

import android.app.Activity;
import android.database.sqlite.SQLiteDoneException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    private TextView exibir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exibir = (TextView) findViewById(R.id.txDados);
    }

    public void loadJSON(View v){
        new DownloadFromOpenWeather().execute();
        Toast.makeText(getApplicationContext(),"Botão funfou",Toast.LENGTH_LONG).show();
    }

    private class DownloadFromOpenWeather extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://www.omdbapi.com/?t=Met%C3%A1stasis+");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                String result = Util.webToString(urlConnection.getInputStream());

                return result;
            } catch (Exception e) {
                Log.e("Error", "Error ", e);
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String jsonString) {
            super.onPostExecute(jsonString);
            FilmeSeriado filmeseriado = Util.jsonToFilmeSeriado(jsonString);
            if(filmeseriado != null){

                String dadosFilmes = "Título: " + filmeseriado.getTitulo() + "\n" +
                        "Gênero: " + filmeseriado.getGenero() + "\n" +
                        "Ano: " + filmeseriado.getAno() + "\n" +
                        "País: " + filmeseriado.getPais() + "\n" +
                        "Duração: " + filmeseriado.getDuracao() + "\n" +
                        "Avaliação: " + filmeseriado.getAvaliacao();
                exibir.setText(dadosFilmes);
            }
        }
    }
}
