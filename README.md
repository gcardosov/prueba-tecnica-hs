***************** Instrucciones **************


EL proyecto esta hecho con Java, Cucumber, Selenium, 

1) Sincronizar el archivo pom.xml para importar las dependecias de Selenium, Cucumber y Junit

2) En el archivo WebDriverManager en el siguiente metodo 
            System.setProperty("webdriver.chrome.driver", "/home/gcardoso/Documentos/Driver/chromedriver-linux64/chromedriver");
***NOTA: 			
hay que cambiar el path del webdriver en este proyecto se uso el webdriver para chrome para la version del navegador Versión 137.0.7151.103 (Build oficial) (64 bits)
para Ubuntu si se desea correr para WIndows se puede descargar de https://googlechromelabs.github.io/chrome-for-testing/
System.setProperty("webdriver.chrome.driver", "ruta en windows""); , 
El driver que se uso en este proyecto este proyecto se encuentra en la ruta  /home/gcardoso/Documentos/Driver/chromedriver-linux64/chromedriver

3) Clonar el repositorio de la rama master 

4) Ejecutar el script RunCucumberTest.java


***OBSERVACIONES 
-Sobre las instrucciones del ejercicio
*Con el impuslo al programa de "Mercado Envíos" se desvincula la compra de la ubicación del vendedor en prodcutos como las consolas de videojuegos
en articulos como automoviles aun es posible ver la ubicacion.

*Para efectos del ejercicio lo cambie por el filtro "Origen"
