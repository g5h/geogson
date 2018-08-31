package com.github.g5h.geogson.geojson.geometry;

import com.github.g5h.geogson.Coordinate;
import com.github.g5h.geogson.geojson.Types;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PointGeometry implements Geometry {
    private Types.GeometryType type;
    private Coordinate coordinates;
}
