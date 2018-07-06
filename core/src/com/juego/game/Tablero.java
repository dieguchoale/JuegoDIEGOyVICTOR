package com.juego.game;

import java.util.ArrayList;

/**
 * Created by Ines on 18/06/2018.
 */

public class Tablero{
    private float anchoPantalla;
    private float altoPantalla;
    private float lado_casilla;
    private boolean color;
    public ArrayList<Casilla> casillas;



    public Tablero(float anchoPantalla, float altoPantalla, float lado_casilla){
        this.anchoPantalla=anchoPantalla;
        this.altoPantalla=altoPantalla;
        this.lado_casilla=lado_casilla;
        casillas = new ArrayList<Casilla>();
    }



    public void crearCasillas(Forma forma){

            float y = (altoPantalla - 50) - (lado_casilla * 15);
            float x = anchoPantalla / 2 - lado_casilla * 5 / 2;

            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i > 3) {
                        color = true;
                    } else {
                        color = false;
                    }
                    Casilla casilla = new Casilla(x, y, lado_casilla, forma, i + 1, j + 1, color, false);
                    casillas.add(casilla);
                    x += lado_casilla;
                }
                y += lado_casilla;
                x = anchoPantalla / 2 - lado_casilla * 5 / 2;
            }
        }

        public void pintarTablero(Forma forma){
            float y = (altoPantalla - 50) - (lado_casilla * 15);
            float x = anchoPantalla / 2 - lado_casilla * 5 / 2;
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    forma.definirForma(x,y,lado_casilla);
                    x += lado_casilla;
                }
                y += lado_casilla;
                x = anchoPantalla / 2 - lado_casilla * 5 / 2;
            }
        }


    public Casilla devuelveCasilla(int X,int Y){
        for (Casilla casilla: casillas){
            if ((casilla.getEtiquetaX()==X)&&(casilla.getEtiquetaY()==Y)){
                return casilla;
            }
        }
        return null;
    }

    public double getLado_casilla() {
        return lado_casilla;
    }

    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }


}
