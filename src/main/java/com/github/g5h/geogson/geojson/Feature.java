package com.github.g5h.geogson.geojson;

import com.github.g5h.geogson.geojson.geometry.Geometry;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Feature implements GeoJson {
    private Types.GeoJsonType type;
    private Geometry geometry;
}
