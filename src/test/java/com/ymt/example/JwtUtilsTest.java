package com.ymt.example;

import com.google.common.io.CharStreams;
import com.ymt.example.model.Content1JwtHeader;
import com.ymt.example.model.Content2JwtHeader;
import com.ymt.example.utils.JwtUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class JwtUtilsTest {
    public static final String FILE_PATH_JWT_TOKEN_CONTENT1 = "__files/JwtTokenContent1.txt";
    public static final String FILE_PATH_JWT_TOKEN_CONTENT2 = "__files/JwtTokenContent2.txt";
    public static final String HEADER_JWT_TOKEN_CONTENT1 = "CIAMSYM";
    public static final String HEADER_JWT_TOKEN_CONTENT2 = "pnre5eiCJg61ZpoEWHwORyHYh6Qiv5YvLNLyw_euhP4";
    private String jwtTokenContent1String;
    private String jwtTokenContent2String;

    @Before
    public void setUp() throws IOException {
        Reader reader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH_JWT_TOKEN_CONTENT1));
        jwtTokenContent1String = CharStreams.toString(reader);

        reader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(FILE_PATH_JWT_TOKEN_CONTENT2));
        jwtTokenContent2String = CharStreams.toString(reader);
    }

    @Test
    public void testDecodeJWT_JwtTokenContent1(){
        JwtUtils.decodeJwt(jwtTokenContent1String);
    }

    @Test
    public void testDecodeJWT_JwtTokenContent2(){
        JwtUtils.decodeJwt(jwtTokenContent2String);
    }

    @Test
    public void testGetContent1JwtHeader(){
        Content1JwtHeader content1JwtHeader = JwtUtils.getContent1JwtHeader(jwtTokenContent1String);
        Assert.assertEquals(HEADER_JWT_TOKEN_CONTENT1, content1JwtHeader.getKid());
    }

    @Test
    public void testGetContent2JwtHeader(){
        Content2JwtHeader content2JwtHeader = JwtUtils.getContent2JwtHeader(jwtTokenContent2String);
        Assert.assertEquals(HEADER_JWT_TOKEN_CONTENT2, content2JwtHeader.getKid());
    }
}
