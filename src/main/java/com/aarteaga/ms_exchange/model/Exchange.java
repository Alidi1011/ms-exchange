package com.aarteaga.ms_exchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Exchange {
    private String result;
    private String provider;
    private String documentation;
    @JsonProperty("terms_of_use")
    private String termsOfUse;
    @JsonProperty("time_eol_unix")
    private Double timeEolUnix;
    private Object rates;
}
