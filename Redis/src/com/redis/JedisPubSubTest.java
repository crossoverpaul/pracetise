package com.redis;  
  
import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  
import redis.clients.jedis.JedisPoolConfig;  
  
  
public class JedisPubSubTest {  
  
 public static JedisPool pool;  
 static {  
	 
	 	JedisPoolConfig jedispool_config = new JedisPoolConfig();  
		 	//控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
				jedispool_config.setMaxTotal(500); 
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
				jedispool_config.setMaxIdle(5);
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
				jedispool_config.setMaxWaitMillis(1000 * 100); 
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
  			jedispool_config.setTestOnBorrow(true);

  			pool = new JedisPool(jedispool_config, "192.168.2.72", 6379);  
 }  
  
 public static void main(String[] args) throws InterruptedException {  
  Jedis redisClient1 = pool.getResource();  
  Jedis redisClient2 = pool.getResource();  
  MyListener listener = new MyListener();  
  
  Publisher pub = new Publisher();  
  pub.publish(redisClient2); //发布一个频道  

   
  
 Subscriber sub = new Subscriber();  
  sub.psub(redisClient1, listener);// 订阅一个频道  

 
 }  

}  

class Subscriber {  
	   
	 public void psub(final Jedis redisClient, final MyListener listener) {  
	    
	  
	  new Thread(new Runnable() {  
	   @Override  
	   public void run() {  
	  
		   System.out.println("订阅：news.share");  
		    // 订阅得到信息在lister的onMessage(...)方法中进行处理  
		  
		    // 订阅多个频道  
		    // redisClient.subscribe(listener, "news.share", "news.log");  
		  
		    //redisClient.subscribe(listener, new String[]{"news.share","news.log"});  
		      redisClient.psubscribe(listener, new String[] { "news.share" });// 使用模式匹配的方式设置频道    
	   }  
	  }).start();  
	  
	 }  
	  
	}  

class Publisher {  
	   
	 public void publish(final Jedis redisClient) {  
	    
	  new Thread(new Runnable() {  
			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("发布：news.share");
				redisClient.publish("news.share", "ok");
				redisClient.publish("news.share", "hello wordsss");
			}  
	  }).start();  
	  
	 }  
	  
	}  

