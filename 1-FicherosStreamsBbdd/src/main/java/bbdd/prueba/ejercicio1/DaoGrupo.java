package bbdd.prueba.ejercicio1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bbdd.prueba.ConexionBBDD;
import bbdd.prueba.DAOInterface;
import bbdd.prueba.Depart;

public class DaoGrupo implements DAOInterface<Grupo, String>{

	@Override
	public Optional<Grupo> findById(String key) {
		
		Optional<Grupo> optionalGrupo = Optional.empty();
		String sql = "SELECT * FROM departamento WHERE id = ?";
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, key);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.first()) {
				Grupo gruupo = Grupo.builder().
								nombre(key).
								nombre(rs.getString("nombre")).
								tutor(rs.getString("tutor")).
								curso(rs.getInt("curso")).
								//puede faltar la lista de alumnos
								build();
				
				optionalGrupo = Optional.of(gruupo);
			}
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return optionalGrupo;
	}

	@Override
	public Iterable<Grupo> findAll() {
		List <Grupo> lista = new ArrayList<>();
		String sql = "SELECT * FROM DEPART";
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Grupo grupo = Grupo.builder().
						nombre(rs.getString("nombre")).
						tutor(rs.getString("tutor")).
						curso(rs.getInt("curso")).
						//puede faltar la lista de alumnos
						build();
				lista.add(grupo);
			}
			ConexionBBDD.desconectar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public int delete(Grupo ov) {
		int cuantos = 0;
		String sql = "DELETE FROM DEPART WHERE DEPT_NO = ?"; //cambiar 
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNombre());
			
			cuantos = pst.executeUpdate();
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int save(Grupo ov) {
int cuantos = 0;
		
		String sql = "INSERT INTO DEPART (DEPT_NO, DNOMBRE,LOC) VALUES (?,?,?)";
		
		PreparedStatement pst;
		
		try {
			pst = ConexionBBDD.conectar().prepareStatement(sql);
			pst.setString(1, ov.getNombre());
			pst.setString(2, ov.getTutor());
			pst.setInt(3, ov.getCurso());
			
			cuantos = pst.executeUpdate();
			
			ConexionBBDD.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuantos;
	}

	@Override
	public int update(Grupo ov) {
		// TODO Auto-generated method stub
		return 0;
	}

}
