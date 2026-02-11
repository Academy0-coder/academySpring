package com.vlc2.academy.negozio.dto.invoice;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TimeSpan {

    Instant start;
    Instant end;

    public TimeSpan(Instant start, Instant end){
        this.start = start;
        this.end = end;
    }

}
