package com.juego.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.scenes.scene2d.Stage;


import java.util.ArrayList;

/**
 * Created by Ines on 23/06/2018.
 */

public class Entrada extends InputAdapter {
    float XtableroControl, YtableroControl, tamañoLado;
    Tablero tableroPrincipal;
    TableroControl tableroControl;
    Forma forma;
    boolean nuevaCasillaPresionada=false;
    ArrayList<Bloque> bloques;
    ArrayList<BloqueActor> pieza;
    Casilla casilla,anterior;
    Stage stage;
    World world;
    Juego juego;

    int color=1;

   private Texture bloqueTextura;
    private Texture bloque1 = new Texture("casillaVerde.png");
    private Texture bloque2 = new Texture("casillaRoja.png");
    private Texture bloque3 = new Texture("casillaAmarilla.png");
    private Texture bloque4 = new Texture("casillaRosada.png");
    private Texture bloque5 = new Texture("casillaAzul.png");


    public Entrada(Stage stage, World world, float XtableroControl, float YtableroControl, float ladoCasilla, TableroControl tableroControl, Tablero tableroPrincipal, Forma forma, ArrayList<Bloque> bloques,Juego juego) {
        this.XtableroControl = XtableroControl;
        this.YtableroControl = YtableroControl;
        this.tableroControl = tableroControl;
        this.tableroPrincipal = tableroPrincipal;
        this.forma = forma;
        this.bloques = bloques;
        this.stage = stage;
        this.world = world;
        this.juego=juego;
    }

    public void cambiarColor(int numero){

       if (numero==1) bloqueTextura = new Texture(bloque1.getTextureData());
       if (numero==2) bloqueTextura = new Texture(bloque2.getTextureData());
       if (numero==3) bloqueTextura = new Texture(bloque3.getTextureData());
       if (numero==4) bloqueTextura = new Texture(bloque4.getTextureData());
       if (numero==5) bloqueTextura = new Texture(bloque5.getTextureData());

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //pieza = new ArrayList<BloqueActor>();
        cambiarColor(color);
        juego.presionado=true;
        casilla = tableroControl.obtenerCasillaPulsada(screenX, screenY);
        if ((casilla != null)&& !(casilla.isOcupada())) {
            float x = (casilla.getEtiquetaX() - 1) * Constantes.lado_casilla + Constantes.Xtablero;
            float y = casilla.getEtiquetaY() * Constantes.lado_casilla + Constantes.lado_casilla2* 5; //TIENES QUE CAMBIAR ESTO  Y PONER LAS COORDENADAS PERO EN METROSSSSSSSS
            if (nuevaCasillaPresionada) {
                Forma formaBloque = new CuadradoBloque(bloqueTextura,stage, world, x, y, casilla.getLado_casilla());
               // BloqueActor bloque = new BloqueActor((int)x,(int)y,Constantes.lado_casilla,formaBloque);
             //   pieza.add(bloque);
                tableroControl.crearBloque(casilla.getEtiquetaX(), casilla.getEtiquetaY(), formaBloque, bloques);
                nuevaCasillaPresionada=false;
                casilla.setOcupada(true);
                anterior=casilla;
            }
            if (anterior!=casilla){ nuevaCasillaPresionada=true;}
        }
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (Casilla casilla : tableroControl.getCasillas()) {
            casilla.setBloque(null);
            casilla.setOcupada(false);
        }
        color++;
        if (color>5) color=1;
        cambiarColor(color);

     /*  for (BloqueActor forma:pieza){
            for(BloqueActor forma2:pieza){
                DistanceJointDef dDef = new DistanceJointDef();
                Bodies cuerpo = new Cuerpo();
                forma.getForma().joint(cuerpo);
                forma2.getForma().joint(cuerpo);
                dDef.bodyA = cuerpo.getBodies().get(0);
                dDef.bodyB = cuerpo.getBodies().get(1);
                dDef.dampingRatio=0;
                dDef.length=bloqueTextura.getWidth()/Constantes.Pixeles_en_metros;
                dDef.collideConnected=true;
                dDef.frequencyHz=1f;
                world.createJoint(dDef);
            }
        }

        pieza.clear();*/
        juego.presionado=false;
        bloques.clear();
        nuevaCasillaPresionada=true;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        juego.presionado=true;
        casilla = tableroControl.obtenerCasillaPulsada(screenX, screenY);
        if ((casilla != null)&& !(casilla.isOcupada())) {
            float x = (casilla.getEtiquetaX() - 1) * Constantes.lado_casilla + Constantes.Xtablero;
            float y = casilla.getEtiquetaY() * Constantes.lado_casilla + Constantes.lado_casilla2* 5; //TIENES QUE CAMBIAR ESTO  Y PONER LAS COORDENADAS PERO EN METROSSSSSSSS
            if (nuevaCasillaPresionada) {
                Forma formaBloque = new CuadradoBloque(bloqueTextura,stage, world, x, y, casilla.getLado_casilla());
               // BloqueActor bloque = new BloqueActor((int)x,(int)y,Constantes.lado_casilla,formaBloque);
                //pieza.add(bloque);
                tableroControl.crearBloque(casilla.getEtiquetaX(), casilla.getEtiquetaY(), formaBloque, bloques);
                nuevaCasillaPresionada=false;
                casilla.setOcupada(true);
                anterior=casilla;
            }
            if (anterior!=casilla){ nuevaCasillaPresionada=true;}
        }
        return false;
    }
}
