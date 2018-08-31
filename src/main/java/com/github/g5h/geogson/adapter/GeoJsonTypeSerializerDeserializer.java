package com.github.g5h.geogson.adapter;

import com.github.g5h.geogson.geojson.Types;
import com.google.gson.*;

import java.lang.reflect.Type;

public class GeoJsonTypeSerializerDeserializer implements JsonSerializer<Types.GeoJsonType<?>>, JsonDeserializer<Types.GeoJsonType<?>> {
    @Override
    public Types.GeoJsonType<?> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Types.getTypeFromText(jsonElement.getAsString());
    }

    @Override
    public JsonElement serialize(Types.GeoJsonType<?> geoJsonType, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(geoJsonType.getText());
    }
}
