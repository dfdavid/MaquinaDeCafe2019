

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MaquinaDeCafeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MaquinaDeCafeTest
{
    private MaquinaDeCafe maquinaD1;
    private Silo silo1agua;
    private Silo silo1cafe;
    private Receta capu;

    
    
    
    

    
    
    
    

    /**
     * Default constructor for test class MaquinaDeCafeTest
     */
    public MaquinaDeCafeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        maquinaD1 = new MaquinaDeCafe();
        silo1agua = new Silo(Ingrediente.AGUA);
        silo1cafe = new Silo(Ingrediente.CAFE);
        try{
            silo1agua.agregar(1500);
            silo1cafe.agregar(200);
        }
        catch (Exception e){
            System.out.println("fallo al agregar algun ingrediente en algun recip.");
        }
        maquinaD1.addRecipiente(silo1cafe);
        maquinaD1.addRecipiente(silo1agua);
        capu = new Receta();
        capu.agregarIngrediente(Ingrediente.CAFE, 40);
        capu.agregarIngrediente(Ingrediente.LECHE, 40);
        capu.agregarIngrediente(Ingrediente.CACAO, 20);
        capu.agregarIngrediente(Ingrediente.AGUA, 100);
        capu.agregarIngrediente(Ingrediente.AZUCAR, 3);
        maquinaD1.getEstado();
        maquinaD1.encender();
        try{
        maquinaD1.setSeleccion(Producto.EXPRESO);
        }
        catch(Exception e){
            //nada
        }
        
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
