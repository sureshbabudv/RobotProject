package org.robots.ni.test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.robots.ni.Coordinates;
import org.robots.ni.PositionsImpl;

  /**
   * This test will check for all invalid 
   * parameters from the input file.
   * @author Suresh
   *
   */
public class PlateauInvaildInput {

	private PositionsImpl positionsImpl;
	private Coordinates coordinates;
	
	@Before
	public void setUp() throws Exception {
		positionsImpl = new PositionsImpl();
		coordinates = new Coordinates(positionsImpl);
	}
	
	@Test
    public void readOperationsTest() throws Exception
    {
		 positionsImpl.readOperations();
		 assertTrue(positionsImpl.readOperations().equals("Invalid input"));
    }

}
