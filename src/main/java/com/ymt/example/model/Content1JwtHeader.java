package com.ymt.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yumingtao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content1JwtHeader {
    private String alg;
    private String enc;
    private String cty;
    private String kid;
    @JsonProperty("pi.atm")
    private String piAtm;
}
