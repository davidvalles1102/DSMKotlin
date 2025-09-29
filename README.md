# 🛒 Tienda en Consola en Kotlin 🛒

## Integrantes

#Jonathan Jose Flamenco Lopez FL161275
#Raquel abigail Cortez Mata CM162199
#Melvin Alexander Soriano Quijada SQ242789
#David Alberto Valles Gómez VG240553
#Herbert William Solano Vasquez SV202844

Nuestro proyecto esta hecho en consola usando **Kotlin**, que simula una tienda en línea. Dentro de las funciones, podemos encontrar las siguientes:

## 🚀 Funcionalidades

- Ver los productos disponibles y su stock
- Agregar productos al carrito
- Eliminar productos del carrito
- Ver el contenido actual del carrito y el total
- Generar una factura al finalizar la compra

## 📦 Estructura del Proyecto

- `Producto`: Representa un producto con nombre, precio y cantidad disponible.
- `Carrito`: Clase para manejar los productos añadidos, calcular el total y mostrar el carrito.
- `Factura`: Genera una factura al finalizar la compra.
- `Main.kt`: Contiene el menú principal interactivo y la lógica de interacción.

## ▶️ Ejecución

Para ejecutar este proyecto, necesitas tener instalado Kotlin. Puedes compilar y ejecutar con:

```bash
kotlinc Main.kt -include-runtime -d Tienda.jar
java -jar Tienda.jar

#
