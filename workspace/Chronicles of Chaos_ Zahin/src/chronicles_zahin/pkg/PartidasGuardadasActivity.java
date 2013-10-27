package chronicles_zahin.pkg;

import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PartidasGuardadasActivity extends Activity {
	ArrayList<Integer> ids;
	ArrayList<String> array;
	ListView lista;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lista);
		lista=(ListView) findViewById(R.id.listaPartidasGuardadas);
		ids=new ArrayList<Integer>();
		array=new ArrayList<String>();
		
		SQLiteHelper sqlh = new SQLiteHelper(this, getResources());
		SQLiteDatabase db = sqlh.getWritableDatabase();
		
		Cursor c=db.rawQuery("SELECT id, nombre FROM PESTATICO", null);
		if(c.moveToFirst()){
			do{
				ids.add(c.getInt(0));
				array.add(c.getString(1));
			}while(c.moveToNext());
		}

		String [] mtr=new String[array.size()];
		for(int i=0;i<array.size();i++){
			mtr[i]=array.get(i);
		}
		c.close();
		db.close();
		sqlh.close();
		
		lista.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , mtr));
		lista.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				onItemSelected(arg2);
				
			}
			
		});
		lista.setOnItemLongClickListener(new OnItemLongClickListener(){

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				onLongItemSelected(arg2);
				return false;
			}
			
		});
	}
	
	public void onItemSelected(int seleccion){
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, GameActivity.class));
		intent.putExtra("jugador", ids.get(seleccion));
		startActivity(intent);
		this.finish();
	}
	
	public void onLongItemSelected(int seleccion){
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);  
		dialog.setTitle("Confirmar");  
		dialog.setMessage("¿Seguro que quiere borrar la partida?");  
		dialog.setIcon(android.R.drawable.ic_dialog_info);  
		  
		dialog.setCancelable(false);  
		dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {  
		    public void onClick(DialogInterface dialog, int id) {  
		        // Hacer Algo;  
		        dialog.cancel();  
		    }  
		});  
		dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {  
		    public void onClick(DialogInterface dialog, int id) {  
		        // Cancelar  
		        dialog.cancel();  
		    }  
		});  
		  
		dialog.show();  
	}
}
