package com.ymt.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymt.example.model.Content1JwtHeader;
import com.ymt.example.model.Content2JwtHeader;
import com.ymt.example.model.JwtHeader;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;

/**
 * @author yumingtao
 */
public class JwtUtils {

    public static void decodeJwt(String jwtToken) {
        System.out.println("------------ Decode JWT ------------");
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        Base64 base64Url = new Base64(true);
        System.out.println("------------ JWT Header ------------");
        System.out.println("JWT Base64 Encoded Header : " + base64EncodedHeader);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);

        System.out.println("------------ JWT Body ------------");
        System.out.println("JWT Base64 Encoded Body : " + base64EncodedBody);
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("JWT Body : " + body);

        System.out.println("------------ JWT Signature ------------");
        System.out.println("JWT Base64 Encoded Signature : " + base64EncodedSignature);

        System.out.println("------------ Decode JWT End------------");
    }

    @SneakyThrows
    public static Content1JwtHeader getContent1JwtHeader(String jwtToken){
        String header = decodeJwtHeader(jwtToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Content1JwtHeader content1JwtHeader = objectMapper.readValue(header, Content1JwtHeader.class);

        return content1JwtHeader;
    }

    @SneakyThrows
    public static Content2JwtHeader getContent2JwtHeader(String jwtToken){
        String header = decodeJwtHeader(jwtToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Content2JwtHeader content2JwtHeader = objectMapper.readValue(header, Content2JwtHeader.class);

        return content2JwtHeader;
    }

    @SneakyThrows
    public static JwtHeader getJwtHeader(String jwtToken){
        String header = decodeJwtHeader(jwtToken);
        ObjectMapper objectMapper = new ObjectMapper();
        JwtHeader jwtHeader = objectMapper.readValue(header, JwtHeader.class);

        return jwtHeader;
    }

    private static String decodeJwtHeader(String jwtToken) {
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);
        return header;
    }
}
