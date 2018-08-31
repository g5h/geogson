package com.github.g5h.geogson.geojson.geometry;

import com.github.g5h.geogson.Coordinate;
import com.github.g5h.geogson.geojson.Types;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class LineGeometry implements Geometry {
    private Types.GeometryType type;
    private List<Coordinate> coordinates;
}
