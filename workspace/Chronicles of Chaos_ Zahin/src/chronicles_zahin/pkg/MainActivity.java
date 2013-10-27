package chronicles_zahin.pkg;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnContinuar, btnNuevaPartida, btnSalir;
	MediaPlayer m;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu);
		m = MediaPlayer.create(this,
				R.raw.xenyka_the_pendulum_of_humans_advancement);
		m.start();

		btnContinuar = (Button) findViewById(R.id.btncnt);
		btnNuevaPartida = (Button) findViewById(R.id.btnnueva);
		btnSalir = (Button) findViewById(R.id.btnslr);

		btnContinuar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onContinuarClick();
			}

		});

		btnNuevaPartida.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onNuevaPartidaClick();
			}

		});

		btnSalir.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.exit(0);
			}

		});

		SQLiteHelper sqlh = new SQLiteHelper(this, getResources());
		SQLiteDatabase db = sqlh.getReadableDatabase();
		Cursor c = db.rawQuery("SELECT COUNT(*) FROM PESTATICO", null);
		if (c.moveToFirst()) {
			if (c.getInt(0) == 0) {
				btnContinuar.setEnabled(false);
			}
		}
		c.close();
		db.close();
		sqlh.close();
	}

	private void onContinuarClick() {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this,
				PartidasGuardadasActivity.class));
		startActivity(intent);
	}

	private void onNuevaPartidaClick() {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, NuevoJugadorActivity.class));
		startActivity(intent);
	}

	protected void onDestroy() {
		finish();
		m.stop();
		super.onDestroy();
		
	}
}
