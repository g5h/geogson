package com.github.g5h.geogson;

import com.google.gson.annotations.JsonAdapter;
import com.github.g5h.geogson.adapter.CoordinateSerializerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonAdapter(CoordinateSerializerDeserializer.class)
public class Coordinate {
    private Double lon;
    private Double lat;
}
