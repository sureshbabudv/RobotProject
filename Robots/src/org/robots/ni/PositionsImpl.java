/**
 * 
 */
package org.robots.ni;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * This class read the operations from the file 
 * and set the initial position,bounds and also
 * set the data to which place robot need to move
 * and it also validates the input instructions from
 * the file. If the file does not have enough instructions
 * it will be return invalid instructions message.
 * 
 * @author Suresh
 *
 */
public class PositionsImpl implements Positions{
	
	private String bounds = "";
	private String data = "";
	private String initalPos = "";
	
	/**
	 *  This method read the instructions from the file and it
	 *  validates the input of the file.
	 * @return 
	 */
	@SuppressWarnings("resource")
	public String readOperations() {
	
	try {
		    URL url = this.getClass().getResource(Constants.FILE_NAME);
			FileInputStream fileInputStream = new FileInputStream(url.getFile());
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
			String instruction="";
			String result ="";
			while ((instruction = bufferedReader.readLine()) != null) {
				result += Constants.HASH_SYMBOL+instruction;
			}
			String[] operations = result.split(Constants.HASH_SYMBOL);
			if(operations.length > 3) {
			    bounds = operations[1];
				initalPos = operations[2];
				data = operations[3];
			   }else {
				   System.out.println("Invalid input");
				   return Constants.INVAILD_INPUT;
			   }
			} catch(FileNotFoundException e ) {
				 e.printStackTrace();
			   }catch(Exception e) {
				 e.printStackTrace();
			   }
		return Constants.VAILD_INPUT;
	 } 
	 
	 public String getBounds() {
	  return bounds;
	 }
	 
	 public String getData() {
	  return data;
	 }
	 
	 public String getInitialPos() {
	  return initalPos;
	 }

}
