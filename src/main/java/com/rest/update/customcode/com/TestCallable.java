package com.rest.update.customcode.com;

import java.util.concurrent.Callable;

import com.read.write.api.GetPostApiRequest;

public class TestCallable  implements Callable<String> {
	String tag;
	String sortBy="id";
	String direction="asc";
	GetPostApiRequest getPostApiRequest;
	
	public TestCallable(String tag,String sortBy,String direction,GetPostApiRequest getPostApiRequest) {
	this.sortBy=sortBy;
	this.direction=direction;
	this.tag = tag;	
	this.getPostApiRequest =getPostApiRequest;
	}
	
	
	/*
	 * Method call will execute the api for various tags ,sort by and direction parameters
	 */
	
	@Override
	public String call() throws Exception {
		
		return "fetching resuts for tag "+tag+" "+ getPostApiRequest.getAPIResponseforQueryParams(tag,sortBy,direction);
	}
	

}
