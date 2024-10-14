package uso.opencsv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;


public class App 


{
    public static void main( String[] args ) throws IllegalStateException, FileNotFoundException
    {
    	List<Grupo> beans = new CsvToBeanBuilder(new FileReader("grupos.csv"))
                .withType(Grupo.class)
                .withSeparator(':')
                .build()
                .parse();

    	beans.forEach(System.out::println);
    }
}
