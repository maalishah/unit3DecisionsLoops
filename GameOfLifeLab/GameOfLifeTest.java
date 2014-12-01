
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
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

    @Test
    public void testInitialState()
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
         *  0 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  1 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  2 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  3 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  4 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  5 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  6 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  7 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  8 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  9 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  10-  -  -  -  -  -  -  -  -  X  X  -  -  -  -  -  -  -  -  -  -
         *  11-  -  -  -  -  -  -  -  X  -  -  X  -  -  -  -  -  -  -  -  -
         *  12-  -  -  -  -  -  -  -  -  X  X  X  -  -  -  -  -  -  -  -  -
         *  13-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  14-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  15-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  16-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  17-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  18-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  19-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  20-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  
         */
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 11 && col == 8) ||
                        (row == 10 && col == 9) ||
                        (row == 10 && col == 10) ||
                        (row == 11 && col == 11) ||
                        (row == 12 && col == 9) ||
                        (row == 12 && col == 10) ||
                        (row == 12 && col == 11))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
    {
        /* verify that the actual pattern matches the expected pattern after 17 generations         *  
         */
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20
         *  0 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  1 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  2 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  3 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  4 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  5 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  6 -  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  -
         *  7 -  -  -  -  -  -  -  -  -  X  -  X  -  -  -  -  -  -  -  -  -
         *  8 -  -  -  -  -  -  -  -  -  X  -  X  -  -  -  -  -  -  -  -  -
         *  9 -  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  -
         *  10-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  11-  -  -  -  -  X  X  -  -  -  -  -  -  -  X  X  -  -  -  -  -
         *  12-  -  -  -  X  -  -  X  -  -  -  -  -  X  -  -  X  -  -  -  -
         *  13-  -  -  -  -  X  X  -  -  -  -  -  -  -  X  X  -  -  -  -  -
         *  14-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  15-  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  -
         *  16-  -  -  -  -  -  -  -  -  X  -  X  -  -  -  -  -  -  -  -  -
         *  17-  -  -  -  -  -  -  -  -  X  -  X  -  -  -  -  -  -  -  -  -
         *  18-  -  -  -  -  -  -  -  -  -  X  -  -  -  -  -  -  -  -  -  -
         *  19-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  20-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
         *  
         */
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        
        for (int i = 0; i < 17; i++)
        {
            game.createNextGeneration();
        }

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 6 && col == 10) ||
                        (row == 7 && col == 9) ||
                        (row == 8 && col == 9) ||
                        (row == 7 && col == 11) ||
                        (row == 8 && col == 11) ||
                        (row == 9 && col == 10) ||
                        (row == 12 && col == 4) ||
                        (row == 11 && col == 5) ||
                        (row == 11 && col == 6) ||
                        (row == 13 && col == 5) ||
                        (row == 13 && col == 6) ||
                        (row == 12 && col == 7) ||
                        (row == 12 && col == 13) ||
                        (row == 11 && col == 14) ||
                        (row == 11 && col == 15) ||
                        (row == 13 && col == 14) ||
                        (row == 13 && col == 15) ||
                        (row == 12 && col == 16) ||
                        (row == 15 && col == 10) ||
                        (row == 16 && col == 9) ||
                        (row == 17 && col == 9) ||
                        (row == 16 && col == 11) ||
                        (row == 17 && col == 11) ||
                        (row == 18 && col == 10))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
        
    }
}

