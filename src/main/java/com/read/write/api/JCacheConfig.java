package com.read.write.api;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching

public class JCacheConfig  {
	
	public JCacheManagerCustomizer cacheCustomizer()
	{
		return new JCacheManagerCustomizer() {
			
			@Override
			public void customize(CacheManager cacheManager) {
				// TODO Auto-generated method stub
	
				MutableConfiguration<Object, Object> config = new MutableConfiguration<Object, Object>();
				config.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.TEN_MINUTES));
				config.setStatisticsEnabled(true);
				System.out.println("******INSIDE CACHE****");
				cacheManager.createCache("userCache", config);
				cacheManager.createCache("addressCache", config);
				
			}
		};
	}
	

}
