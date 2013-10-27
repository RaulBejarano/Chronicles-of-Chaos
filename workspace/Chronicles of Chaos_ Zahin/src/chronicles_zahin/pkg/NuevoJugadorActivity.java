package chronicles_zahin.pkg;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class NuevoJugadorActivity extends Activity {

	Button btnContinuar, btnCancelar;
	RadioButton rbHombre, rbMujer;
	TextView txtNombre;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.nuevo_jugador);
		btnContinuar = (Button) findViewById(R.id.btnContinuarNJ);
		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		rbHombre = (RadioButton) findViewById(R.id.rbHombre);
		rbMujer = (RadioButton) findViewById(R.id.rbMujer);
		txtNombre = (TextView) findViewById(R.id.txtNombre);

		btnContinuar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				onContinuarClick();

			}

		});

		btnCancelar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				onCancelarClick();

			}

		});

	}

	protected void onCancelarClick() {
		this.finish();
	}

	protected void onContinuarClick() {
		if (!txtNombre.getText().toString().equals("")) {
			Intent intent = new Intent();
			intent.setComponent(new ComponentName(this, GameActivity.class));
			intent.putExtra("nuevo", true);
			if (rbHombre.isChecked()) {
				intent.putExtra("imagen", "img_m");
			} else {
				intent.putExtra("imagen", "img_w");
			}
			intent.putExtra("nombre", txtNombre.getText().toString());

			startActivity(intent);
			this.finish();
		}else{
			txtNombre.setBackgroundColor(Color.YELLOW);
		}
	}
}
