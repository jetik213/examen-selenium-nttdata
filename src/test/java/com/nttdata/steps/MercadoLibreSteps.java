package com.nttdata.steps;

import com.nttdata.page.MercadoLibreHomePage;
import com.nttdata.page.MercadoLibreSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MercadoLibreSteps {

    private WebDriver driver;

    public MercadoLibreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToMercadoLibre() {
        driver.get("https://www.mercadolibre.com.pe/"); 
    }

    public void searchProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(MercadoLibreHomePage.searchInput));
        searchBox.sendKeys(product);
        driver.findElement(MercadoLibreHomePage.searchButton).click();
    }

    public int getResultsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(MercadoLibreSearchPage.resultsList));
        List<WebElement> results = driver.findElements(MercadoLibreSearchPage.resultsList);
        return results.size();
    }

    public String getFirstResultTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(MercadoLibreSearchPage.resultsList));
        WebElement firstItem = driver.findElements(MercadoLibreSearchPage.resultsList).get(0);

        WebElement titleElement = firstItem.findElement(org.openqa.selenium.By.cssSelector("[class*='title']"));
        return titleElement.getText();
    }
}
