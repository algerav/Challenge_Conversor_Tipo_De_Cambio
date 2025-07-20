# Challenge_Conversor_Tipo_De_Cambio
Challenge Conversor de Tipo de cambio con API de Exchangerate

Gracias por utilizar el programa "Conversor de tipo de Cambio"

Al ejecutarse el programa aparece un menú con las distintas opciones de conversión de monedas enumeradas del 1 al 9, se le solicita al usuario que seleccionel tipo de cambio a convetir, por ejemplo la opción "1" será la conversión de dólares (USD) a pesos mexicancos (MXN):


Bienvenido/a al Conversor de Tipo de Cambio :)

1) Dólar =====>>> Peso Mexicano
2) Peso Mexicano =====>>> Dólar
3) Dólar =====>>> Peso Argentino
4) Peso Argentino  =====>>> Dólar
5) Dólar =====>>> Real Brasileño
6) Real Brasileño =====>>> Dólar
7) Dólar =====>>> Peso Colombiano
8) Peso Colombiano =====>>> Dólar
9) Salir

Elija el número de opción deseada?
¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

1

A continuación se solicita la cantidad de dólares (USD) a convertir a pesos mexicancos (MXN), por ejemplo, convertir "1000 USD" a pesos mexicanos (MXN):

Ingrese la cantidad de Dólares USD a convertir a Pesos MX: 
1000

El programa mostrará la conversión del monto en Dólares USD a Pesos MX así como hora y fecha de consulta:

El valor de 1000.0 USD corresponde a >>>>>>  18731.9 MXN al día de hoy 19/07/2025 a las 21:50:56 hora

Si el usuario ingresa en el menú del Conversor un valor numérico distinto del menú de conversión (Distinto de 1 a 9), por ejemplo "200", aparecerá un mensaje "Opción inválida. Por favor, elija una opción válida.":


Elija el número de opción deseada?
¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬

200
Opción inválida. Por favor, elija una opción válida.

Si el usuario ingresa en el menú de conversión algún valor de que no sea numérico, el programa mostrará un mensaje indicando que "La información ingresada no es un número, favor de ingresar una opción válida", por ejemplo, si ingresa AAABBB, aparecerá el siguiente mensaje:

Ingrese la cantidad de Dólares USD a convertir a Pesos MX: 
AAABBB
La información ingresada no es un número For input string: "AAABBB"
Favor de ingresar un opción válida

Sí desea salir de programa oprimir "9"

Por cada conversión de tipo de cambio se generará un archivo jason con el nombre de la conversión  de monedas que contiene los parámetros y valores de la API utilizados, según sea la conversión de monedas, en este ejemplo de peso argentino (ARS) a dolar (USD):

{
  "base_code": "ARS",
  "target_code": "USD",
  "conversion_rate": 7.7892E-4,
  "conversion_result": 934.704
}

