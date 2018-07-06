package com.juego.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by diego on 4/7/2018.
 */

public class Constantes {

    public final static float anchoPantalla=Gdx.graphics.getWidth();
    public final static float altoPantalla=Gdx.graphics.getHeight();
    public final static float lado_casilla=anchoPantalla/40;
    public final static float lado_casilla2=anchoPantalla/30;
    public final static float Xtablero = anchoPantalla / 2 - lado_casilla * 5 / 2;
    public final static float  Ytablero = (altoPantalla - 50) - (lado_casilla * 19);
    public final static float Pixeles_en_metros = 20f;
}
