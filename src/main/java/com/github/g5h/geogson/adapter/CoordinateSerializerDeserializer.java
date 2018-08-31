package com.github.g5h.geogson.adapter;

import com.github.g5h.geogson.Coordinate;
import com.google.gson.*;

import java.lang.reflect.Type;

public class CoordinateSerializerDeserializer implements JsonSerializer<Coordinate>, JsonDeserializer<Coordinate> {
    @Override
    public JsonElement serialize(Coordinate coordinate, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray jsonElements = new JsonArray();
        jsonElements.add(coordinate.getLon());
        jsonElements.add(coordinate.getLat());
        return jsonElements;
    }

    @Override
    public Coordinate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        return new Coordinate(asJsonArray.get(0).getAsDouble(), asJsonArray.get(1).getAsDouble());
    }
}
