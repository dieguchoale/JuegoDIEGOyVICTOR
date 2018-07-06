package com.juego.game;

import java.util.ArrayList;

/**
 * Created by diego on 6/7/2018.
 */

//todo:    ESTA CLASE NO ESTA SIENDO USADA DE MOMENTO....

public class BloqueActor {
    public Forma forma;

    public BloqueActor(int x, int y,float lado_casilla, Forma forma ){
        this.forma = forma;
        this.forma.definirForma(x,y,lado_casilla);
    }

    public Forma getForma() {
        return forma;
    }


}
