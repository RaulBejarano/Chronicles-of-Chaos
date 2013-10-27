package chronicles_zahin.pkg;

import java.util.ArrayList;

import android.graphics.Bitmap;

public class Mapa {
	
	private int id;
	private Bitmap imagen;
	private ArrayList <Obstaculo> obstaculo;
	private ArrayList<PDinamico> dinamico;
	private ArrayList<Nexo> nexo;
		
	public Mapa(int id, Bitmap imagen){
		this.setImagen(imagen);
		this.setId(id);
	}

	public Bitmap getImagen() {
		return imagen;
	}

	public void setImagen(Bitmap imagen) {
		this.imagen = imagen;
	}

	
	public int getWidth(){
		return imagen.getWidth();
	}
	
	public int getHeight(){
		return imagen.getHeight();
	}

	public ArrayList<PDinamico> getDinamico() {
		return dinamico;
	}

	public void setDinamico(ArrayList<PDinamico> dinamico) {
		this.dinamico = dinamico;
	}

	public ArrayList <Obstaculo> getObstaculo() {
		return obstaculo;
	}

	public void setObstaculo(ArrayList <Obstaculo> obstaculo) {
		this.obstaculo = obstaculo;
	}

	public ArrayList<Nexo> getNexo() {
		return nexo;
	}

	public void setNexo(ArrayList<Nexo> nexo) {
		this.nexo = nexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
