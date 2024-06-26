package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Lokasi file fitur
        glue = "org.example", // Paket tempat definisi langkah-langkah berada
        plugin = {"pretty", "html:target/cucumber-reports"} // Opsi tambahan untuk laporan HTML
)
public class TestRunner {
    // Tidak perlu ada metode lain di sini, cukup kelas dengan anotasi di atas
}
