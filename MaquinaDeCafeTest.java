

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
