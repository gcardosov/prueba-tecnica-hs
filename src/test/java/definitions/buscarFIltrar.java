package definitions;


import configs.WebDriverManeger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;

public class buscarFIltrar {

    private final WebDriver driver = WebDriverManeger.getDriver();

    @Given("estoy en Mercado libre {string}")
    public void estoy_en_mercado_libre(String url) {
        driver.get(url);
        System.out.println("1) Navegando al sitio: " + url);
    }

    @Then("validar que el logo sea de {string}")
    public void validar_que_el_logo_sea_de(String textoEsperado) {
        WebElement logo = driver.findElement(By.cssSelector("h1.ml-logo.ml-logo-es"));
        String textoActual = logo.getText().trim();
        Assert.assertEquals("El texto del logo no coincide", textoEsperado, textoActual);
    }

    @When("seleccionar {string} en la seccion de pais")
    public void seleccionar_en_la_seccion_de_pais(String pais) {
        try {
            WebElement enlacePais = driver.findElement(By.id("MX"));
            enlacePais.click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No se encontró el enlace con id 'MX' para seleccionar el país.");
        }
        System.out.println("2) Se seleeciono Mexico como pais");
    }

    @When("buscar el producto {string}")
    public void buscar_el_producto(String consola) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("cb1-edit")).sendKeys(consola + Keys.ENTER);
        System.out.println("3) Busqueda de " + consola);
    }

    @When("filtrar por condicion {string}")
    public void filtrar_por_condicion(String condicion) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='ui-search-filter-name' and text()='" + condicion + "']")).click();
        System.out.println("4) Filtro condicion " + condicion);
    }

    @When("filtrar por origen del envio {string}")
    public void filtrar_por_origen_del_envio(String origen) throws InterruptedException {
        Thread.sleep(1000);
        WebElement elemento = driver.findElement(By.xpath("//span[@class='ui-search-filter-name' and text()='" + origen + "']")
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
        Thread.sleep(500);
        elemento.click();
        System.out.println("5) Filtro origen " + origen);
    }


    @When("ordenar los resultados por {string}")
    public void ordenar_los_resultados_por(String string) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Más relevantes']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(text(),'Mayor precio')]")).click();
        System.out.println("6) Ordenar de mayor a menor precio");
    }



    @Then("obtener el nombre y precio de los primeros {int} productos y mostrar en consola")
    public void obtener_el_nombre_y_precio_de_los_primeros_productos(Integer cantidad) throws InterruptedException {
        Thread.sleep(2000); // Espera simple (puedes usar WebDriverWait si prefieres)

        List<WebElement> productos = driver.findElements(By.cssSelector(".ui-search-layout__item"));

        if (productos.isEmpty()) {
            System.out.println("No se encontraron productos en la página.");
            return;
        }
        System.out.println("7) Obtener nombre precio de los 5 primeros productos");

        int limite = Math.min(cantidad, productos.size());

        for (int i = 0; i < limite; i++) {
            WebElement producto = productos.get(i);

            String nombre = "Nombre no disponible";
            String precio = "Precio no disponible";

            try {
                nombre = producto.findElement(By.cssSelector(".poly-component__title")).getText();
            } catch (Exception e) {
                System.out.println("No se encontró nombre para producto #" + (i + 1));
            }

            try {
                precio = producto.findElement(By.cssSelector("span.andes-money-amount__fraction")).getText();
            } catch (Exception e) {
                System.out.println("No se encontró precio para producto #" + (i + 1));
            }

            System.out.println((i + 1) + ") Producto: " + nombre + " | Precio: $" + precio);
        }
    }
}








