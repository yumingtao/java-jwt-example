package com.ymt.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yumingtao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content2JwtHeader {
    private String alg;
    private String typ;
    private String kid;
}
