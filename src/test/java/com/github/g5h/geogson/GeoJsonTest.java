package com.github.g5h.geogson;

import com.github.g5h.geogson.geojson.GeoJson;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GeoJsonTest {

    private String polygonFeatureJson;

    @Before
    public void setup() throws IOException {
        polygonFeatureJson = readFile("polygon-feature.json");
    }

    @Test
    public void testCoordinateSerializerDeserializer() {
        Coordinate coordinate = new Gson().fromJson("[12.567, 13.567]", Coordinate.class);
        Assert.assertSame(13.567, coordinate.getLat());
        Assert.assertSame(12.567, coordinate.getLon());
    }


    @Test
    public void testGeometrySerializerDeserializer() {
        GeoJson geoJson = new Gson().fromJson(polygonFeatureJson, GeoJson.class);

        System.out.println(geoJson);
    }


    private String readFile(String filename) throws IOException {
        String filepath = getClass().getClassLoader().getResource(filename).getFile();
        return FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
    }
}
