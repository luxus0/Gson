package spring_boot.spring_boot.Gson.Serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import spring_boot.spring_boot.Gson.Entity.Actor;


import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Actor_GsonSerializer implements JsonSerializer<Actor> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


    @Override
    public JsonElement serialize(Actor actor, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject actorJsonObject = new JsonObject();
        actorJsonObject.addProperty("<strong> IMDB code</strong>", actor.getImdbId());
        actorJsonObject.addProperty("<strong>Day of Birth</strong>", sdf.format(actor.getDateOfBirth()));
        actorJsonObject.addProperty("<strong> no Film</strong>", FilmographyCovert(actor.getFilmography()));
        actorJsonObject.addProperty("<strong>Bestseller by id:</strong>",23);
        actorJsonObject.addProperty("DateFormat is lenient?",sdf.isLenient());

        return actorJsonObject;
    }

    private String FilmographyCovert(List<String> filmography)
    {
        return filmography.stream().filter(p -> p.startsWith("a")).collect(Collectors.joining());
    }

}


