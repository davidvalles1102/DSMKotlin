fun main() {
    val productosDisponibles = mutableListOf(
        Producto("Laptop", 800.0, 5),
        Producto("Cocina", 20.0, 10),
        Producto("Juego de Sala", 30.0, 8),
        Producto("Comedor", 150.0, 7),
        Producto("Cama", 120.0, 4),
        Producto("Horno de microondas", 80.0, 6),
        Producto("Plancha", 15.0, 20),
        Producto("Licuadora", 300.0, 3),
        Producto("Batidora", 250.0, 5),
        Producto("Refri", 60.0, 9),
        Producto("Bateria de cocina", 50.0, 12),
        Producto("Sillon reclinable", 40.0, 8),
        Producto("Televisor", 35.0, 10),
        Producto("Aire Acondicionado", 200.0, 4),
        Producto("Ps5", 100.0, 6)
    )

    val carrito = Carrito()
    val factura = Factura()

    while (true) {
        clearScreen()

        println("\n📢 Menú Principal:")
        println("1. Ver productos")
        println("2. Buscar producto")
        println("3. Agregar producto al carrito")
        println("4. Eliminar producto del carrito")
        println("5. Ver carrito")
        println("6. Finalizar compra")
        println("7. Salir")

        print("Seleccione una opción: ")
        when (readLine()?.toIntOrNull()) {

            1 -> {
                println("\n📦 Productos disponibles:")
                productosDisponibles.forEachIndexed { index, producto ->
                    println("${index + 1}. ${producto.nombre} - ${producto.precio} USD (Stock: ${producto.cantidadDisponible})")
                }
            }

            2 -> {
                print("Ingrese el nombre a buscar: ")
                val termino = readLine()?.trim().orEmpty().lowercase()
                val resultados = productosDisponibles.filter { it.nombre.lowercase().contains(termino) }
                if (resultados.isEmpty()) {
                    println("⚠️ No se encontraron productos con \"$termino\".")
                } else {
                    println("\n🔍 Resultados para \"$termino\":")
                    resultados.forEach { p ->
                        val idx = productosDisponibles.indexOf(p) + 1
                        println("$idx. ${p.nombre} - ${p.precio} USD (Stock: ${p.cantidadDisponible})")
                    }
                }
            }

            3 -> {
                print("Ingrese el número del producto a agregar: ")
                val productoIndex = readLine()?.toIntOrNull()?.minus(1)
                if (productoIndex in productosDisponibles.indices) {
                    print("Ingrese la cantidad: ")
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                    if (cantidad <= 0) {
                        println("⚠️ La cantidad debe ser mayor a 0.")
                    } else {
                        carrito.agregarProducto(productosDisponibles[productoIndex!!], cantidad)
                    }
                } else {
                    println("⚠️ Opción inválida.")
                }
            }

            4 -> {
                val productosEnCarrito = carrito.obtenerProductos().toList()
                if (productosEnCarrito.isEmpty()) {
                    println("El carrito está vacío.")
                } else {
                    println("\n🛒 Productos en el carrito:")
                    productosEnCarrito.forEachIndexed { index, (producto, cantidad) ->
                        println("${index + 1}. ${producto.nombre} - ${producto.precio} USD/u x$cantidad → Subtotal: ${producto.precio * cantidad} USD")
                    }
                    println("Total: ${carrito.total()} USD")

                    print("Ingrese el número del producto a eliminar: ")
                    val productoIndex = readLine()?.toIntOrNull()?.minus(1)
                    if (productoIndex != null && productoIndex in productosEnCarrito.indices) {
                        carrito.eliminarProducto(productosEnCarrito[productoIndex].first)
                    } else {
                        println("⚠️ Opción inválida.")
                    }
                }
            }

            5 -> carrito.mostrarCarrito()

            6 -> {
                carrito.mostrarCarrito()
                if (carrito.obtenerProductos().isNotEmpty()) {
                    print("\n¿Desea confirmar la compra? (s/n): ")
                    val confirmacion = readLine()?.trim()?.lowercase()
                    if (confirmacion == "s") {
                        factura.generarFactura(carrito)
                        carrito.vaciarCarrito()
                    } else {
                        println("Compra cancelada.")
                    }
                }
            }

            7 -> {
                println("👋 ¡Gracias por usar la tienda!")
                break
            }

            else -> println("⚠️ Opción inválida.")
        }

        println("\nPresione Enter para continuar...")
        readLine()
    }
}

fun clearScreen() {
    print("[H[2J")
    System.out.flush()
}
