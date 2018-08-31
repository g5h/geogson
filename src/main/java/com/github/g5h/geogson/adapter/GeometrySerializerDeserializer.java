package com.github.g5h.geogson.adapter;

import com.github.g5h.geogson.geojson.geometry.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.github.g5h.geogson.geojson.Types;

import java.lang.reflect.Type;

public class GeometrySerializerDeserializer implements JsonDeserializer<Geometry> {
    @Override
    public Geometry deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        Types.GeometryType geometryType = Types.getTypeFromText(asJsonObject.get("type").getAsString(), Types.GeometryType.class);

        if (geometryType == null) {
            return null;
        }

        switch (geometryType) {
            case POINT:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<PointGeometry>(){}.getType());
            case LINE:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<LineGeometry>(){}.getType());
            case POLYGON:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<PolygonGeometry>(){}.getType());
            case MULTI_POINT:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<MultiPointGeometry>(){}.getType());
            case MULTI_LINE:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<MultiLineGeometry>(){}.getType());
            case MULTI_POLYGON:
                return jsonDeserializationContext.deserialize(jsonElement, new TypeToken<MultiPolygonGeometry>(){}.getType());
        }
        return null;
    }
}
