

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RecetaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecetaTest
{
    private MaquinaDeCafe maquinaD1;
    private Receta capu;

    /**
     * Default constructor for test class RecetaTest
     */
    public RecetaTest()
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
        capu = new Receta();
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
