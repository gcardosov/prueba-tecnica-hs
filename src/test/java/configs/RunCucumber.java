package configs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        tags = "@PruebaHS",
        publish = true
)

public class RunCucumber {

    public RunCucumber(){
    }

@AfterClass
    public static void quitDriver(){
        System.out.println("Se cierra el web driver");


}



}
