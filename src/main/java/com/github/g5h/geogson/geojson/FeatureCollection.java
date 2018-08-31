package com.github.g5h.geogson.geojson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class FeatureCollection implements GeoJson {
    Types.GeoJsonType type;
    List<Feature> features;
}