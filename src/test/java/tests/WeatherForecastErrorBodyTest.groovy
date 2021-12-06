package tests

import constants.Constants
import service.WeatherTestService
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

@Title("Негативные тесты для получения ошибок по запросу GET прогноза погоды")

class WeatherForecastErrorBodyTest extends Specification {
    @Shared
    def weatherResponse;
    @Shared
    def usage_limit_reached = 104;
    @Shared
    def missing_query = 601;
    @Shared
    def request_failed = 615;
    @Shared
    def missing_access_key = 101;

    WeatherTestService weatherResponseService = new WeatherTestService();

    def "На GET запрос  погоды c параметрами #query, #city, #accessKey, #accessKeyValue - получаем ожидаемую ошибку #expecteErrorResponse из списка API Errors "() {


        given:
        weatherResponse = weatherResponseService.getWeatherResponseError(accessKey, accessKeyValue, query, city)

        expect:
        weatherResponse == expecteErrorResponse

        where:

        query   | city        | accessKey      | accessKeyValue                          || expecteErrorResponse
        "query" | "Moscow"    | "access_key"  | Constants.ACCESS_KEY_WITH_REACHED_LIMIT || usage_limit_reached
        "query" | ""          | "access_key"  | Constants.ACCESS_KEY                    || missing_query
        "query" | "qwerty123" | "access_key"  | Constants.ACCESS_KEY                    || request_failed
        "query" | "Abu Dabi"  | "access_key1" | Constants.ACCESS_KEY                    || missing_access_key


    }
}



