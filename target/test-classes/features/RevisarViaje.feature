## Creado por Oskar Orozco
## 14/12/2021
Feature: Listar ofertas de viaje
         Ingresar a la web de VIVAAIR y revisar si la oferta se encuentra de menor a mayor precio

  @CotizarViajes
  Scenario Outline: verificar viaje
    Given Ingreso a la web de vivaair
    When Selecciono solo ida
    And Ingreso el origen <origen>
    And Ingreso el destino <destino>
    And Ingreso la fecha de ida <fecha>
    And Busco vuelos disponibles
    Then Valido orden de los precios de menor a mayor

    Examples: 
      | origen     | destino       | fecha |
      | 'Bogotá'   | 'Santa Marta' | '24,Diciembre,2021' | 
      | 'Bogotá'   | 'Cúcuta'      | '3,Enero,2022' | 
