Challenge Conversor de Tipo de cambio con API de Exchangerate

Gracias por utilizar el programa "Conversor de tipo de Cambio"

Al ejecutarse el programa aparece un menú con las distintas opciones de conversión de monedas enumeradas del 1 al 9, se le solicita al usuario que seleccionel tipo de cambio a convetir, por ejemplo la opción "1" será la conversión de dólares (USD) a pesos mexicancos (MXN):


¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
Bienvenido/a al Conversor de Tipo de Cambio :)

1) Dólar (USD) =====>>> Peso Mexicano (MXN)
2) Peso Mexicano (MXN) =====>>> Dólar (USD)
3) Dólar (USD) =====>>> Peso Argentino (ARS)
4) Peso Argentino (ARS) =====>>> Dólar (USD)
5) Dólar (USD) =====>>> Real Brasileño (BRL)
6) Real Brasileño (BRL) =====>>> Dólar (USD)
7) Dólar (USD) =====>>> Peso Colombiano (COP)
8) Peso Colombiano (COP) =====>>> Dólar (USD)
9) Salir

Elija el número de opción deseada?
¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬
1

A continuación se solicita la cantidad de dólares (USD) a convertir a pesos mexicancos (MXN), por ejemplo, convertir "1000 USD" a pesos mexicanos (MXN):

Ingrese la cantidad de Dólares USD a convertir a Pesos MX:
1000

El programa mostrará la conversión del monto en Dólares USD a Pesos MX así como hora y fecha de consulta:

El valor de 1000.0 USD corresponde a >>>>>>  18730.3 MXN al día de hoy 21/07/2025 a las 14:55:43 horas

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

Por cada conversión de tipo de cambio se generará un archivo jason con el nombre de la conversión  de monedas que contiene los parámetros y valores de la API utilizados, según sea la conversión de monedas, en este ejemplo de peso argentino (ARS) a dolar (USD), el nombre del archivo sería, ARS-USD.json

Nota_ Para los parámetros de consulta y desplegado se extrajeron de la exchangerate-api el json correpondiente, ejemplo:

Mi api-key asiganda fue "00ea0ba48fa95c26188b5953"
https://v6.exchangerate-api.com/v6/00ea0ba48fa95c26188b5953/pair/ARS/USD/10000

{
    "result": "success",
    "documentation": "https://www.exchangerate-api.com/docs",
    "terms_of_use": "https://www.exchangerate-api.com/terms",
    "time_last_update_unix": 1753056001,
    "time_last_update_utc": "Mon, 21 Jul 2025 00:00:01 +0000",
    "time_next_update_unix": 1753142401,
    "time_next_update_utc": "Tue, 22 Jul 2025 00:00:01 +0000",
    "base_code": "ARS",
    "target_code": "USD",
    "conversion_rate": 0.00077892,
    "conversion_result": 7.7892
}

