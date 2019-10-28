package spring_boot.spring_boot.Gson.Serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.springframework.expression.ParseException;
import spring_boot.spring_boot.Gson.Entity.Actor;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Actor_GsonDeserializer extends JsonDeserializer<Actor> {


    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");


    public Actor deserialize(@NotNull JsonElement jsonElement, Type type, DeserializationContext deserializationContext) throws JsonParseException
    {

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement jsonImdbID = jsonObject.get("ImdbId");
        JsonElement jsonDateOfBirth =  jsonObject.get("dateOfBirth");
        JsonElement jsonFilmography = jsonObject.getAsJsonArray("filmography");

        List<String> filmList = new ArrayList<>();
        if(jsonFilmography != null)
        {
            for(int i = 0; i < jsonFilmography.getAsLong(); i++)
            {
                filmList.add(jsonFilmography.deepCopy().toString());
            }
        }

        Actor actor = null;
        try
        {
            actor = new Actor(jsonImdbID.getAsString(),sdf.parse(jsonDateOfBirth.getAsString()),filmList);
        }
        catch(ParseException | java.text.ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println("Type name: " +type.getTypeName());

        deserializationContext.constructCalendar(Date.from(Instant.now(Clock.systemUTC())));

        return actor;
    }


    @Override
    public Actor deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return null;
    }
}
