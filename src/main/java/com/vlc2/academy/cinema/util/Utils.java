package com.vlc2.academy.cinema.util;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
@NoArgsConstructor
public class Utils {

    public Integer randomNumber(Integer min, Integer max){
        if(max<min){
            throw new RuntimeException("Max must be higher or equal than min");
        }

        return ((int) ((Math.random())*(max-min)))+min;
    }

    public Integer randomNumber(Integer range){
        if(range<1){
            throw new RuntimeException("Range must be 1 or higher");
        }

        return randomNumber(1,range);
    }

    public LocalDateTime randomTime(LocalTime begin, LocalTime end, Integer minutes, LocalDate firstDate, LocalDate lastDate){

        Long days = ChronoUnit.DAYS.between(firstDate,lastDate);
        Integer daysAdvance = randomNumber(0, days.intValue());
        LocalDate day = firstDate.plusDays(daysAdvance);

        Long mins = ChronoUnit.MINUTES.between(begin,end);
        Integer randomMinutes = randomNumber(0, mins.intValue()/minutes);
        LocalTime time = begin.plusMinutes(randomMinutes*minutes);

        return LocalDateTime.of(day,time);
    }

}
