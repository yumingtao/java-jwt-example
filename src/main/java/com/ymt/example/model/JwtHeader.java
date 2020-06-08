package com.ymt.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtHeader {
    private String alg;
    private String typ;
    private String enc;
    private String cty;
    private String kid;
    @JsonProperty("pi.atm")
    private String piAtm;
}
