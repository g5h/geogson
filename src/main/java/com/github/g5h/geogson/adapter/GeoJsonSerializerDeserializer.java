package com.github.g5h.geogson.adapter;

import com.github.g5h.geogson.geojson.Feature;
import com.github.g5h.geogson.geojson.FeatureCollection;
import com.github.g5h.geogson.geojson.GeoJson;
import com.github.g5h.geogson.geojson.Types;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.github.g5h.geogson.geojson.geometry.Geometry;

import java.lang.reflect.Type;

public class GeoJsonSerializerDeserializer implements JsonSerializer<GeoJson>, JsonDeserializer<GeoJson> {
    @Override
    public GeoJson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Types.GeoJsonType<?> geoJsonType = Types.getTypeFromText(asJsonObject.get("type").getAsString());

        if (geoJsonType == null) {
            return null;
        } else if (Types.BaseType.FEATURE_COLLECTION.equals(geoJsonType)) {
            return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<FeatureCollection>() {
            }.getType());
        } else if (Types.BaseType.FEATURE.equals(geoJsonType)) {
            return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<Feature>() {
            }.getType());
        } else if (Types.GeometryType.class.equals(geoJsonType.getDeclaringClass())) {
            return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<Geometry>() {
            }.getType());
        } else {
            return null;
        }
    }

    @Override
    public JsonElement serialize(GeoJson geoJson, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
