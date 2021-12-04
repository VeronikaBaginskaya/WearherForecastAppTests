package expectedResponsesService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.spockframework.util.Assert;
import service.LocalDateTimeService;

import java.io.IOException;
import java.util.LinkedHashMap;


public class ExpectedResponseLocationValuesService {

    public LinkedHashMap getExpectedLocationByCity(String city) throws IOException {

        LocalDateTimeService localDateTimeService = new LocalDateTimeService();
        String localTime;
        long localEpoch;
        String expectedResponse;

        switch (city) {
            case "New York":
                localTime = localDateTimeService.getLocalDateTime("America", "New_York");
                localEpoch = localDateTimeService.getLocalEpoch("America", "New_York");
                expectedResponse =
                        "{\n" +
                                "        \"name\": \"New York\",\n" +
                                "        \"country\": \"United States of America\",\n" +
                                "        \"region\": \"New York\",\n" +
                                "        \"lat\": \"40.714\",\n" +
                                "        \"lon\": \"-74.006\",\n" +
                                "        \"timezone_id\": \"America/New_York\",\n" +
                                "        \"localtime\": \""+localTime+"\",\n" +
                                "        \"localtime_epoch\": "+localEpoch+",\n" +
                                "        \"utc_offset\": \"-5.0\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "Moscow":
                localTime = localDateTimeService.getLocalDateTime("Europe", "Moscow");
                localEpoch = localDateTimeService.getLocalEpoch("Europe", "Moscow");
                expectedResponse =
                        "{\n" +
                                "        \"name\": \"Moscow\",\n" +
                                "        \"country\": \"Russia\",\n" +
                                "        \"region\": \"Moscow City\",\n" +
                                "        \"lat\": \"55.752\",\n" +
                                "        \"lon\": \"37.616\",\n" +
                                "        \"timezone_id\": \"Europe/Moscow\",\n" +
                                "        \"localtime\": \""+localTime+"\",\n" +
                                "        \"localtime_epoch\": "+localEpoch+",\n" +
                                "        \"utc_offset\": \"3.0\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "Abu Dabi":
                localTime = localDateTimeService.getLocalDateTime("Asia", "Dubai");
                localEpoch = localDateTimeService.getLocalEpoch("Asia", "Dubai");

                expectedResponse =
                        "{\n" +
                                "        \"name\": \"Abu Dabi\",\n" +
                                "        \"country\": \"United Arab Emirates\",\n" +
                                "        \"region\": \"Abu Dhabi\",\n" +
                                "        \"lat\": \"24.467\",\n" +
                                "        \"lon\": \"54.367\",\n" +
                                "        \"timezone_id\": \"Asia/Dubai\",\n" +
                                "        \"localtime\": \""+localTime+"\",\n" +
                                "        \"localtime_epoch\": "+localEpoch+",\n" +
                                "        \"utc_offset\": \"4.0\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "London":
                localTime = localDateTimeService.getLocalDateTime("Europe", "London");
                localEpoch = localDateTimeService.getLocalEpoch("Europe", "London");

                expectedResponse =
                        "{\n" +
                                "        \"name\": \"London\",\n" +
                                "        \"country\": \"United Kingdom\",\n" +
                                "        \"region\": \"City of London, Greater London\",\n" +
                                "        \"lat\": \"51.517\",\n" +
                                "        \"lon\": \"-0.106\",\n" +
                                "        \"timezone_id\": \"Europe/London\",\n" +
                                "        \"localtime\": \""+localTime+"\",\n" +
                                "        \"localtime_epoch\": "+localEpoch+",\n" +
                                "        \"utc_offset\": \"0.0\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);



            default:
                Assert.fail("Не существует заданного ожидаемого значения для введенного города. " +
                        "Если он вам нужен - создйте под него набор ожидаемых данных в классе " + ExpectedResponseLocationValuesService.class);
                return new LinkedHashMap();

        }
    }
}




