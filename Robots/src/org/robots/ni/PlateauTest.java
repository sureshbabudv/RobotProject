package org.robots.ni;


import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

/**
 * This class check for the input file in the current 
 * directory
 * @author Suresh
 *
 */
public class PlateauTest  {

	@Rule
	public ResourceFile resourceFile = new ResourceFile(Constants.FILE_NAME);
	
	
	   @Test
	    public void contentFileTest() throws Exception
	    {
	        	assertTrue(resourceFile.getContent().length() > 0);
		        assertTrue(resourceFile.getFile().exists());
	        }
	    	
 }
