package com.rest.update.customcode.com;

public class Validation {
	
	/*
	 * This validateTagParameter method checks for Tag parameter is empty or not
	 * if empty it returns false
	 */
	
	static public  boolean validateTagParameter(String tagParam)
	{
		boolean validation=false;
		
		if(!tagParam.isEmpty())
		{
			validation=true;
		}
		return validation;
		
	}
	
	/*
	 * This validateSortBy method checks for Sort parameter value
	 * 
	 */
	//String tagParam,String sortByParam,String direction
	static public  boolean validateSortBy(String sortByParam)
	{
		boolean validation=false;
		
		
		if(sortByParam.equals("id") ||sortByParam.equals("reads")||sortByParam.equals("likes")||sortByParam.equals("popularity") ||sortByParam.isEmpty())
		{
			validation=true;
		}
		
		return validation;
		
	}
	
	/*
	 * This validateDirection method checks for Direction parameter value
	 * 
	 */
	
	static public  boolean validateDirection(String direction)
	{
		boolean validation=false;
		
		
		if(direction.equals("asc") ||direction.equals("desc")||direction.isEmpty())
		{
			validation=true;
		}
		
		return validation;
		
	}


}
