package com.juego.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

/**
 * Created by diego on 5/7/2018.
 */

public abstract class Bodies {

    private ArrayList<Body> bodies;

    public Bodies(){
        bodies= new ArrayList<Body>();
    }

    public ArrayList<Body> getBodies() {
        return bodies;
    }
}
