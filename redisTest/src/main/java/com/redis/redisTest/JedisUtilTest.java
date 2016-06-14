package com.redis.redisTest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisUtilTest
{
    private Jedis jedis;
    @Before
    public void setUp() throws Exception
    {
        jedis = new Jedis("127.0.0.1", 6379);
    }
    @Test
    public void testString()
    {
        jedis.set("name", "xujian");
        jedis.set("age", "23");
        String username = jedis.get("name");
        String age = jedis.get("age");
        System.out.println(username + ":" + age);
        jedis.del("name"); // 删除key对应的记录
        System.out.println(jedis.get("name")); // 执行结果为null
        jedis.incr("age"); // 进行加1操作
        System.out.println(jedis.get("age"));
    }
    @Test
    public void testMap()
    {
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "minxr");
        user.put("pwd", "password");
        jedis.hmset("user", user);
        // 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        // 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name");
        System.out.println(rsmap);
        // 删除map中的某个键值
        // jedis.hdel("user","pwd");
        System.out.println(jedis.hmget("user", "pwd")); // 因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数1
        System.out.println(jedis.exists("user"));// 是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));// 返回map对象中的所有key [pwd, name]
        System.out.println(jedis.hvals("user"));// 返回map对象中的所有value [minxr,
                                                // password]
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext())
        {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }
    @Test
    public void testList()
    {
        // 开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 先向key java framework中存放三条数据
        // lpush表示将元素插入到list的头部
        // rpush表示将元素插入到list的尾部
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));
    }
    @Test
    public void testSet()
    {
        // 添加
        jedis.sadd("sname", "minxr");
        jedis.sadd("sname", "jarorwar");
        jedis.sadd("sname", "tony");
        jedis.sadd("sanme", "noname");
        // 移除noname
        jedis.srem("sname", "noname");
        System.out.println(jedis.smembers("sname"));// 获取所有加入的value
        System.out.println(jedis.sismember("sname", "minxr"));// 判断 minxr是否为sname集合的元素
        System.out.println(jedis.srandmember("sname")); //从集合中随机返回一个元素
        System.out.println(jedis.scard("sname"));// 返回集合的元素个数
    }
    
    @Test
    public void testZset()
    {
        jedis.zadd("myzset", 878, "xujian");
        jedis.zadd("myzset", 123, "xiewei");
        jedis.zadd("myzset", 345, "luyang");
        jedis.zadd("myzset", 678, "xxy");
        
        System.out.println(jedis.zcard("myzset"));//元素个数
        Set<String> zset=jedis.zrange("myzset", 0, -1);
        
        for (Object object : zset)
        {
            System.out.println(object.toString());
        }
    }
}