package org.example;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year year) {
        return year == null ? null : (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short aShort) {
        return aShort == null ? null : Year.of(aShort);
    }
}
