package com.example.rafael.projetoomdb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 25/03/2017.
 */

public class Util {

    /**
     *Lê um arquivo da pasta raw (Resources) e converte o mesmo em String.
     *@param inputStream Stream do arquivo local no aplicativo
     *@return O arquivo convertido em String.
     */
    public static String rawToJson(InputStream inputStream) {
        InputStream localStream = inputStream;
        String jsonString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            jsonString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    /**
     *Lê um arquivo da web via HTTP e converte o mesmo em String.
     *@param inputStream Stream do arquivo local no aplicativo
     *@return O arquivo convertido em String.
     */
    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static FilmeSeriado jsonToFilmeSeriado(String jsonString){

        try {
            FilmeSeriado filmeseriado = new FilmeSeriado();

            JSONObject objetoJson = new JSONObject(jsonString);

            filmeseriado.setTitulo(objetoJson.getString("Title"));
            filmeseriado.setGenero(objetoJson.getString("Genre"));
            filmeseriado.setAno(objetoJson.getString("Year").replace("-", " "));
            filmeseriado.setPais(objetoJson.getString("Country"));
            filmeseriado.setDuracao(objetoJson.getString("Runtime"));
            filmeseriado.setAvaliacao(objetoJson.getString("imdbRating"));

            return filmeseriado;

        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

}
