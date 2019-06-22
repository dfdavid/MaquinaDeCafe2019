
/**
 * Write a description of class Silo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Silo extends Recipiente //throws Exception
{
    // instance variables - replace the example below with your own
    //hereda:
        //static int CAPACIDAD_MAXIMA_DEFAULT = 2000;
    //int capacidadMaxima;
    //int cantidadDisponible;
    //campos definidos
    private Ingrediente ingrediente;

    /**
     * constructor A: 2 parametros
     * Constructor for objects of class Silo 
     */
    public Silo(Ingrediente ingQueTendra, int capacidadASetear) throws Exception
    {
        // initialise instance variables
        if ( capacidadASetear> CAPACIDAD_MAXIMA_DEFAULT){
            throw new CapacidadExcedidaException();            
        }
        
        //a esto no lo valida ningun test
        if (capacidadASetear<=0 ){
            throw new Exception();
        }
        
        //Ingrediente ingredientesValidos[] =Ingrediente.values();
        int ingredienteValido=0;	
	//verifico que el ingredite a poner sea valido
	for(Ingrediente ing: Ingrediente.values()) {
	    if( ing.equals(ingQueTendra)  )
		ingredienteValido++;
        }
		
	if (ingredienteValido>0) {
	    this.ingrediente=ingQueTendra;		        
	}
	else{
	    throw new Exception();	
	}
        
        
        this.ingrediente=ingQueTendra;
        this.capacidadMaxima=capacidadASetear;
        this.cantidadDisponible=0;
        
    }

    /**
     * constructor B: 1 parametro
     * Constructor for objects of class Silo 
     */
    public Silo(Ingrediente ingQueTendra)
    {
        // initialise instance variables
        this.ingrediente=ingQueTendra;
        this.capacidadMaxima=CAPACIDAD_MAXIMA_DEFAULT;
        this.cantidadDisponible=0;
    }
    
    /**
     * devuelve tipo de ingrediente almacenado
     * 
     * @param  void
     * @return Ingrediente 
     */
    public Ingrediente getTipoIngredienteAlmacenado()
    {
        // put your code here
        return this.ingrediente;
    }
}
