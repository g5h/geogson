package com.github.g5h.geogson.geojson;

import com.google.gson.annotations.JsonAdapter;
import com.github.g5h.geogson.adapter.GeoJsonTypeSerializerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class Types {

    private interface TextEnum {
        String getText();
    }

    @JsonAdapter(GeoJsonTypeSerializerDeserializer.class)
    public interface GeoJsonType<T extends Enum<T>> extends TextEnum {
        Class<T> getDeclaringClass();
    }

    @AllArgsConstructor
    @Getter
    @JsonAdapter(GeoJsonTypeSerializerDeserializer.class)
    public enum BaseType implements GeoJsonType<BaseType> {
        FEATURE_COLLECTION("FeatureCollection"),
        FEATURE("Feature");

        private final String text;
    }

    @AllArgsConstructor
    @Getter
    @JsonAdapter(GeoJsonTypeSerializerDeserializer.class)
    public enum GeometryType implements GeoJsonType<GeometryType> {
        POINT("Point"),
        LINE("Line"),
        POLYGON("Polygon"),
        MULTI_POINT("MultiPoint"),
        MULTI_LINE("MultiLine"),
        MULTI_POLYGON("MultiPolygon");

        private final String text;
    }

    public static <G extends Enum<G> & TextEnum> G getTypeFromText(String text, Class<G> enumClass) {
        for (G enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getText().equals(text)) {
                return enumConstant;
            }
        }
        return null;
    }

    public static GeoJsonType getTypeFromText(String text) {
        return getTypeFromText(text, BaseType.class, GeometryType.class);
    }


    public static GeoJsonType getTypeFromText(String text, Class<? extends GeoJsonType>... geoJsonTypes) {
        for (Class<? extends GeoJsonType> gjtEnumClass : geoJsonTypes) {
            for (GeoJsonType gjtEnum : gjtEnumClass.getEnumConstants()) {
                if (gjtEnum.getText().equals(text)) {
                    return gjtEnum;
                }
            }
        }
        return null;
    }
}
