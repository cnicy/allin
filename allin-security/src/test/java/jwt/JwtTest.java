package jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.ielee.allin.security.jwt.JwtSign;

public class JwtTest {
    public static void main(String[] args) {
        String tokenSecret = "ABC";
        String code = JwtSign.generateSessionToken("1",tokenSecret,"admin",1000);
        System.out.println(code);
        DecodedJWT decodedJWT = JwtSign.verifyToken(code,tokenSecret);
        System.out.println("res="+decodedJWT.getPayload());
    }
}