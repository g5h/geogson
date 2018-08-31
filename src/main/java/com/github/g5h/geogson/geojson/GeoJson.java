package com.github.g5h.geogson.geojson;

import com.google.gson.annotations.JsonAdapter;
import com.github.g5h.geogson.adapter.GeoJsonSerializerDeserializer;

@JsonAdapter(GeoJsonSerializerDeserializer.class)
public interface GeoJson {
    Types.GeoJsonType getType();
}
