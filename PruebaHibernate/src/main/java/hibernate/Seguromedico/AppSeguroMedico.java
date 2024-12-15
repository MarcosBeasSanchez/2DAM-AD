package hibernate.Seguromedico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppSeguroMedico {
	
	public static void main(String[] args) {
		//onetomany
		List<Seguro>datos;
		datos = cargarDatos();
	}
	
	public static List<Seguro> cargarDatos() {
		// TODO Auto-generated method stub
		List<Seguro> seguros = new ArrayList<>();

		AsistenciaMedica a1,a2,a3,a4;
		Seguro s1,s2,s3;

		a1 = AsistenciaMedica.builder().
				breveDescripcion("a1").
				explicacion("la primera").
				fechaYHora(LocalDateTime.now()).
				importe(100).
				lugar("Maestranza").
				tipoAsistencia("normal").
				build();

		a2 = AsistenciaMedica.builder().
				breveDescripcion("a2").
				explicacion("la segunda").
				fechaYHora(LocalDateTime.now().minusDays(3)).
				importe(200).
				lugar("Maestranza").
				tipoAsistencia("urgente").
				build();

		a3 = AsistenciaMedica.builder().
				breveDescripcion("a3").
				explicacion("la tercera").
				fechaYHora(LocalDateTime.now().minusMonths(2)).
				importe(100).
				lugar("La Paz").
				tipoAsistencia("normal").
				build();

		a4 = AsistenciaMedica.builder().
				breveDescripcion("a4").
				explicacion("la cuarta").
				fechaYHora(LocalDateTime.now()).
				importe(130).
				lugar("Maestranza").
				tipoAsistencia("revision").
				build();


		s1 = Seguro.builder().
						ape1("Sutil").
						ape2("Martin").
						casado(false).
						coberturas(Coberturas.builder().
										dental(false).
										fecundacionInVitro(false).
										oftalmologia(true).
										build()).
						edad(45).
						embarazada(false).
						enfermedades(Enfermedades.builder().
										alergia(true).
										nombreAlergia("Al trabajo").
										build()).
						fechaCreacion(LocalDate.now().minusWeeks(45)).
						nif("001").
						nombre("Miguel").
						numHijos(2).
						sexo(Sexo.HOMBRE).
						asistencia(a1).
						asistencia(a2).
						build();


		s2 = Seguro.builder().
				ape1("Cordero").
				ape2("Gonzalez").
				casado(false).
				coberturas(Coberturas.builder().
								dental(true).
								fecundacionInVitro(false).
								oftalmologia(true).
								build()).
				edad(48).
				embarazada(false).
				enfermedades(Enfermedades.builder().
								alergia(true).
								nombreAlergia("renitis").
								estomacal(true).
								build()).
				fechaCreacion(LocalDate.now().minusWeeks(5)).
				nif("002").
				nombre("Rosa").
				numHijos(2).
				sexo(Sexo.MUJER).
				asistencia(a3).
				asistencia(a4).
				build();

		s3 = Seguro.builder().
				ape1("Sanchez").
				ape2("Gonzalez").
				casado(true).
				coberturas(Coberturas.builder().
								dental(true).
								fecundacionInVitro(false).
								oftalmologia(true).
								build()).
				edad(68).
				embarazada(false).
				enfermedades(Enfermedades.builder().
								alergia(true).
								nombreAlergia("polen olivo").
								estomacal(false).
								build()).
				fechaCreacion(LocalDate.now().minusWeeks(5)).
				nif("003").
				nombre("Juan").
				numHijos(3).
				sexo(Sexo.HOMBRE).
				build();

		seguros.add(s1);
		seguros.add(s2);
		seguros.add(s3);

		return seguros;
	}
	

}
