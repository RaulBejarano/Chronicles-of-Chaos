package chronicles_zahin.pkg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	Resources res;
	public SQLiteHelper(Context context, Resources res) {		
		super(context, "game.bd", null,1);
		this.res=res;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			InputStream ins = res.openRawResource(R.raw.script);
			InputStreamReader isr=new InputStreamReader(ins);
			BufferedReader br=new BufferedReader(isr);
			String linea;
			while((linea=br.readLine())!=null){
				db.execSQL(linea);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);		
	}

}
