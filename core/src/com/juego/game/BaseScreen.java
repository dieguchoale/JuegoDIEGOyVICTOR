package com.juego.game;

/**
 * Created by diego on 1/7/2018.
 */

import com.badlogic.gdx.Screen;

public abstract class BaseScreen implements Screen {
    MainGame main;
    public BaseScreen(MainGame main){
        this.main=main;
    }
}