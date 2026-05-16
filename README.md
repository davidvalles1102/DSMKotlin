# 🛒 HappyMarket — Tienda en Consola con Kotlin

Proyecto de consola desarrollado en **Kotlin** que simula una tienda en línea. Permite al usuario explorar productos, gestionar un carrito de compras y generar una factura al finalizar la compra.

---

## 👥 Integrantes

| Nombre | Carné |
|--------|-------|
| Jonathan Jose Flamenco Lopez | FL161275 |
| Raquel Abigail Cortez Mata | CM162199 |
| Melvin Alexander Soriano Quijada | SQ242789 |
| David Alberto Valles Gómez | VG240553 |
| Herbert William Solano Vasquez | SV202844 |

---

## ✨ Funcionalidades

- 📋 Ver el catálogo de productos disponibles con precios y stock
- 🔍 Buscar productos por nombre
- ➕ Agregar productos al carrito eligiendo la cantidad
- ➖ Eliminar productos del carrito (restaura el stock automáticamente)
- 🛒 Ver el contenido del carrito con tabla formateada y total
- 🧾 Confirmar y generar una factura al finalizar la compra
- 🔄 Seguir comprando con el carrito limpio tras cada compra
- 📝 Registro de eventos y errores en archivo `carrito.log`

---

## 📦 Estructura del Proyecto

```
src/
├── Main.kt        # Menú principal e interacción con el usuario
├── Producto.kt    # Data class con nombre, precio y stock disponible
├── Carrito.kt     # Gestión del carrito: agregar, eliminar, mostrar y vaciar
└── Factura.kt     # Generación de la factura de compra
```

### Descripción de clases

| Clase | Responsabilidad |
|-------|----------------|
| `Producto` | Representa un artículo de la tienda con nombre, precio y cantidad disponible |
| `Carrito` | Maneja los productos seleccionados, valida stock, calcula totales y registra logs |
| `Factura` | Imprime el resumen de compra con fecha, hora y total a pagar |
| `Main.kt` | Controla el flujo del programa mediante un menú interactivo de 7 opciones |

---

## 🖥️ Capturas de pantalla

![Menú principal](https://github.com/user-attachments/assets/1bbf258b-933c-47a8-9ee0-f286ade6c1d9)

![Catálogo de productos](https://github.com/user-attachments/assets/718c4bd6-045d-43f7-9c7d-898e779fef07)

![Agregar al carrito](https://github.com/user-attachments/assets/93f9cbb6-63e9-41f0-b89a-633eefc15b4c)

![Ver carrito](https://github.com/user-attachments/assets/e10bfcad-ca57-41ae-b94f-f5f2011aa5c1)

![Eliminar producto](https://github.com/user-attachments/assets/da0ca03b-8a4b-48de-aff3-ad3cc2a7d45d)

![Confirmación de compra](https://github.com/user-attachments/assets/b8fae110-55dd-4eb2-a8d5-f7925bd60530)

![Factura generada](https://github.com/user-attachments/assets/07505292-3c5b-42a9-88e8-2b6d41b09d2c)

![Log de eventos](https://github.com/user-attachments/assets/666b570f-0723-4724-a4e1-87f60399d51e)

---

## ▶️ Ejecución

### Requisitos
- [Kotlin](https://kotlinlang.org/docs/command-line.html) instalado en el sistema

### Compilar y ejecutar

```bash
# Compilar todos los archivos fuente
kotlinc src/Producto.kt src/Carrito.kt src/Factura.kt src/Main.kt -include-runtime -d carrito.jar

# Ejecutar
java -jar carrito.jar
```

---

## 📋 Menú de opciones

| Opción | Descripción |
|--------|-------------|
| 1 | Ver todos los productos disponibles |
| 2 | Buscar producto por nombre |
| 3 | Agregar producto al carrito |
| 4 | Eliminar producto del carrito |
| 5 | Ver carrito actual |
| 6 | Finalizar compra y generar factura |
| 7 | Salir |
