package expectedResponsesService;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;


public class ExpectedResponseCurrentValuesService {

    public LinkedHashMap getExpectedCurrent() throws IOException {

        /*
         *        Реализую просто блок с какими-то данными для любого города,
         *        что бы по условию задания падали ошибки по данному блоку, в реальности нет смысла сравнивать тут значения,
         *        я бы проверяла просто что формат полей соответствет

         */

        String expectedResponse =
                "{\n" +
                        "        \"observation_time\": \"09:15 PM\",\n" +
                        "        \"temperature\": 5,\n" +
                        "        \"weather_code\": 116,\n" +
                        "        \"weather_icons\": [\n" +
                        "            \"https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0004_black_low_cloud.png\"\n" +
                        "        ],\n" +
                        "        \"weather_descriptions\": [\n" +
                        "            \"Partly cloudy\"\n" +
                        "        ],\n" +
                        "        \"wind_speed\": 24,\n" +
                        "        \"wind_degree\": 260,\n" +
                        "        \"wind_dir\": \"W\",\n" +
                        "        \"pressure\": 998,\n" +
                        "        \"precip\": 0,\n" +
                        "        \"humidity\": 75,\n" +
                        "        \"cloudcover\": 75,\n" +
                        "        \"feelslike\": 1,\n" +
                        "        \"uv_index\": 1,\n" +
                        "        \"visibility\": 10,\n" +
                        "        \"is_day\": \"no\"\n" +
                        "    }";
        return new ObjectMapper().readValue(expectedResponse, LinkedHashMap.class);


    }
}




