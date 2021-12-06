package tests

import expectedResponsesService.ExpectedResponseCurrentValuesService
import expectedResponsesService.ExpectedResponseLocationValuesService
import expectedResponsesService.ExpectedResponseRequestValuesService
import service.WeatherTestService
import spock.lang.*

@Title("Позитивные тесты для получения прогноза погоды по городам")

class WeatherForecastStatusAndBodyTest extends Specification {
    @Shared
    def weatherRequestByCity;
    @Shared
    def weatherLocationByCity;
    @Shared
    def weatherCurrentByCity;
    @Shared
    def expectedLocationValuesByCity;
    @Shared
    def expectedCurrentValues;
    @Shared
    def expectedRequestValuesByCity;

    WeatherTestService weatherResponseService = new WeatherTestService();
    ExpectedResponseRequestValuesService expectedRequestValuesService = new ExpectedResponseRequestValuesService();
    ExpectedResponseLocationValuesService expectedLocationValuesService = new ExpectedResponseLocationValuesService();
    ExpectedResponseCurrentValuesService expectedCurrentValuesSService = new ExpectedResponseCurrentValuesService();


    def "Успешно возвращается прогноз погоды для города #city со статус кодом 200"() {

        expect:
        weatherResponseService.getWeatherURL(city).get().statusCode() == 200

        where:
        city << ["New York", "Moscow", "London", "Abu Dabi"]

    }
    def "На GET запрос  погоды - получаем ожидаемые значения keys-values для города #city"() {


        given:
        weatherRequestByCity = weatherResponseService.getRequestValuesByCity(city);
        weatherLocationByCity = weatherResponseService.geLocationValuesByCity(city);
        weatherCurrentByCity = weatherResponseService.getWeatherResponseCurrentByCity(city);

        and:
        expectedRequestValuesByCity = expectedRequestValuesService.getExpectedRequestByCity(city);
        expectedLocationValuesByCity = expectedLocationValuesService.getExpectedLocationByCity(city)
        expectedCurrentValues = expectedCurrentValuesSService.getExpectedCurrent();

        expect:
        verifyAll {
            weatherRequestByCity == expectedRequestValuesByCity
            weatherLocationByCity == expectedLocationValuesByCity
            weatherCurrentByCity == expectedCurrentValues
        }
        where:
        city << ["New York", "Moscow", "London", "Abu Dabi"]
    }
}



