package com.elcom.flux.responses;

import lombok.Data;

import java.util.List;
@Data
public class ChartResponse {
    private List<String> labels;
    private List<Long> values;
    private List<Long> values2;
}
