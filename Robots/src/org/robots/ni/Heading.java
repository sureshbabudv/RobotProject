/**
 * 
 */
package org.robots.ni;

import java.util.StringTokenizer;

/**
 * This class do the actual operations of robot by
 * taking the directions and depending upon the input
 * it will move the robot
 * @author Suresh
 *
 */
public class Heading {
	
	private int x;
	private int y;
	private byte direction;
	  
	 public Heading(){
	   
	 }
	  
	 public Heading(String position) throws Exception {
	  parse(position);
	 }
	  
	  /**
	   * This method parse the positions of the robot 
	   *
	   * 
	   * @param position
	   * @throws Exception
	   */
	 private void parse(String position) throws Exception  {
	  
	  StringTokenizer tokens = new StringTokenizer(position);
	  if(tokens.hasMoreTokens()){
	    
	   try{
		   x = Integer.parseInt(tokens.nextToken());
		   y = Integer.parseInt(tokens.nextToken());
	   }catch(NumberFormatException ne){
	    throw new Exception("Invalid number!!");
	   }
	   direction = tokens.nextToken().getBytes()[0];
	  }
	  if(!verifyBounds()){
	   throw new Exception("Invalid inital position!!!");
	  }
	}
	 
	 /**
	  * This method parse the instruction and
	  * call the appropriate method
	  * @param command
	  * @throws Exception
	  */
	  
	 public void parseCommand(byte command) throws Exception {

	  switch(command){
	  case Constants.ROTATE_LEFT:
	   rotateLeft();
	   break;
	  case Constants.ROTATE_RIGHT:
	   rotateRight();
	   break;
	  case Constants.MOVE:
	   move();
	   break;
	  default:
	   throw new Exception("Invalid signal");
	  }
	 }
	 
	 /**
	  * Move the robot depending upon the direction
	  * by setting x and y co-ordinates
	  * @throws Exception
	  */
	 
	 private void move() throws Exception{
	  switch (direction) {
	  case Constants.DIRECTION_NORTH:
	   y += 1;
	   break;
	  case Constants.DIRECTION_EAST:
	   x += 1;
	   break;
	  case Constants.DIRECTION_SOUTH:
	   y -= 1;
	   break;
	  case Constants.DIRECTION_WEST:
	   x -= 1;
	   break;
	  }
	  if(!verifyBounds()){
	   throw new Exception("Rover exceeding range!!!");
	  }
	 }
	 
	 /**
	  * This method verify for valid bounderies
	  * @return
	  */
	 
	 private boolean verifyBounds() {
	  if((x>RobotController.BOUNDS_X || y>RobotController.BOUNDS_Y)
	    || x<0 || y<0){
	   return false;
	  }
	  return true;
	 }
	 
	 /**
	  * set the direction of the robot
	  */
	 
	 private void rotateRight() {
	  switch(direction){
	  case Constants.DIRECTION_NORTH:
	   direction = Constants.DIRECTION_EAST;
	   break;
	  case Constants.DIRECTION_EAST:
	   direction = Constants.DIRECTION_SOUTH;
	   break;
	  case Constants.DIRECTION_SOUTH:
	   direction = Constants.DIRECTION_WEST;
	   break;
	  case Constants.DIRECTION_WEST:
	   direction = Constants.DIRECTION_NORTH;
	   break;
	  }
	 }
	 
	 /**
	  * 
	  */
	 
	 private void rotateLeft() {
	  switch(direction){
	  case Constants.DIRECTION_NORTH:
	   direction = Constants.DIRECTION_WEST;
	   break;
	  case Constants.DIRECTION_WEST:
	   direction = Constants.DIRECTION_SOUTH;
	   break;
	  case Constants.DIRECTION_SOUTH:
	   direction = Constants.DIRECTION_EAST;
	   break;
	  case Constants.DIRECTION_EAST:
	   direction = Constants.DIRECTION_NORTH;
	   break;
	  }
	 }
	 
	 /**
	  * 
	  */
	 
	 public String toString(){
	  String toString = null;
	  toString = x+" "+y+" "+toChar(direction);
	  return toString;
	 }
	 
	 /**
	  * 
	  * @param direction
	  * @return
	  */
	 
	 private char toChar(byte direction) {
	  String s = String.valueOf(direction);
	  char c = (char)Integer.parseInt(s);
	  return c;
	 }
	 
	  
}
