package com.example.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * 原生Jedis的包装类，包装了此实例的UUID，禁用了危险方法，集成了操作日志
 */
public class JedisTemplate extends Jedis {

    private final UUID id=UUID.randomUUID();

    Logger logger=LoggerFactory.getLogger(this.getClass());

    public JedisTemplate(String host, int port) {
        super(host, port);
    }

    /**
     * 忽略keys命令打印客户端请求痕迹并永远返回空集
     * @return 空集
     */
    @Override
    public Set<String> keys(String pattern) {
        logError("client "+id.toString()+" required an 'keys' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return new HashSet<>();
    }

    /**
     * 忽略configSet命令，打印客户端请求痕迹并返回空字符
     * @return ""
     */
    @Override
    public String configSet(String parameter, String value) {
        logError("client "+ id +" required an 'configSet' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }
    /**
     * 忽略configSet命令，打印客户端请求痕迹并返回空字符
     * @return empty byte
     */
    @Override
    public byte[] configSet(byte[] parameter, byte[] value) {
        logError("client "+ id +" required an 'configSet' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return " ".getBytes();
    }

    /**
     * 忽略clusterSaveConfig命令，打印客户端请求痕迹并返回空字符
     * @return ""
     */
    @Override
    public String clusterSaveConfig() {
        logError("client "+ id +" required an 'clusterSaveConfig' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }



    /**
     * 忽略configGet命令，打印客户端请求痕迹并返回空List
     * @return empty list
     */
    @Override
    public List<String> configGet(String pattern) {
        logError("client "+ id +" required an 'configGet' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return new ArrayList<>();
    }

    /**
     * 忽略configGet命令，打印客户端请求痕迹并返回空List
     * @return empty list
     */
    @Override
    public List<byte[]> configGet(byte[] pattern) {
        logError("client "+id+" required an 'configGet' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return new ArrayList<>();
    }

    /**
     * 禁止重置INFO命令统计,打印客户端请求痕迹并返回空字符
     * @return  ""
     */
    @Override
    public String configResetStat() {
        logError("client "+id.toString()+" required an 'configResetStat' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }



    /**
     * 禁止flushAll命令,打印客户端请求痕迹并返回空字符
     * @return ""
     */
    @Override
    public String flushAll() {
        logError("client "+id.toString()+" required an 'flushAll' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }


    /**
     * 禁止shutdown命令,打印客户端请求痕迹并返回空字符
     * @return ""
     */
    @Override
    public String shutdown() throws JedisException {
        logError("client "+id+" required an 'shutdown' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }



    /**
     * 禁止flushDB命令,打印客户端请求痕迹并返回空字符
     * @return this.flushAll()
     */
    @Override
    public String flushDB() {
        logError("client "+id.toString()+" required an 'flushDB' command at "
                + LocalDateTime.now().atZone(ZoneId.systemDefault()));
        return "";
    }



    private void logInfo(String logStr){
        logger.info(logStr);
    }

    private void logError(String logStr){
        logger.error(logStr);
    }
}
