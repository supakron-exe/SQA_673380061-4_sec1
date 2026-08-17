package edu.kku.sqa.lab8;

public interface ConverterFactory {
    UnitConverter getConverter(Unit from, Unit to);
}
