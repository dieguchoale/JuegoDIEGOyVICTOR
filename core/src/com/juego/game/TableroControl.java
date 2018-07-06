package com.juego.game;

import java.util.ArrayList;

/**
 * Created by Ines on 23/06/2018.
 */

public class TableroControl {
    public ArrayList<Casilla> casillas;
    float anchoPantalla, altoPantalla, lado_casilla;

    public TableroControl(float anchoPantalla, float altoPantalla, float lado_casilla){
        this.altoPantalla=altoPantalla;
        this.anchoPantalla=anchoPantalla;
        this.lado_casilla=lado_casilla;
        this.casillas = new ArrayList<Casilla>();
    }

    public void crearTablero(Forma forma){

        float y = 30;
        float x = anchoPantalla/2 - lado_casilla*5/2;
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 5; j++) {
                Casilla casilla = new Casilla(x, y, lado_casilla, forma, j + 1, i + 1, true, false);
                casillas.add(casilla);
                x += lado_casilla;
            }
            y += lado_casilla;
            x = anchoPantalla / 2 - lado_casilla * 5 / 2;
        }
        }

    public void pintarTableroControl(Forma forma){
        float y = 30;
        float x = anchoPantalla/2 - lado_casilla*5/2;
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 5; j++) {
                forma.definirForma(x,y,lado_casilla);
                x += lado_casilla;
            }
            y += lado_casilla;
            x = anchoPantalla / 2 - lado_casilla * 5 / 2;
        }
    }


    public Casilla obtenerCasillaPulsada (float x, float y){
        float y1 = altoPantalla-y;
        for (Casilla casilla: this.casillas){
            if ((casilla.getX()+lado_casilla>x) && (casilla.getY()+lado_casilla>y1)){
                return casilla;
            }
        }
        return null;
    }

    public Casilla devuelveCasilla(int X,int Y){
        for (Casilla casilla: casillas){
            if ((casilla.getEtiquetaX()==X)&&(casilla.getEtiquetaY()==Y)){
                return casilla;
            }
        }
        return null;
    }


    public void crearBloque(int X, int Y,Forma forma, ArrayList<Bloque> bloques){
        Bloque bloque=new Bloque(X,Y,lado_casilla,forma,this,bloques);
    }

    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }

}