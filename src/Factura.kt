// Definición de la clase Factura, que se encarga de generar una factura de compra.
class Factura {

    // Función para generar una factura basada en los productos en el carrito.
    fun generarFactura(carrito: Carrito) {
        val productos = carrito.obtenerProductos()

        // Verifica si el carrito está vacío.
        if (productos.isEmpty()) {
            println("\n⚠️  El carrito está vacío, no hay productos para facturar.\n🛒 ¡Agrega productos para continuar con tu compra!")
            return
        }

        // Encabezado vistoso de la factura
        println("\n" + "✨".repeat(40))
        println("          🧾 FACTURA DE COMPRA 🧾          ")
        println("✨".repeat(40))

        var total = 0.0

        // Encabezados de la tabla
        println("\n📦 Producto       | 🔢 Cant | 💵 Precio | 📊 Subtotal")
        println("-".repeat(50))

        // Itera sobre los productos
        productos.forEach { (producto, cantidad) ->
            val subtotal = cantidad * producto.precio

            // Mostrar en formato tabla con alineación
            println("${producto.nombre.padEnd(15)} | ${cantidad.toString().padEnd(5)} | ${producto.precio} USD | ${subtotal} USD")

            total += subtotal
        }

        // Línea final
        println("-".repeat(50))
        println("💰 TOTAL A PAGAR: ${"%.2f".format(total)} USD")
        println("✨".repeat(40))

        // Mensaje de cierre motivador
        println("\n🙌 ¡Gracias por confiar en nosotros!")
        println("📅 Fecha: ${java.time.LocalDate.now()} ⏰ Hora: ${java.time.LocalTime.now().withNano(0)}")
        println("🎉 ¡Vuelva pronto y disfrute su compra!\n")
    }
}
