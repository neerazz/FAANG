package com.neeraj.tinyurl.model;

import lombok.Getter;

@Getter
public enum UsagePlan {
    PREMIUM(50),
    BASIC(10);

    int numberOfHitsPerDay;

    UsagePlan(int numberOfHitsPerDay) {
        this.numberOfHitsPerDay = numberOfHitsPerDay;
    }
}
