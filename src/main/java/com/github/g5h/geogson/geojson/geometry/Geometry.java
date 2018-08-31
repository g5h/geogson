package com.github.g5h.geogson.geojson.geometry;

import com.github.g5h.geogson.adapter.GeometrySerializerDeserializer;
import com.github.g5h.geogson.geojson.GeoJson;
import com.github.g5h.geogson.geojson.Types;
import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(GeometrySerializerDeserializer.class)
public interface Geometry extends GeoJson {
    @Override
    Types.GeometryType getType();
}
