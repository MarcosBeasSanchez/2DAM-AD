
package bbdd.prueba;

import java.util.List;
import java.util.Optional;

public interface DAOInterface <T,K> {
	// T representa el  clase objeto // K representa el clave
	
	public Optional<T> findById(K key); 
	//Recibe un valor y devuelve una optional de la clase del objeto(puede aparecer o no)
	
	public  Iterable<T> findAll();
	//recibe nada y devuelve un itrable(set,get)
	
	public int delete(T ov);
	//recibe un objeto y devuelve numero filas afectadas
	
	public int save(T ov);
	//recibe un objeto y devuelve numero filas afectadas
	
	public int update(T ov);
	//recibe un objeto y devuelve numero filas afectadas
}

