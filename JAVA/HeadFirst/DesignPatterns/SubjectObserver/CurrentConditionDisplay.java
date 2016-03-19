public class CurrentConditionDisplay implements Observer, DisplayElement
{
    private float temp;
    private float hum;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerO(this);
    }
    public void updata(float temperature, float humidity, float pressure){
        temp = temperature;
        hum = humidity;
        display();
    }
    public void display(){
    System.out.println("current condition: "+temp+"F degrees and "+hum+"% humidity");
    }
}
