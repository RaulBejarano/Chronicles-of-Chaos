package chronicles_zahin.pkg;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;

public class LoadActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.load_dialog);
		
		Bundle bundle=getIntent().getExtras();
		
		int jugador=bundle.getInt("jugador");
		String enlace=bundle.getString("enlace");		
		
		SQLiteHelper sqlh = new SQLiteHelper(this, getResources());
		SQLiteDatabase db = sqlh.getWritableDatabase();
		
		Cursor c=db.rawQuery("SELECT mapa, posx, posy FROM NEXO WHERE id='"+enlace+"'", null);
		c.moveToFirst();
		db.execSQL("UPDATE PESTATICO SET mapa="+c.getInt(0)+" , posx="+c.getInt(1)+" , posy="+c.getInt(2)+" WHERE id="+jugador);
		
		c.close();
		db.close();
		sqlh.close();
		Intent intent=new Intent();
		intent.setComponent(new ComponentName(this, GameActivity.class));
		intent.putExtra("jugador", jugador);
		startActivity(intent);
		this.finish();
		
	}
}
