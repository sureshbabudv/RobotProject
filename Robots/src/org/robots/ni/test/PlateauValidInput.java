/**
 * 
 */
package org.robots.ni.test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.robots.ni.Constants;
import org.robots.ni.Coordinates;
import org.robots.ni.PositionsImpl;

/**
 * This test check for valid input from
 * file whether input contains all required parameters
 * 
 * @author Suresh
 *
 */
public class PlateauValidInput {

	/**
	 * @throws java.lang.Exception
	 */
	
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
		 assertTrue(positionsImpl.readOperations().equals(Constants.VAILD_INPUT));
    }
}
