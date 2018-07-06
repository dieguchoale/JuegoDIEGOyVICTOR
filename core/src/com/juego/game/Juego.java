package com.juego.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Juego extends BaseScreen {
	Tablero tablero;
	SpriteBatch batch;
	Texture texturaCasilla, texturaBloque, texturaSuelo;
	public boolean presionado;
	Forma forma;
	float anchoPantalla, altoPantalla, lado_casilla, lado_casilla2, XtableroControl, YtableroControl, Xtablero, Ytablero, diferencia, posx, posy;
	ShapeRenderer shapeRenderer, shapeRenderer2;
	TableroControl tableroControl;
	Entrada entrada;
	ArrayList<Bloque> bloques;

	    private Stage stage;
		private World world;
		private Box2DDebugRenderer renderer;
		private OrthographicCamera camera;
		private Body suelo;
		private Fixture bloqueFixture, sueloFixture;

	public Juego(MainGame main) {
		super(main);
		texturaBloque=new Texture("casillaTablero.png");
		texturaSuelo= new Texture("suelo.png");
		presionado = true;
	}

	@Override
	public void show() {
		batch=new SpriteBatch();


		world=new World(new Vector2(0,8),true);
		renderer= new Box2DDebugRenderer();
		camera=new OrthographicCamera(0, 0);

		stage = new Stage();

		BodyDef sueloDef=creatBodyDefSuelo();
		suelo=world.createBody(sueloDef);

		PolygonShape sueloShape= new PolygonShape();
		sueloShape.setAsBox(3,.8f);
		sueloFixture=suelo.createFixture(sueloShape,1);
		sueloShape.dispose();

		anchoPantalla = Gdx.graphics.getWidth();
		altoPantalla = Gdx.graphics.getHeight();
		lado_casilla = anchoPantalla / 40;
		lado_casilla2 = anchoPantalla / 30;
		diferencia = lado_casilla - lado_casilla2;
		XtableroControl = anchoPantalla / 2 - lado_casilla2 * 5 / 2;
		YtableroControl = 30;
		Xtablero = anchoPantalla / 2 - lado_casilla * 5 / 2;
		Ytablero = (altoPantalla - 50) - (lado_casilla * 19);

		bloques = new ArrayList<Bloque>();
		tablero = new Tablero(anchoPantalla, altoPantalla, lado_casilla);
		forma = new Cuadrado();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer2 = new ShapeRenderer();
		tableroControl = new TableroControl(anchoPantalla, altoPantalla, lado_casilla2);
		tablero.crearCasillas(forma);
		tableroControl.crearTablero(forma);
		entrada = new Entrada(stage,world,XtableroControl, YtableroControl, lado_casilla2, tableroControl, tablero, forma, bloques,this);
		Gdx.input.setInputProcessor(entrada);
	}

	private BodyDef creatBodyDefSuelo() {
		BodyDef bodyDef=new BodyDef();
		bodyDef.position.set(0,15);
		return bodyDef;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tableroControl.pintarTableroControl(forma);

		batch.begin();
		batch.draw(texturaSuelo,anchoPantalla / 2 - lado_casilla * 5 / 2-18,altoPantalla-20, lado_casilla2*5.6f,lado_casilla2*3
		);
		batch.end();

		if (!presionado){
			world.step(delta,6,2);}
		camera.update();
		renderer.render(world,camera.combined);
		stage.draw();

		for (Bloque bloque : bloques) {
			float x = (bloque.getX() - 1) * lado_casilla2 + XtableroControl;
			float y = (bloque.getY() - 1) * lado_casilla2 + YtableroControl;
			int x1 = (int) x;
			int y1 = (int) y;

			for (Casilla casilla : tableroControl.getCasillas()) {
				int x2 = (int) casilla.getX();
				int y2 = (int) casilla.getY();
				if ((x1 == x2) && (y1 == y2)) {

					batch.begin();
					batch.draw(texturaBloque,casilla.getX(),casilla.getY(), lado_casilla2,lado_casilla2);
					batch.end();
				}
			}
		}


	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();
		shapeRenderer2.dispose();
		renderer.dispose();
		batch.dispose();
		world.destroyBody(suelo);
		stage.dispose();
		world.dispose();

	}
}
