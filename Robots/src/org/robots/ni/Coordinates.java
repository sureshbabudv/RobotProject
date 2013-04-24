/**
 * 
 */
package org.robots.ni;

/**
 * This class is the starting point after reading the input from
 * the file.It calls the main controller of the robot from which 
 * it gets the bounds and initial positions of the robot and 
 * finally it will give the destination position of the robot
 * 
 * @author Suresh
 *
 */
public class Coordinates {
	
	private Positions positions;
	private RobotController robotController;
	  
	 public Coordinates(Positions positions){
	  this.positions = positions;
	 }
	
	 /**
	  * This method get the bounds of the robot,
	  * set the initial position of the robot and
	  * also set the data for the destination position
	  * where robot need to move finally.   
	  * 
	  * @throws Exception
	  */
	 public void startRobot() throws Exception {
	  robotController = new RobotController(positions.getBounds());
	  robotController.setRobotPos(new Heading(positions.getInitialPos()));
	  robotController.setData(positions.getData());
	 }
	  
	 /**
	  * This method determines the final position
	  * of the robot where it is heading to as per
	  * the given instructions in the file.
	  * 
	  * @return Final position of the robot
	  */
	 public String getFinalPosition(){
	  Heading finalHeading = robotController.getRobotPos();
	  return finalHeading.toString();
	 }
	
}
