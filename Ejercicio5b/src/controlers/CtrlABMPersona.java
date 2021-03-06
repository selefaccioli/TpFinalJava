package controlers;

import java.util.ArrayList;

import conectionDB.DataPersona;
import entity.Persona;

public class CtrlABMPersona {
	private DataPersona dataPer;
	
	private ArrayList<Persona> pers;
	
	public CtrlABMPersona(){
		dataPer = new DataPersona();
		pers= new ArrayList<Persona>();
		pers.add(new Persona("12121212","Juan", "Perez",true));
		pers.add(new Persona("13131313","Fulano", "De Tal",true));
	}
	
	public void add(Persona p) throws Exception{
		//this.pers.add(p);
		dataPer.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		//this.pers.remove(this.getByDni(p));
		this.pers.remove(p);
	}
	
	public void update(Persona p)throws Exception{
		this.delete(p);
		this.add(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
		//return this.getByDni(p.getDni());
	}
	
	public Persona getByDni(String dni)throws Exception{
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
		/*for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getDni().equals(dni)) {
				return pers.get(i);
				
			}
		}
		return null; //ver error si falta
		*/
	}
	
	public Persona getByNombreApellido(Persona p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; //ver error si falta
		
	}
	
	public ArrayList<Persona> getAll()throws Exception{
		//return this.pers;
		return dataPer.getAll();
	}
}