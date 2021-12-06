package service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeService {

    public String getLocalDateTime(String country, String city) {
        String instant = ZonedDateTime.now(ZoneId.of(country + "/" + city)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return instant;

    }

    public long getLocalEpoch(String country, String city) {
        long instant = ZonedDateTime.now(ZoneId.of(country + "/" + city)).toInstant().toEpochMilli() / 1000;
        return instant;


    }


}
