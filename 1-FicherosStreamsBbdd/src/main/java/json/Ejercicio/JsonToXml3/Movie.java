package json.Ejercicio.JsonToXml3;

import java.time.LocalDate;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import json.Ejemplo.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xml.Ejercicio.Cartelera.profe.Genero;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

public class Movie {
	
	private String title;
	
	private String year;
	
	@SerializedName(value="genres")
	/*private GeneroMovie genres;*/
	private List <Genres>genres;
	
	private List<Integer>ratings;
	
	private String duration;
	
	@JsonAdapter(LocalDateAdapter.class)
	private LocalDate releaseDate;
	
	private String originalTitle;
	
	private String storyline;
	
	private List<String>actors;
	
	@SerializedName(value="posterurl")
	private String posterUrl;
	
	
}
