package spring_boot.spring_boot.Gson.Entity;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName(value = "location", alternate = "place")
    private String location;

    @SerializedName(value = "temp", alternate = "temperature")
    private int temp;

    @SerializedName(value = "outlook", alternate = "weather")
    private String outlook;

    public Weather(String location, int temp, String outlook) {
        this.location = location;
        this.temp = temp;
        this.outlook = outlook;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }
}