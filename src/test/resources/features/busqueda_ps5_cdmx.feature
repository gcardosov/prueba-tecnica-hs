
@feature1
  Feature: Buscar y filtrar ps5 en cdmx en ML

   @PruebaHS
   Scenario:  Buscar y filtrar
     Given estoy en Mercado libre "https://www.mercadolibre.com/"
     Then validar que el logo sea de "MercadoLibre"

     When seleccionar "Mexico" en la seccion de pais
     And buscar el producto "playstation 5"
     And filtrar por condicion "Nuevo"
     # --- And filtrar por origen del envio "" ---
     # ya no se encuentra ese filtro disponible
     And filtrar por origen del envio "Local"
     And ordenar los resultados por "mayor a menor precio"

     Then obtener el nombre y precio de los primeros 5 productos y mostrar en consola
