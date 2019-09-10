package com.rechuang.auth.authutil;


import com.rechuang.auth.utils.RsaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Author: nike
 * @Feature: jwt配置参数
 */

@Configuration
public class JwtProperties {

    /**
     * 密钥
     */

    private String secret="1";

    /**
     * 公钥地址
     */

    private String pubKeyPath="E:/miyao/pubKey.txt";

    /**
     * 私钥地址
     */

    private String priKeyPath="E:/miyao/priKey.txt";

    /**
     * token过期时间
     */
    private int expire=20;

    /**
     * 公钥
     */
    private PublicKey publicKey;

    /**
     * 私钥
     */
    private PrivateKey privateKey;

    /**
     * cookie名字
     */

    private String cookieName="rc_token";

    /**
     * cookie生命周期
     */

    private Integer cookieMaxAge=3;

    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPubKeyPath() {
        return pubKeyPath;
    }

    public void setPubKeyPath(String pubKeyPath) {
        this.pubKeyPath = pubKeyPath;
    }

    public String getPriKeyPath() {
        return priKeyPath;
    }

    public void setPriKeyPath(String priKeyPath) {
        this.priKeyPath = priKeyPath;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public Integer getCookieMaxAge() {
        return cookieMaxAge;
    }

    public void setCookieMaxAge(Integer cookieMaxAge) {
        this.cookieMaxAge = cookieMaxAge;
    }

    /**
     * @PostConstruct :在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        try {
            File pubKey = new File("E:/miyao/pubKey.txt");
            File priKey = new File("E:/miyao/priKey.txt");
            if (!pubKey.exists() || !priKey.exists()) {
                // 生成公钥和私钥
                RsaUtils.generateKey("E:/miyao/pubKey.txt","E:/miyao/priKey.txt", "12");
            }
//            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey("E:/miyao/pubkey.txt");
            this.privateKey = RsaUtils.getPrivateKey("E:/miyao/priKey.txt");
        } catch (Exception e) {
            logger.error("初始化公钥和私钥失败！", e);
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
