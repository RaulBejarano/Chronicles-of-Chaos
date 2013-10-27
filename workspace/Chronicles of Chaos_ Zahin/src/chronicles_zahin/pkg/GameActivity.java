package chronicles_zahin.pkg;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {
	private int jugador;
	private GameView gameview;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Bundle bundle = getIntent().getExtras();

		SQLiteHelper sqlh = new SQLiteHelper(this, getResources());
		SQLiteDatabase db = sqlh.getWritableDatabase();

		if (bundle.getBoolean("nuevo")) {
			String imagen = bundle.getString("imagen");
			String nombre = bundle.getString("nombre");

			db.execSQL("INSERT INTO PESTATICO (imagen, nombre, mapa, posx, posy, vida, maxvida) "
					+ "VALUES ('"
					+ imagen
					+ "', '"
					+ nombre
					+ "', 1, 0, 432, 100, 100)");
			Cursor c = db.rawQuery("SELECT MAX(id) FROM PESTATICO", null);
			c.moveToFirst();
			jugador = c.getInt(0);
			c.close();
		} else {
			jugador = bundle.getInt("jugador");
		}
		
		// Inicializacion PEstatico
		Cursor c = db
				.rawQuery(
						"SELECT imagen, nombre, mapa, posx, posy, vida, maxvida FROM PESTATICO WHERE id="
								+ jugador, null);
		c.moveToFirst();

		Bitmap imagen = BitmapFactory.decodeResource(getResources(),
				codigoImg(c.getString(0)));
		PEstatico estatico = new PEstatico(jugador,null, imagen, c.getString(1),
				 c.getInt(3), c.getInt(4), c.getInt(5), c.getInt(6));

		// Inicializacion Mapa
		int idmapa = c.getInt(2);
		c.close();
		c = db.rawQuery("SELECT imagen FROM MAPA WHERE id=" + idmapa, null);
		c.moveToFirst();
		imagen = BitmapFactory.decodeResource(getResources(),
				codigoImg(c.getString(0)));
		Mapa mapa = new Mapa(idmapa, imagen);
		estatico.setMapa(mapa);
		// Inicializacion Obstaculos
		ArrayList<Obstaculo> obs = new ArrayList<Obstaculo>();
		c.close();
		c = db.rawQuery(
				"SELECT posx, posy, ancho, alto FROM OBSTACULO WHERE mapa="
						+ idmapa, null);
		if (c.moveToFirst()) {
			do {
				obs.add(new Obstaculo(c.getInt(0), c.getInt(1), c.getInt(2), c
						.getInt(3)));
			} while (c.moveToNext());
		}
		mapa.setObstaculo(obs);

		// Inicializacion PDinamico
		ArrayList<PDinamico> dinamico = new ArrayList<PDinamico>();
		c.close();
		c = db.rawQuery(
				"SELECT id, imagen, nombre, posx, posy, enemigo, vida FROM PDINAMICO WHERE mapa="+ idmapa, null);
		if (c.moveToFirst()) {
			do {
				imagen = BitmapFactory.decodeResource(getResources(),
						codigoImg(c.getString(1)));
				dinamico.add(new PDinamico(c.getInt(0), mapa, imagen, c.getString(2),	c.getInt(3), c.getInt(4), c.getInt(6),50, c.getInt(6)!=0,estatico));
			} while (c.moveToNext());
		}
		imagen = BitmapFactory.decodeResource(getResources(), R.drawable.img_e1);
		dinamico.add(new PDinamico(1, mapa, imagen, "e1", 48*6, 48*6, 50,50, true, estatico));
		dinamico.add(new PDinamico(2, mapa, imagen, "e2", 48*7, 48*16, 50,50, true, estatico));
		dinamico.add(new PDinamico(3, mapa, imagen, "e3", 48*8, 48*6, 50,50, true, estatico));
		dinamico.add(new PDinamico(4, mapa, imagen, "e4", 48*12, 48*12, 50,50, true, estatico));
		dinamico.add(new PDinamico(5, mapa, imagen, "e5", 48*5, 48*6, 50,50, true, estatico));
		
		mapa.setDinamico(dinamico);

		// Inicialización Nexos
		ArrayList<Nexo> nexo = new ArrayList<Nexo>();
		c.close();
		c = db.rawQuery("SELECT id, posx, posy, direccion ,enlace FROM NEXO WHERE mapa="
				+ idmapa, null);

		if (c.moveToFirst()) {
			do {
				nexo.add(new Nexo(c.getString(0), c.getInt(1), c.getInt(2), c.getInt(3), c.getString(4)));
			} while (c.moveToNext());
		}
		mapa.setNexo(nexo);

		gameview = new GameView(this, getWindowManager().getDefaultDisplay(), estatico, mapa);
		setContentView(gameview);

		c.close();
		db.close();
		sqlh.close();
	}

	private int codigoImg(String img) {
		return getResources().getIdentifier(img, "drawable",
				this.getPackageName());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 0, 0, "Personaje");
		menu.add(0, 1, 1, "Guardar");
		menu.add(0, 2, 2, "Guardar  y  Salir");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case 0:
			Intent intent = new Intent();
			intent.setComponent(new ComponentName(this, PersonajeActivity.class));
			startActivity(intent);
			break;
		case 1:
			guardar();
			break;
		case 2:
			guardar();
			finish();
		}
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	
	public void guardar() {
		SQLiteHelper sqlh = new SQLiteHelper(this, getResources());
		SQLiteDatabase db = sqlh.getWritableDatabase();
		PEstatico p = gameview.estatico;
		
		db.execSQL("UPDATE PESTATICO SET mapa="+gameview.getMapa().getId()+" , posx=" + p.getPosX() + ", posy="
				+ p.getPosY() + " WHERE id=" + jugador);
		
		db.close();
		sqlh.close();
	}

}