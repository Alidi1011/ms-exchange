package com.aarteaga.ms_exchange.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rate {
    @JsonProperty("USD")
    private Double USD;
    @JsonProperty("PEN")
    private Double PEN;
    @JsonProperty("AFN")
    private Double AFN;
}
