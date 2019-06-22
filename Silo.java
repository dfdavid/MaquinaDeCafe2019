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
    public Silo(Ingrediente ingQueTendra, int capacidadASetear) throws Exception{
        
        //Validacion del primer argumento
        if (  capacidadASetear<=0 || capacidadASetear> CAPACIDAD_MAXIMA_DEFAULT){
            throw new IllegalArgumentException("cantidad negativa");            
        }
        
        //Validacion del segundo argumento
        int ingredienteValido=0;	
	for(Ingrediente ing: Ingrediente.values()) {
	    if( ing.equals(ingQueTendra)  )
		ingredienteValido++;
        }
		
	if (ingredienteValido>0) {
	    this.ingrediente=ingQueTendra;		        
	}
	else{
	    throw new IllegalArgumentException();	
	}
        
	this.ingrediente=ingQueTendra; // esto ya esta dentro del if de la linea 36
        this.capacidadMaxima=capacidadASetear;
        this.cantidadDisponible=0;
        
    }

    /**
     * constructor B: 1 parametro
     * Constructor for objects of class Silo 
     */
    public Silo(Ingrediente ingQueTendra)
    {
        //Validacion del  argumento  "ingQueTendra"
        int ingredienteValido=0;	
	for(Ingrediente ing: Ingrediente.values()) {
	    if( ing.equals(ingQueTendra)  )
		ingredienteValido++;
        }
		
	if (ingredienteValido>0) {
	    this.ingrediente=ingQueTendra;		        
	}
	else{
	    throw new IllegalArgumentException();	
	}
        
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