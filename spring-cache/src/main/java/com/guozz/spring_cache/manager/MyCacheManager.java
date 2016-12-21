package com.guozz.spring_cache.manager;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

/**
 * <p>
 *  扩展性</br>
 *  直到现在，我们已经学会了如何使用开箱即用的 spring cache，这基本能够满足一般应用对缓存的需求。</br>
 *  但现实总是很复杂，当你的用户量上去或者性能跟不上，总需要进行扩展，这个时候你或许对其提供的内存缓存不满意了，</br>
 *  因为其不支持高可用性，也不具备持久化数据能力，这个时候，你就需要自定义你的缓存方案了。</br>
 *  还好，spring 也想到了这一点。我们先不考虑如何持久化缓存，毕竟这种第三方的实现方案很多。</br>
 *  我们要考虑的是，怎么利用 spring 提供的扩展点实现我们自己的缓存，且在不改原来已有代码的情况下进行扩展。</br>
 *  首先，我们需要提供一个 CacheManager 接口的实现，这个接口告诉 spring 有哪些 cache 实例，spring 会根据 cache 的名字查找 cache 的实例。
 *  另外还需要自己实现 Cache 接口，Cache 接口负责实际的缓存逻辑，例如增加键值对、存储、查询和清空等。</br>
 *  利用 Cache 接口，我们可以对接任何第三方的缓存系统，例如 EHCache、OSCache，甚至一些内存数据库例如 memcache 或者 redis 等。下面我举一个简单的例子说明如何做。
 * </p>
 * @author guozhizhong
 * @version 2016-12-21 11:07:57
 */
public class MyCacheManager extends AbstractCacheManager {
	
	 	private Collection<? extends MyCache> caches; 
	 
	   /** 
	   * Specify the collection of Cache instances to use for this CacheManager. 
	   */
	   public void setCaches(Collection<? extends MyCache> caches) { 
	     this.caches = caches; 
	   } 
	

	/* (non-Javadoc)
	 * @see org.springframework.cache.support.AbstractCacheManager#loadCaches()
	 */
	@Override
	protected Collection<? extends Cache> loadCaches() {
		// TODO Auto-generated method stub
		return null;
	}

}
