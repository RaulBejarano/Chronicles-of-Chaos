package chronicles_zahin.pkg;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {

	public PEstatico estatico;
	public Mapa mapa;
	public ArrayList<TempSprite> objTemporales;
	public ArmaSprite arma;
	int pulsaciones = 0;

	private final int controlesY = 160;
	public Bitmap pad;
	public Bitmap btnX;
	public Bitmap btnY;
	public Bitmap btnAst;
	public boolean isTouch = false;
	public int evtX;
	public int evtY;

	public GameLoopThread gameLoopThread;
	private SurfaceHolder holder;
	public Display display;
	private long lastMovement;
	private long lastButton;

	public GameView(Context context, Display display, PEstatico estatico,
			Mapa mapa) {
		super(context);
		this.display = display;
		gameLoopThread = new GameLoopThread(this);
		holder = getHolder();
		holder.addCallback(new SurfaceHolder.Callback() {
			public void surfaceDestroyed(SurfaceHolder holder) {
				boolean retry = true;
				gameLoopThread.setRunning(false);
				while (retry) {
					try {
						gameLoopThread.join();
						retry = false;
					} catch (InterruptedException e) {
					}
				}
			}

			public void surfaceCreated(SurfaceHolder holder) {
				if (gameLoopThread.getState() == Thread.State.TERMINATED) {
					gameLoopThread = crearGameLoop();
					gameLoopThread.setRunning(true);
					gameLoopThread.start();
				} else {
					gameLoopThread.setRunning(true);
					gameLoopThread.start();
				}
			}

			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
		});

		// Creación de los valores iniciales

		pad = BitmapFactory.decodeResource(getResources(), R.drawable.pad);
		btnX = BitmapFactory.decodeResource(getResources(), R.drawable.btnx);
		btnY = BitmapFactory.decodeResource(getResources(), R.drawable.btny);
		btnAst = BitmapFactory
				.decodeResource(getResources(), R.drawable.btnast);

		this.estatico = estatico;
		this.mapa = mapa;
		this.objTemporales = new ArrayList<TempSprite>();
		buttonManagement();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		Bitmap aux;

		// Posicion del personaje en la pantalla
		int posPersonajeX=display.getWidth() / 2 - estatico.getAncho()/ 2;;
		int posPersonajeY;
		
		if (display.getRotation() == Surface.ROTATION_0
				|| display.getRotation() == Surface.ROTATION_180) {
			posPersonajeY = display.getHeight() / 2 - estatico.getAlto()/ 2 - controlesY;
		} else {
			posPersonajeY = display.getHeight() / 2;
		} 

		// Posicion de la pantalla en el mapa
		int posPantallaMapaX = estatico.getPosX() - posPersonajeX;
		int posPantallaMapaY = estatico.getPosY() - posPersonajeY;
		// Pintar fondo
		canvas.drawARGB(255, 0, 0, 0);

		// Pintar mapa
		aux = mapa.getImagen();
		Rect src = new Rect(posPantallaMapaX, posPantallaMapaY,
				posPantallaMapaX + display.getWidth(), posPantallaMapaY
						+ display.getHeight());
		Rect dst = new Rect(0, 0, display.getWidth(), display.getHeight());
		canvas.drawBitmap(aux, src, dst, null);

		// Pintar objetos temporales
		TempSprite sprAux;
		for (int i = 0; i < objTemporales.size(); i++) {
			sprAux = objTemporales.get(i);
			try {
				canvas.drawBitmap(sprAux.getCurrentBitmap(), sprAux.getPosX(),
						sprAux.getPosY(), null);
			} catch (Exception e) {
				objTemporales.remove(i);
			}
		}
		
		//Pintar personaje dinamico
		PDinamico pdaux;
		for (int i=0;i<mapa.getDinamico().size();i++){
			pdaux=mapa.getDinamico().get(i);
			pdaux.update();
			if(pdaux.getPosX()>posPantallaMapaX && pdaux.getPosX()<posPantallaMapaX+display.getWidth()
					&& pdaux.getPosY()>posPantallaMapaY && pdaux.getPosY()<posPantallaMapaY+display.getHeight()){
				
				aux=pdaux.currentBitmap();
				dst = new Rect (pdaux.getPosX()-posPantallaMapaX,pdaux.getPosY()-posPantallaMapaY, pdaux.getPosX()-posPantallaMapaX+pdaux.getAncho(), pdaux.getPosY()-posPantallaMapaY+pdaux.getAlto());
				canvas.drawBitmap(aux, null, dst, null);
			
			}			
		}		
		
		// Pintar personaje estatico
		aux = estatico.currentBitmap();
	
		dst = new Rect(posPersonajeX, posPersonajeY,
				posPersonajeX + estatico.getAncho(), posPersonajeY+ estatico.getAlto());
			
		
		canvas.drawBitmap(aux, null, dst, null);

		// Pintar arma
		try {
			canvas.drawBitmap(arma.getCurrentBitmap(), arma.getPosX(),
					arma.getPosY(), null);
		} catch (Exception e) {
			arma = null;
		}

		// PINTAR CONTROLES
		dst = new Rect(0, display.getHeight() - pad.getHeight(),
				pad.getWidth(), display.getHeight());
		canvas.drawBitmap(pad, null, dst, null);

		// PINTAR BOTONES
		// Variables auxiliares botones
		int pos1btnx, pos1btny, pos2btnx, pos2btny;
		// Boton X
		pos1btnx = display.getWidth() - 30 - btnX.getWidth();
		pos2btnx = display.getWidth() - 30;

		pos1btny = display.getHeight() - pad.getHeight();
		pos2btny = pos1btny + btnX.getHeight();
		dst = new Rect(pos1btnx, pos1btny, pos2btnx, pos2btny);

		canvas.drawBitmap(btnX, null, dst, null);

		// Boton Y
		pos1btny = pos1btny + 20 + btnY.getHeight();
		pos2btny = pos1btny + btnY.getHeight();
		dst = new Rect(pos1btnx, pos1btny, pos2btnx, pos2btny);

		canvas.drawBitmap(btnY, null, dst, null);

		// Boton Asterisco
		pos1btny = display.getHeight() - pad.getHeight() - 20
				- btnAst.getHeight();
		pos2btny = display.getHeight() - pad.getHeight() - 20;

		dst = new Rect(pos1btnx, pos1btny, pos2btnx, pos2btny);
		canvas.drawBitmap(btnAst, null, dst, null);

	}

	public GameLoopThread crearGameLoop() {
		return new GameLoopThread(this);
	}

	public boolean onTouchEvent(MotionEvent event) {

		evtX = (int) event.getX();
		evtY = (int) event.getY();
		if (event.getAction() == MotionEvent.ACTION_DOWN
				|| event.getAction() == MotionEvent.ACTION_MOVE) {
			isTouch = true;
		} else {
			isTouch = false;
		}

		return true;
	}

	public void buttonManagement() {
		Thread t = new Thread() {

			public void run() {
				while (true) {
					while (isTouch) {
						synchronized (getHolder()) {
							int x = (int) evtX;
							int y = (int) evtY;

							// variables de posicion de un control.
							int posX;
							int posY;
							int width;
							int height;
							int blanco;

							if (System.currentTimeMillis() - lastMovement > 130) {
								lastMovement = System.currentTimeMillis();

								// pad up-left
								blanco = 23;
								posX = 0 + blanco;
								posY = display.getHeight() - pad.getHeight();
								width = (pad.getWidth() - posX) / 3;
								height = width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(1);
								}

								// pad up
								posX += width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(2);
								}

								// pad up-right
								posX += width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(3);
								}

								// pad left
								posX = 0 + blanco;
								posY = posY + height;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(4);
								}

								// pad right
								posX += 2 * width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(5);
								}

								// pad down-left
								posX = 0 + blanco;
								posY += height;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(6);

								}

								// pad down
								posX += width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(7);
								}

								// pad down-right
								posX += width;

								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									estatico.doMovement(8);
								}
								Nexo n = estatico.doNexo();
								if (n != null) {
									cargarMapa(n);
								}
							}
							if (System.currentTimeMillis() - lastButton > 50) {
								lastButton = System.currentTimeMillis();

								// Boton X

								posX = display.getWidth() - 30
										- btnX.getWidth();
								posY = display.getHeight() - pad.getHeight();
								width = btnX.getWidth();
								height = btnY.getWidth();
								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									doBotones(1);
								}

								// Boton Y

								posY = posY + 20 + btnY.getHeight();
								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									doBotones(2);
								}

								// Boton Asterisco

								posY = display.getHeight() - pad.getHeight()
										- 20 - btnAst.getHeight();
								if (x > posX && x < posX + width && y > posY
										&& y < posY + height) {
									doBotones(3);
								}
							}
						}

					}
					estatico.setParado();
				}

			}
		};

		t.start();
	}

	private void cargarMapa(Nexo n) {
		SQLiteHelper sqlh = new SQLiteHelper(this.getContext(), getResources());
		SQLiteDatabase db = sqlh.getWritableDatabase();

		Cursor c = db
				.rawQuery(
						"SELECT imagen, posx, posy, mapa FROM NEXO N, MAPA M WHERE N.mapa=M.id and N.id='"
								+ n.getEnlace() + "'", null);
		if (c.moveToFirst()) {
			mapa = new Mapa(c.getInt(3), BitmapFactory.decodeResource(
					getResources(), codigoImg(c.getString(0))));
			estatico.setPosX(c.getInt(1));
			estatico.setPosY(c.getInt(2));
			estatico.setMapa(mapa);
			int idmapa = mapa.getId();
			System.out.println(mapa.getId() + ":" + mapa.getWidth() + ","
					+ mapa.getHeight());
			// Inicializacion Obstaculos
			ArrayList<Obstaculo> obs = new ArrayList<Obstaculo>();
			c.close();
			c = db.rawQuery(
					"SELECT posx, posy, ancho, alto FROM OBSTACULO WHERE mapa="
							+ idmapa, null);
			if (c.moveToFirst()) {
				do {
					obs.add(new Obstaculo(c.getInt(0), c.getInt(1),
							c.getInt(2), c.getInt(3)));
				} while (c.moveToNext());
			}
			mapa.setObstaculo(obs);

			// Inicializacion Personaje Dinamico
			ArrayList<PDinamico> dinamico = new ArrayList<PDinamico>();
			c.close();
			c = db.rawQuery(
					"SELECT id, imagen, nombre, posx, posy, enemigo, vida FROM PDinamico WHERE mapa="
							+ idmapa, null);
			if (c.moveToFirst()) {
				Bitmap imagen;
				do {
					imagen = BitmapFactory.decodeResource(getResources(),
							codigoImg(c.getString(1)));
					dinamico.add(new PDinamico(c.getInt(0), mapa, imagen, c.getString(2),	c.getInt(3), c.getInt(4), c.getInt(6),50, c.getInt(6)!=0,estatico));
				} while (c.moveToNext());
			}
			mapa.setDinamico(dinamico);

			// Inicialización Nexos
			ArrayList<Nexo> nexo = new ArrayList<Nexo>();
			c.close();
			c = db.rawQuery(
					"SELECT id, posx, posy, direccion, enlace FROM NEXO WHERE mapa="
							+ idmapa, null);

			if (c.moveToFirst()) {
				do {
					nexo.add(new Nexo(c.getString(0), c.getInt(1), c.getInt(2),
							c.getInt(3), c.getString(4)));
				} while (c.moveToNext());
			}
			mapa.setNexo(nexo);

		}

		c.close();
		db.close();
		sqlh.close();
	}

	private int codigoImg(String img) {
		return getResources().getIdentifier(img, "drawable",
				this.getContext().getPackageName());
	}

	public void doBotones(int boton) {
		if (boton == 1) {
			// Boton X
			if (arma == null) {
				arma = new ArmaSprite(BitmapFactory.decodeResource(
						getResources(), R.drawable.espada), display, estatico,4);
			}
			estatico.setCurrentFrame(0);
		} else if (boton == 2) {
			// Boton Y
			arma = new ArmaSprite(BitmapFactory.decodeResource(getResources(),
					R.drawable.escudo), display, estatico, 3);
			estatico.setCurrentFrame(0);

		} else if (boton == 3) {

		}
	}

	public Mapa getMapa() {
		return mapa;
	}
}