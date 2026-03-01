package com.nttdata.page;

import org.openqa.selenium.By;

public class MercadoLibreSearchPage {

    //Localizadores de elementos para la página de resultados de búsqueda
    public static By resultsList = By.cssSelector("ol.ui-search-layout li.ui-search-layout__item");
    public static By firstResultTitle = By.xpath("(//h2[contains(@class, 'ui-search-item__title')])[1]");

}
