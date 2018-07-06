package com.juego.game;

/**
 * Created by diego on 1/7/2018.
 */

import com.badlogic.gdx.Game;

public class MainGame extends Game {
    @Override
    public void create () {
        setScreen(new Juego(this));
    }
}

