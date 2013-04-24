package org.robots.ni.test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.robots.ni.Constants;
import org.robots.ni.Coordinates;
import org.robots.ni.PositionsImpl;

/**
 * This test class first check for valid input
 * from the file then it checks for actual functionality
 * 
 * @author Suresh
 *
 */
public class PlateauFunctional {

	private PositionsImpl positionsImpl;
	private Coordinates coordinates;
	
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	 
	
	@Before
	public void setUp() throws Exception {
		positionsImpl = new PositionsImpl();
		coordinates = new Coordinates(positionsImpl);
	}
	
	@Test
    public void readOperationsTest() throws Exception
    {
		try {
			positionsImpl.readOperations();
			assertTrue(positionsImpl.readOperations().equals(Constants.VAILD_INPUT));
		} catch(Throwable throwable) {
			errorCollector.addError(throwable);	
		}
	}
	
	@Test
    public void finalPositionTest() throws Exception
    {
		try{
			positionsImpl.readOperations();
			 coordinates.startRobot();
			 assertTrue(coordinates.getFinalPosition().equals("1 3 N"));
		} catch(Throwable throwable) {
			errorCollector.addError(throwable);	
		}
		
    }
	
}
