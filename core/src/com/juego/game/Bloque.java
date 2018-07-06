package com.juego.game;

import java.util.ArrayList;

/**
 * Created by Ines on 18/06/2018.
 */

public class Bloque {
    public Forma forma;
    private int x, y;
    private float lado_casilla;
    public ArrayList<Bloque> conjuntoBloques;

    public Bloque(int x, int y,float lado_casilla, Forma forma, TableroControl tableroControl, ArrayList<Bloque> conjuntoBloques ){
        this.x = x;
        this.y = y;
        this.forma = forma;
        this.lado_casilla=lado_casilla;
        posicionarBloque(tableroControl,conjuntoBloques);
        this.forma.definirForma(x,y,lado_casilla);
    }


    public void posicionarBloque(TableroControl tableroControl, ArrayList<Bloque> conjuntoBloques) {
        if (tableroControl.devuelveCasilla(this.x, this.y).getBloque() == null) {
            tableroControl.devuelveCasilla(this.x, this.y).setBloque(this);
            if (conjuntoBloques != null)
                conjuntoBloques.add(this);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Forma getForma() {
        return forma;
    }

    public void setConjuntoBloques(ArrayList<Bloque> conjuntoBloques) {
        this.conjuntoBloques = conjuntoBloques;
    }
}