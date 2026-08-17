# Universal Converter - Lab 8

This Maven project demonstrates integration testing for a Universal Converter.
The completed report is included as `Lab8_Integration_TestCases.pdf`.

## Test design

- `TopDownIntegrationTest` checks the `ConversionController` with `StubConverterFactory`.
- `BottomUpIntegrationTest` checks real converter modules through `ConverterDriver`.
- `IntegrationSmokeRunner` provides a dependency-free smoke check for the main modules.

## Run

```powershell
mvn test
```
