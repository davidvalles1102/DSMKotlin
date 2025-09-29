fun main() {
    
    val productosDisponibles = mutableListOf(
        Producto("Laptop", 800.0, 5),
        Producto("Cocina", 20.0, 10),
        Producto("Juego de Sala", 30.0, 8),
        Producto("Comedor", 150.0, 7),
        Producto("Cama", 120.0, 4),
        Producto("Horno de microhondas", 80.0, 6),
        Producto("Plancha", 15.0, 20),
        Producto("Licuadora", 300.0, 3),
        Producto("Batididora", 250.0, 5),
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
        println("2. Agregar producto al carrito")
        println("3. Eliminar producto del carrito")
        println("4. Ver carrito")
        println("5. Finalizar compra")
        println("6. Salir")


        print("Seleccione una opción: ")
        when (readLine()?.toIntOrNull()) {

            1 -> {
                println("\n📦 Productos disponibles:")
                // Itera sobre la lista de productos disponibles y los muestra con su índice, nombre, precio y stock.
                productosDisponibles.forEachIndexed { index, producto ->
                    println("${index + 1}. ${producto.nombre} - ${producto.precio} USD (Stock: ${producto.cantidadDisponible})")
                }
            }

            2 -> {
                print("Ingrese el número del producto a agregar: ")
               
                val productoIndex = readLine()?.toIntOrNull()?.minus(1)
               
                if (productoIndex in productosDisponibles.indices) {
                    print("Ingrese la cantidad: ")
                  
                    val cantidad = readLine()?.toIntOrNull() ?: 0
                   
                    carrito.agregarProducto(productosDisponibles[productoIndex!!], cantidad)
                } else {
                   
                    println("⚠️ Opción inválida.")
                }
            }
           
            3 -> {
               
                println("\n🛒 Productos en el carrito:")
               
                val productosEnCarrito = carrito.obtenerProductos().toList()
                productosEnCarrito.forEachIndexed { index, (producto, cantidad) ->
                    println("${index + 1}. ${producto.nombre} - ${producto.precio} USD/u x$cantidad → Subtotal: ${producto.precio * cantidad} USD")
                }
                
                println("Total: ${carrito.total()} USD")

                print("Ingrese el número del producto a eliminar: ")
              
                val productoIndex = readLine()?.toIntOrNull()?.minus(1)
                
                if (productoIndex != null && productoIndex in productosEnCarrito.indices) {
                    
                    val productoAEliminar = productosEnCarrito[productoIndex].first
                  
                    carrito.eliminarProducto(productoAEliminar)
                 
                    println("✅ Producto eliminado: ${productoAEliminar.nombre}")
                } else {
                 
                    println("⚠️ Opción inválida.")
                }
            }
         
            4 -> carrito.mostrarCarrito()
         
            5 -> {
               
                carrito.mostrarCarrito()
             
                factura.generarFactura(carrito)
            }
         
            6 -> {
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
  
    if (System.getProperty("os.name").contains("Windows")) {
      
        println("\u001b[H\u001b[2J")
    } else {
       
        print("\u001b[H\u001b[2J")
    }
}
