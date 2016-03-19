import java.util.*;

public class WeatherData implements Subject
{
    private ArrayList obss;
    private float temp;
    private float hum;
    private float pres;

    public WeatherData(){
        obss = new ArrayList();
    }
    public void registerO(Observer o){
        obss.add(o);
    }
    public void removeO(Observer o){
        int i = obss.indexOf(o);
        if(i >= 0){
            obss.remove(i);
        }
    }
    public void notifyO(){
        for(int i=0;i<obss.size();i++){
            Observer obs = (Observer)obss.get(i);
            obs.updata(temp, hum, pres);
        }
    }
    public void measurementsChanged(){
        notifyO();
    }
    public void setMeasurements(float temperature, float humidity, float pressure){
        temp = temperature;
        hum = humidity;
        pres = pressure;
        measurementsChanged();
    }
}
