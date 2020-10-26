package com.ielee.allin.security.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于JWT的加密、解密算法工具类
 *
 * @author kissy
 */
public class JwtSign {
    public static final String CLAIM_USER_ID = "userId";
    public static final String CLAIM_USER_ROLE = "userRole";

    /**
     * 加密算法缓存，每个signingToken保存一份
     */
    private static Map<String, Algorithm> algorithmMap = new HashMap<>();
    /**
     * 解密算法缓存，每个signingToken保存一份
     */
    private static Map<String, JWTVerifier> verifierMap = new HashMap<>();

    /**
     * 生成JWT-Token
     *
     * @param userId        用户ID
     * @param signingSecret 用户加密密钥
     * @param userRole      用户角色
     * @param duration      过期时间
     * @return
     */
    public static String generateSessionToken(String userId, String signingSecret, String userRole, long duration) {
        if (null == signingSecret || "" == signingSecret) {
            // TODO
        }

        Algorithm algorithm = getAlgorithm(signingSecret);
        String token = JWT.create()
                .withClaim(CLAIM_USER_ID, userId)
                .withClaim(CLAIM_USER_ROLE, userRole)
                .withExpiresAt(new Date(System.currentTimeMillis() + duration))
                .sign(algorithm);
        return token;
    }

    /**
     * JWT校验算法（HMAC512）
     *
     * @param token         校验Token字符串
     * @param signingSecret 密钥
     * @return
     */
    public static DecodedJWT verifyToken(String token, String signingSecret) {
        JWTVerifier verifier = verifierMap.get(signingSecret);
        if (verifier == null) {
            synchronized (verifierMap) {
                verifier = verifierMap.get(signingSecret);
                if (verifier == null) {
                    Algorithm algorithm = Algorithm.HMAC512(signingSecret);
                    verifier = JWT.require(algorithm).build();
                    verifierMap.put(signingSecret, verifier);
                }
            }
        }

        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }

    /**
     * 获取基于HMAC512加密算法对象
     *
     * @param signingToken
     * @return
     */
    private static Algorithm getAlgorithm(String signingToken) {
        Algorithm algorithm = algorithmMap.get(signingToken);
        if (algorithm == null) {
            synchronized (algorithmMap) {
                algorithm = algorithmMap.get(signingToken);
                if (algorithm == null) {
                    algorithm = Algorithm.HMAC512(signingToken);
                    algorithmMap.put(signingToken, algorithm);
                }
            }
        }
        return algorithm;
    }
}
