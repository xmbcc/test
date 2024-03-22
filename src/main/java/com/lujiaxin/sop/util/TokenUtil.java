package com.lujiaxin.sop.util;

import com.lujiaxin.sop.domain.ClientEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenUtil {

    /**
     * 根据 token 解析用户id
     * @param token
     * @return
     */
    public static Long getClientIdByToken(String token){
        Claims c = Jwts.parser().requireSubject("ljx3335").parseClaimsJws(token).getBody();
        Long clientId = (Long) c.get("clientId");
        return clientId;

    }

}
