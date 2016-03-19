public class WeatherStation
{
    public static void main(String[] args){
        WeatherData wData = new WeatherData();
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(wData);

        wData.setMeasurements(80,65,30.4f);
        wData.setMeasurements(82,70,29.2f);
        wData.setMeasurements(78,90,29.2f);
    }
}
