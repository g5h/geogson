package com.github.g5h.geogson.geojson.geometry;

import com.github.g5h.geogson.geojson.Types;
import com.github.g5h.geogson.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class MultiPointGeometry implements Geometry {
    private Types.GeometryType type;
    private List<Coordinate> coordinates;
}
