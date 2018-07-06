package com.juego.game;

        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.Batch;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

        import javax.sound.sampled.Line;

/**
 * Created by Ines on 18/06/2018.
 */

public class Cuadrado implements Forma {
    SpriteBatch batch;
  Texture texturaCasilla=new Texture("casillaBlanca.png");
    public Cuadrado(){
        batch=new SpriteBatch();
    }
    @Override
    public void definirForma(float x,float y, float lado) {
        batch.begin();
        batch.draw(texturaCasilla,x,y, lado,lado);
        batch.end();
}

    @Override
    public void joint(Bodies bodies) {

    }

}
