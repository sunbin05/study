package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
	private static final String host = "localhost";
	private static final int port = 6379;
	public static Jedis jedis = null;

	public static void main(String[] args) {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(200);
		config.setMaxTotal(1024);
		config.setTestOnBorrow(true);
		config.setTestOnCreate(true);
		config.setTestOnReturn(true);
		
		JedisPool pool = new JedisPool(host, port);
		Jedis jedis = pool.getResource();
		jedis.set("brother", "sunxin05");
		
		String brother = jedis.get("brother");
		System.out.println(brother);
		
		pool.close();
	}
}
