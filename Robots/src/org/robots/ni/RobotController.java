/**
 * 
 */
package org.robots.ni;

import java.util.StringTokenizer;

/**
 * This class is the controller of the robot which 
 * moves the robot position depending upon the input 
 * file
 * @author Suresh
 *
 */
public class RobotController {
	 	
	private Robot robot;
    public static int BOUNDS_X = 5;
    public static int BOUNDS_Y = 5;
	 
	 public RobotController(String bounds) throws Exception {
	  parse(bounds);
	  robot = new Robot(this);
	 }
	 
	 /**
	  * 
	  * @param bounds
	  * @throws Exception
	  */
	 
	 private void parse(String bounds) throws Exception {
	  StringTokenizer tokens = new StringTokenizer(bounds);
	  if (tokens.hasMoreTokens()) {
	  try {
	    BOUNDS_X = Integer.parseInt(tokens.nextToken());
	    BOUNDS_Y = Integer.parseInt(tokens.nextToken());
	   } catch (NumberFormatException e) {
	          throw new Exception("Invalid bounding values");
	   	 }
	  }
	 
	  if (BOUNDS_X <= 0 || BOUNDS_Y <= 0) {
		  throw new Exception("Bounding values should be greater than or equal to 1");
	  }
	 
	 }
	 
	 public void setRobotPos(Heading heading) {
	  robot.setCurrentHeading(heading);
	 }
	 
	 public Heading getRobotPos() {
	  return robot.getCurrentHeading();
	 }
	 
	 public void setData(String data) throws Exception
	 {
	   robot.setData(data);
	 }
}
