/**
 * 
 */
package org.robots.ni;

/**
 * This class contains all the operations
 * require to move the robot from current 
 * position. Parse and sets the data.
 * @author Suresh
 *
 */
public class Robot {
		
	RobotController parentControl;
	  
	 Heading currentHeading;
	  
	 public Robot(RobotController robotController){
	  this.parentControl = robotController;
	 }
	 
	 public Heading getCurrentHeading() {
	  return currentHeading;
	 }
	 
	 public void setCurrentHeading(Heading currentHeading) {
	  this.currentHeading = currentHeading;
	 }
	 
	 public void setData(String data) throws Exception{
	  parseData(data);
	 }
	 
	 private void parseData(String data) throws Exception{
	  byte[] bytes = data.trim().getBytes();
	  for(int i=0;i<bytes.length;i++){
	   currentHeading.parseCommand(bytes[i]);
	  }
	 }
}
