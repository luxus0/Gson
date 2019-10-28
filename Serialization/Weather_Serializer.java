package spring_boot.spring_boot.Gson.Serialization;



import com.google.gson.*;
import elemental.json.Json;
import spring_boot.spring_boot.Gson.Entity.Weather;

import java.lang.reflect.Type;




public class Weather_Serializer implements JsonSerializer<Weather> {

    @Override
    public JsonElement serialize(Weather weather, Type type, JsonSerializationContext jsonSerializationContext) {
        weather = new Weather("USA", 30, "cloudy");
        JsonElement serialize = jsonSerializationContext.serialize(weather, type.getClass());
        JsonArray jsonArray = serialize.getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
        }


        return null;
    }

    public void JsonParse() {
        JsonParser jsonParser = new JsonParser();
        jsonParser.parse("{id : 4, weather : 7, Color : green}");

    }

    public void getJson() {
        Json json = new Json();
        Json.create("{Name : Lukasz }");

        String name = json.toString();
        System.out.println(name);
    }

}
