package com.rererepeatbbs.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class VisitResponse {
    private String hospitalName;
    private String userName;
    private String disease;
    private float amount;
}
