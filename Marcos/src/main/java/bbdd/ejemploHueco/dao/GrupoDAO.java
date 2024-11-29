package bbdd.ejemploHueco.dao;

import java.util.Optional;

import bbdd.ejemploHueco.modelo.Grupo;

public class GrupoDAO implements DAOInterface<Grupo, String> {

	@Override
	public Optional<Grupo> findById(String key) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Iterable<Grupo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
