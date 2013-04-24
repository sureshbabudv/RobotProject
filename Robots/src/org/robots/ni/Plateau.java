/**
 * 
 */
package org.robots.ni;

/**
 * This class reads instructions from a file and process
 * the instructions. Depending upon instructions file 
 * will return final position of robot
 * 
 * @author Suresh
 *
 */
public class Plateau {

	public static void main(String[] args) {
		
		try {
			 PositionsImpl positionsImpl = new PositionsImpl();
			 positionsImpl.readOperations();
			 Coordinates coordinates = new Coordinates(positionsImpl);
			 coordinates.startRobot();
			 String finalPos = coordinates.getFinalPosition();
			 System.out.println("Final position is : " + finalPos);
		 } catch (Exception e) {
			   e.printStackTrace();
			}
	}

}
