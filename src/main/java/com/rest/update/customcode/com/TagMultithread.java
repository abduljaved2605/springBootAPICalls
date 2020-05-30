package com.rest.update.customcode.com;

import java.util.HashSet;


import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.read.write.api.GetPostApiRequest;

//@EnableCaching
//@Cacheable("addressCache")


public class TagMultithread {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
					com.read.write.api.GetPostApiRequest.class);
			GetPostApiRequest getPostApiRequest = context.getBean(GetPostApiRequest.class);
		
	
		public String tagMultithread(String tagParam,String sortBy, String direction) throws InterruptedException, ExecutionException
		{
			String[] tagParamArray = tagParam.split(",");
			
			ExecutorService executorService = Executors.newFixedThreadPool(tagParamArray.length);

			Set<Callable<String>> callables = new HashSet<Callable<String>>();

			//Calling API which returns the values for tag
			for (String tag : tagParamArray) {
				callables.add(new TestCallable(tag,sortBy,direction,getPostApiRequest));
			}


			List<Future<String>> futures = executorService.invokeAll(callables);
			StringBuffer stringBuffer = new StringBuffer();
			for(Future<String> future : futures){
			    System.out.println("future.get = " + future.get());
			    stringBuffer.append(future.get());
			}
			
			executorService.shutdown();
			return stringBuffer.toString();
			
		}


}
