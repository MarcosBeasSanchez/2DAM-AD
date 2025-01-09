package bbdd.prueba.ejercicio1;

import java.util.Optional;

import bbdd.prueba.DAOInterface;

public class DaoAlumno implements DAOInterface<Alumno, String>{

	@Override
	public Optional<Alumno> findById(String key) {
		
		return Optional.empty();
	}

	@Override
	public Iterable<Alumno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Alumno ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
