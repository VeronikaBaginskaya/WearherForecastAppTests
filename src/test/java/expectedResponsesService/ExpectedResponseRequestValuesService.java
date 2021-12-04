package expectedResponsesService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.spockframework.util.Assert;

import java.io.IOException;
import java.util.LinkedHashMap;


public class ExpectedResponseRequestValuesService {

    public LinkedHashMap getExpectedRequestByCity(String city) throws IOException {

        String expectedResponse;

        switch (city) {
            case "New York":
                expectedResponse =
                        "{\n" +
                                "        \"type\": \"City\",\n" +
                                "        \"query\": \"New York, United States of America\",\n" +
                                "        \"language\": \"en\",\n" +
                                "        \"unit\": \"m\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "Moscow":
                expectedResponse =
                        "{\n" +
                                "    \"type\": \"City\",\n" +
                                "    \"query\": \"Moscow, Russia\",\n" +
                                "    \"language\": \"en\",\n" +
                                "    \"unit\": \"m\"\n" +
                                "}";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "Abu Dabi":
                expectedResponse =
                        "{\n" +
                                "        \"type\": \"City\",\n" +
                                "        \"query\": \"Abu Dabi, United Arab Emirates\",\n" +
                                "        \"language\": \"en\",\n" +
                                "        \"unit\": \"m\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);

            case "London":
                expectedResponse =
                        "{\n" +
                                "        \"type\": \"City\",\n" +
                                "        \"query\": \"London, United Kingdom\",\n" +
                                "        \"language\": \"en\",\n" +
                                "        \"unit\": \"m\"\n" +
                                "    }";
                return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);



            default:
                Assert.fail("Не существует заданного ожидаемого значения для введенного города. " +
                        "Если он вам нужен - создйте под него набор ожидаемых данных в классе " + ExpectedResponseRequestValuesService.class);
                return new LinkedHashMap();

        }
    }
}




