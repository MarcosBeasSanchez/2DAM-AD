package prueba;

import lombok.var;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	Alumno a1,a2,a3,a4;
    	Grupo g;

    	
    	
    	a1 = Alumno.builder().
    				dni("001").
    				nombre("a1").
    				edad(20).
    				build();
    	
    	a2 = Alumno.builder().
				dni("002").
				nombre("a2").
				build();
    	
    	
    	
    	//System.out.println(a1);
    	//System.out.println(a2);
    	
    	g = Grupo.builder().
    			nombre("g1").
    			//alumno(a1).
    			//alumno(a2).
    			build();
    	
    	System.out.println(g);
    	
    	a3 = new Alumno ("003");
    	
    	g.addAlumno(a3);
    	
    	System.out.println(g);
    
    }
    
}
