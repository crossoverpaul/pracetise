package com.guozz.spring_cache.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.base.Optional;
import com.guozz.spring_cache.domain.Account;

/**
 * @author guozhizhong
 * @version 2016-12-21 10:00:11
 */
public class AccountService3 {

	 private final Logger logger = LoggerFactory.getLogger(AccountService3.class);	
	 
	 
	 // 
	 /**
	  * <p>@Cacheable、@CachePut、@CacheEvict 注释介绍
	  * @Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
	  *	@CachePut 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用
	  *	-@CachEvict 主要针对方法配置，能够根据一定的条件对缓存进行清空</p>
	  * <p>
	  * <font color='red'>1.0</font>
	  * 使用了一个缓存名叫 accountCache</br>
	  * 这个注释的意思是，当调用这个方法的时候，会从一个名叫 accountCache 的缓存中查询，</br>
	  * 如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，否则返回缓存中的对象。</br>
	  * 这里的缓存中的 key 就是参数 accountName，value 就是 Account 对象。</br>
	  * “accountCache”缓存是在 spring*.xml 中定义的名称。我们还需要一个 spring 的配置文件来支持基于注释的缓存
	  * </p>
	  * <p>
	  *  <font color='red'>2.0如何按照条件操作缓存</font>
	  * 前面介绍的缓存方法，没有任何条件，即所有对 accountService 对象的 getAccountByName 方法的调用都会起动缓存效果，不管参数是什么值。
	  * 如果有一个需求，就是只有账号名称的长度小于等于 4 的情况下，才做缓存，大于 4 的不使用缓存
	  * 虽然这个需求比较坑爹，但是抛开需求的合理性，我们怎么实现这个功能呢？
	  * 通过查看CacheEvict注解的定义，我们会发现：
	  * 定义中有一个condition描述：
	  *	Spring Expression Language (SpEL) attribute used for conditioning the method caching.Default is “”, meaning the method is always cached.
	  *	我们可以利用这个方法来完成这个功能，下面只给出示例代码：
	  *	<blockquote><pre>
	  *	@Cacheable(value="accountCache",condition="#accountName.length() <= 4")// 缓存名叫 accountCache 
	  *	public Account getAccountByName(String accountName) {
	  *	    // 方法内部实现不考虑缓存逻辑，直接实现业务
	  *	    return getFromDB(accountName);
	  *	}
	  *</pre></blockquote>
	  *注意其中的 condition=”#accountName.length() <=4”，
	  *这里使用了 SpEL 表达式访问了参数 accountName 对象的 length() 方法，
	  *条件表达式返回一个布尔值，true/false，当条件为 true，则进行缓存操作，否则直接调用方法执行的返回结果。
	  * </p>
	  * 
	  * <p>
	  * <font color='red'>3.0如果有多个参数，如何进行 key 的组合</font>
      *	我们看看CacheEvict注解的key()方法的描述：
		
      *	Spring Expression Language (SpEL) attribute for computing the key dynamically. Default is “”, meaning all method parameters are considered as a key, unless a custom {@link #keyGenerator()} has been set.
      *	假设我们希望根据对象相关属性的组合来进行缓存，比如有这么一个场景：
      *	要求根据账号名、密码和是否发送日志查询账号信息
      *	很明显，这里我们需要根据账号名、密码对账号对象进行缓存，而第三个参数“是否发送日志”对缓存没有任何影响。所以，我们可以利用 SpEL 表达式对缓存 key 进行设计
      *	我们为Account类增加一个password 属性， 然后修改AccountService代码：
      *<blockquote><pre>
      *	@Cacheable(value="accountCache",key="#accountName.concat(#password)") 
      *	public Account getAccount(String accountName,String password,boolean sendLog) { 
      *	  // 方法内部实现不考虑缓存逻辑，直接实现业务
      *	  return getFromDB(accountName,password); 
      *	}
      *</pre></blockquote>
      *	注意上面的 key 属性，其中引用了方法的两个参数 accountName 和 password，而 sendLog 属性没有考虑，因为其对缓存没有影响。
      *<blockquote><pre>
      *	accountService.getAccount("accountName", "123456", true);// 查询数据库
      *	accountService.getAccount("accountName", "123456", true);// 走缓存
      *	accountService.getAccount("accountName", "123456", false);// 走缓存
      *	accountService.getAccount("accountName", "654321", true);// 查询数据库
      *	accountService.getAccount("accountName", "654321", true);// 走缓存
      *</pre></blockquote>
	  * </p>
	  * 
	  * <p>
	  *  <font color='red'>4.0如何做到：既要保证方法被调用，又希望结果被缓存</font></br>
	  *  根据前面的例子，我们知道，如果使用了 @Cacheable 注释，则当重复使用相同参数调用方法的时候，方法本身不会被调用执行，
	  *  即方法本身被略过了，取而代之的是方法的结果直接从缓存中找到并返回了。
	  *  现实中并不总是如此，有些情况下我们希望方法一定会被调用，因为其除了返回一个结果，还做了其他事情，
	  *  例如记录日志，调用接口等，这个时候，我们可以用 @CachePut 注释，这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中。
	  *  <blockquote><pre>
	  *  @Cacheable(value="accountCache")
	  *	 public Account getAccountByName(String accountName) { 
	  *	   // 方法内部实现不考虑缓存逻辑，直接实现业务
	  *	   return getFromDB(accountName); 
	  *	 } 
	  *		 
	  *	 // 更新 accountCache 缓存
	  *	 @CachePut(value="accountCache",key="#account.getName()")
	  *	 public Account updateAccount(Account account) { 
	  *	   return updateDB(account); 
	  *	 } 
	  *	 private Account updateDB(Account account) { 
	  *	   logger.info("real updating db..."+account.getName()); 
	  *	   return account; 
	  *	 }
	  *	</pre></blockquote>
	  *	我们的测试代码如下
	  *	<blockquote><pre>
	  *	Account account = accountService.getAccountByName("someone"); 
	  *	account.setPassword("123"); 
	  *	accountService.updateAccount(account); 
	  *	account.setPassword("321"); 
	  *	accountService.updateAccount(account); 
	  *	account = accountService.getAccountByName("someone"); 
	  *	logger.info(account.getPassword());
	  *		</pre></blockquote>
	  *	如上面的代码所示，我们首先用 getAccountByName 方法查询一个人 someone 的账号，这个时候会查询数据库一次，但是也记录到缓存中了。然后我们修改了密码，调用了 updateAccount 方法，这个时候会执行数据库的更新操作且记录到缓存，我们再次修改密码并调用 updateAccount 方法，然后通过 getAccountByName 方法查询，这个时候，由于缓存中已经有数据，所以不会查询数据库，而是直接返回最新的数据，所以打印的密码应该是“321”
	  * </p>
	  * @param accountName
	  * @return
	  */
	 @Cacheable(value="accountCache")
	 public Account getAccountByName(String accountName) {
	        // 方法内部实现不考虑缓存逻辑，直接实现业务
	        logger.info("real querying account... {}", accountName);
	        Optional<Account> accountOptional = getFromDB(accountName);
	        if (!accountOptional.isPresent()) {
	            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
	        }
	 
	        return accountOptional.get();
	    }
	 
	    private Optional<Account> getFromDB(String accountName) {
	        logger.info("real querying db... {}", accountName);
	        //Todo query data from database
	        return Optional.fromNullable(new Account(accountName));
	    }
	    
	    @CacheEvict(value="accountCache",key="#account.getName()")
	    public void updateAccount(Account account){
	    	updateDB(account);
	    }
	    
	    @CacheEvict(value="accountCache",allEntries=true)
	    public void reload() {
	    }
	    
	    private void updateDB(Account account) {
	        logger.info("real update db...{}", account.getName());
	    }
}
