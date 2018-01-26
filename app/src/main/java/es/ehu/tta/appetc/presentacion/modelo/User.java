package es.ehu.tta.appetc.presentacion.modelo;

/**
 * Created by strav on 26/01/2018.
 */

public class User {

    //login
    String respuesta;

    //registro
    String izena;
    String nan;
    int adina;
    String herria;
    String amaHizkuntza;
    String pasahitza;
    String login;

    public User(){

    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public String getNan() {
        return nan;
    }

    public void setNan(String nan) {
        this.nan = nan;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getPasahitza() {
        return pasahitza;
    }

    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    public String getAmaHizkuntza() {
        return amaHizkuntza;
    }

    public void setAmaHizkuntza(String amaHizkuntza) {
        this.amaHizkuntza = amaHizkuntza;
    }

    public String getHerria() {
        return herria;
    }

    public void setHerria(String herria) {
        this.herria = herria;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
