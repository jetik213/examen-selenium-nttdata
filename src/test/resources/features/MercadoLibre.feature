# language: es
@testfeature
Característica: MercadoLibre
  Yo, como usuario
  Quiero, tener una opción para buscar productos
  Para ver los productos que estoy interesado

  @busquedaProducto
  Escenario: Busqueda de Productos
    Dado estoy en la página de MercadoLibre
    Cuando busco un producto "Televisores Led 40 pulgadas"
    Entonces una lista de resultados
    Y valido el primer titulo del resultado sea "Smart Tv Samsung 40\" Fhd F6000F 2025 Black UN40F6000FGXPE"
