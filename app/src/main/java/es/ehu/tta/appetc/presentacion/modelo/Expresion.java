package es.ehu.tta.appetc.presentacion.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by strav on 26/01/2018.
 */

public class Expresion {

    String login;
    List<Esaldiak> esaldia=new ArrayList<>();
    String respuesta;

    public Expresion(){

    }

    public Expresion(String login, List<Esaldiak> esaldia, String respuesta){
        this.login=login;
        this.esaldia=esaldia;
        this.respuesta=respuesta;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Esaldiak> getEsaldia() {
        return esaldia;
    }

    public void setEsaldia(List<Esaldiak> esaldia) {
        this.esaldia = esaldia;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public static class Esaldiak implements Serializable{
        String esaldiaCast;
        String esaldiaEusk;
        String audioFitxIzena;
        String erabiltzaileMota;
        int idEsaldiak;

        public Esaldiak(){

        }

        public Esaldiak(String esaldiaCast, String esaldiaEusk, String audioFitxIzena, String erabiltzaileMota, int idEsaldiak){
            this.esaldiaCast=esaldiaCast;
            this.esaldiaEusk=esaldiaEusk;
            this.audioFitxIzena=audioFitxIzena;
            this.erabiltzaileMota=erabiltzaileMota;
            this.idEsaldiak=idEsaldiak;
        }

        public String getEsaldiaCast() {
            return esaldiaCast;
        }

        public void setEsaldiaCast(String esaldiaCast) {
            this.esaldiaCast = esaldiaCast;
        }

        public String getEsaldiaEusk() {
            return esaldiaEusk;
        }

        public void setEsaldiaEusk(String esaldiaEusk) {
            this.esaldiaEusk = esaldiaEusk;
        }

        public String getAudioFitxIzena() {
            return audioFitxIzena;
        }

        public void setAudioFitxIzena(String audioFitxIzena) {
            this.audioFitxIzena = audioFitxIzena;
        }

        public String getErabiltzaileMota() {
            return erabiltzaileMota;
        }

        public void setErabiltzaileMota(String erabiltzaileMota) {
            this.erabiltzaileMota = erabiltzaileMota;
        }

        public int getIdEsaldiak() {
            return idEsaldiak;
        }

        public void setIdEsaldiak(int idEsaldiak) {
            this.idEsaldiak = idEsaldiak;
        }
    }


}
