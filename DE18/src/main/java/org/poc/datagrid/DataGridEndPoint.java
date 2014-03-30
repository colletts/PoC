package org.poc.datagrid;


import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// OK ClassDataAbstractionCoupling|ThrowsCountCheck {

/**
 * Endpoint to connect to a JBoss Data Grid via REST
 */
public class DataGridEndPoint {

    private String cacheUrl;

    private RestTemplate cacheRestTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(DataGridEndPoint.class);

    public static final String JBOSS_DATA_GRID_TIME_TO_LIVE_HTTP_HEADER = "timeToLiveSeconds";

    public void putInCache(String cacheName, String key, String timeToLive, Serializable serializableObject) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set(JBOSS_DATA_GRID_TIME_TO_LIVE_HTTP_HEADER, timeToLive);
            cacheRestTemplate.put(getCacheURL(cacheName, key), encode(serializableObject));
        } catch (Exception e) {
            LOG.warn("Cannot cache object with key " + key + " in cache " + cacheName + " with time to live of " + timeToLive
                    + " object will not be cached", e);
        }
    }

    public Object getFromCache(String cacheName, String key) throws Exception{
        try {
            String value = cacheRestTemplate.getForObject(getCacheURL(cacheName, key), String.class);
            return decode(value);
        } catch (Exception e){
            LOG.info("Cannot find object with key " + key + " in cache " + cacheName + " exception " + e);
            throw new Exception("Object not found in cache");
        }
    }

    public void removeFromCache(String cacheName, String key){
        try {
            cacheRestTemplate.delete(getCacheURL(cacheName, key));
        } catch (Exception e){
            LOG.info("Cannot remove object with key " + key + " in cache " + cacheName + " exception " + e);
        }
    }

    public void removeCache(String cacheName){
        try {
            cacheRestTemplate.delete(getCacheURL(cacheName));
        } catch (Exception e){
            LOG.info("Cannot remove cache " + cacheName + " exception " + e);
        }
    }

    /** Read the object from Base64 string. */
    public Object decode(String s) throws IOException, ClassNotFoundException {
        byte[] data = Base64.decodeBase64(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    public String encode(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();
        return new String(Base64.encodeBase64(baos.toByteArray()));
    }

    private String getCacheURL(String cacheName, Object key) {
        StringBuilder url = new StringBuilder();
        url.append(cacheUrl);
        url.append("/");
        url.append(cacheName);
        url.append("/");
        url.append(key);
        return url.toString();
    }

    private String getCacheURL(String cacheName) {
        StringBuilder url = new StringBuilder();
        url.append(cacheUrl);
        url.append("/");
        url.append(cacheName);
        url.append("/");
        return url.toString();
    }

    public String getCacheUrl() {
        return cacheUrl;
    }

    public void setCacheUrl(String cacheUrl) {
        this.cacheUrl = cacheUrl;
    }

    public RestTemplate getCacheRestTemplate() {
        return cacheRestTemplate;
    }

    public void setCacheRestTemplate(RestTemplate cacheRestTemplate) {
        this.cacheRestTemplate = cacheRestTemplate;
    }

    //}
}
