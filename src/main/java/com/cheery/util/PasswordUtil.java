package com.cheery.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * desc: 密码加密解密工具类
 * Created by FanYanGen on 2019-05-22 11:58
 */
public class PasswordUtil {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    /**
     * desc: 数据加密
     *
     * @param password 待加密的密码
     * @auther FanYanGen
     * @date 2019-06-10 16:33
     */
    public static String encrypt(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    /**
     * desc: 数据解密
     *
     * @param password       待解密的密码
     * @param encodePassword 数据库中的密码
     * @auther FanYanGen
     * @date 2019-06-10 16:35
     */
    public static boolean decrypt(CharSequence password, String encodePassword) {
        return PASSWORD_ENCODER.matches(password, encodePassword);
    }

}
