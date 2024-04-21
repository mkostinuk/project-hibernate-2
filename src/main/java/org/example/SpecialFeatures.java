package org.example;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private final String value;

    SpecialFeatures(String value) {
        this.value = value;
    }

    public static SpecialFeatures getFeature(String value) {
        if (value.isEmpty()) {
            return null;
        }

        for (SpecialFeatures specialFeatures : SpecialFeatures.values()) {
            if (Objects.equals(value, specialFeatures.value)) {
                return specialFeatures;
            }
        }
        return null;

    }

}
