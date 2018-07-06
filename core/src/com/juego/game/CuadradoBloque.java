package com.juego.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by diego on 3/7/2018.
 */

public class CuadradoBloque  extends Actor implements Forma{
    Stage stage;
    World world;
    Body body;
    BodyDef bodyDef;
    Fixture fixture;
    FixtureDef fd;
    private Texture tx;

    public CuadradoBloque(Texture tx,Stage stage, World world, float x,float y, float lado){
        this.stage=stage;
        this.world=world;
        this.tx=tx;
        this.definirForma(x,y,lado);
    }

    @Override
    public void definirForma(float x, float y, float lado) {
        body=world.createBody(creatBodyDefBloque(x,y));
        PolygonShape bloqueShape= new PolygonShape();
        // CONVIERTE LOS PIXELES
        bloqueShape.setAsBox(lado/60,lado/60);
        fixture=body.createFixture(bloqueShape,1);
        stage.addActor(this);
    }

    @Override
    public void joint(Bodies bd) {
      bd.getBodies().add(body);
    }

    public BodyDef creatBodyDefBloque(float x, float y){
        BodyDef bodyDef=new BodyDef();
        bodyDef.position.set(x-3,y-6);
        bodyDef.type= BodyDef.BodyType.DynamicBody;
        return bodyDef;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
       batch.draw(tx,body.getPosition().x*16+Constantes.anchoPantalla/2+10 -Constantes.lado_casilla,body.getPosition().y*18+Constantes.altoPantalla/2-40,Constantes.lado_casilla,Constantes.lado_casilla);
    }
}
