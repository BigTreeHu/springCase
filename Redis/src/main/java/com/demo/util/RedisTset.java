package com.demo.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTset {
	
	Jedis jedis = null;
	JedisPool jedispool = null;
	
	@Before
	public void init() {
		JedisPoolConfig config = new JedisPoolConfig();
		jedis = new Jedis();
		jedispool = new JedisPool(config, "127.0.0.1");
	}

	@Test
	public void test() {
		jedis=jedispool.getResource();
		System.out.println(jedis.get("ename"));
	}

}
