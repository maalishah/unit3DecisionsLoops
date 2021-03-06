import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 20 rows and 20 columns
    private final int ROWS = 20;
    private final int COLS = 20;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();

        // create and add rocks (a type of Actor) to the three intial locations

        Rock rock1 = new Rock();
        Location loc1 = new Location(11, 8);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(10, 9);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(10, 10);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(11, 11);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(12, 9);
        grid.put(loc5, rock5);

        Rock rock6 = new Rock();
        Location loc6 = new Location(12, 10);
        grid.put(loc6, rock6);

        Rock rock7 = new Rock();
        Location loc7 = new Location(12, 11);
        grid.put(loc7, rock7);

    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();

        // insert magic here...

        ArrayList<Location> locations= new ArrayList<Location>();

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < COLS; col++)
            {
                Actor cell = getActor(row, col);
                Location location = new Location(row, col);
                ArrayList<Actor> neighbors = grid.getNeighbors(location);
                if (cell != null)
                {
                    if (neighbors.size() == 3 || neighbors.size() == 2)
                    {
                        locations.add(location);
                    }
                }   
                else
                {
                    if (neighbors.size() == 3)
                    {
                        locations.add(location);
                    }
                }
            }
        }

        for (int row = 0; row < ROWS; row++)
        {
            for (int col = 0; col < ROWS; col++)
            {
                Actor cell = getActor(row, col);
                Location location = new Location(row, col);
                if (cell != null)
                {
                    grid.remove(location);
                }
            }
        }

        for (int i = 0; i < locations.size(); i++)
        {
            Rock rock = new Rock();
            grid.put(locations.get(i),rock);
        }

        world.setGrid(grid);
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args) throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        
        for (int i = 0; i < 17; i++)
        {
            Thread.sleep(200);
            game.createNextGeneration();
        }
   }

}
