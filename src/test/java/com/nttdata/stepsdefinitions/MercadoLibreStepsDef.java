package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MercadoLibreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MercadoLibreStepsDef {

    private WebDriver driver;
    private MercadoLibreSteps mercadoLibreSteps;

    @Dado("estoy en la página de MercadoLibre")
    public void estoy_en_la_pagina_de_mercadolibre() {
        driver = getDriver();
        mercadoLibreSteps = new MercadoLibreSteps(driver);
        mercadoLibreSteps.navigateToMercadoLibre();
        screenShot();
    }

    @Cuando("busco un producto {string}")
    public void busco_un_producto(String product) {
        mercadoLibreSteps.searchProduct(product);
        screenShot();
    }

    @Entonces("una lista de resultados")
    public void una_lista_de_resultados() {
        int resultsCount = mercadoLibreSteps.getResultsCount();
        Assertions.assertTrue(resultsCount > 0, "No se encontraron resultados en la búsqueda");
        screenShot();
    }

    @Y("valido el primer titulo del resultado sea {string}")
    public void valido_el_primer_titulo_del_resultado_sea(String expectedTitle) {
        String actualTitle = mercadoLibreSteps.getFirstResultTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "El título del primer resultado no coincide");
        screenShot();
    }
}
