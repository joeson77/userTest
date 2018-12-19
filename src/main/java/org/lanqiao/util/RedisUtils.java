package org.lanqiao.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
	
	public RedisUtils() {
	}
	
	private static JedisPool jedisPool = null;
	
	//获取连接
	public static synchronized Jedis getJedis(){
		if (jedisPool == null) {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			//指定连接池最大空闲连接数
			jedisPoolConfig.setMaxIdle(10);
			//连接池中创建的最大连接数
			jedisPoolConfig.setMaxTotal(100);
			//设置创建连接的超时时间
			jedisPoolConfig.setMaxWaitMillis(2000);
			//表示连接池在创建连接的时候会先测试一下连接是否可用，这样可以保证连接池中的连接都可以使用
			jedisPoolConfig.setTestOnBorrow(true);
			jedisPool = new JedisPool(jedisPoolConfig,"47.94.206.61",6379);
		}
		return jedisPool.getResource();
	}
	//返回连接
	public static void returnResources(Jedis jedis){
		jedisPool.returnResourceObject(jedis);
	}
}
