class Factura {

    fun generarFactura(carrito: Carrito) {
        val productos = carrito.obtenerProductos()
        if (productos.isEmpty()) {
            println("\n⚠️  El carrito está vacío, no hay productos para facturar.\n🛒 ¡Agrega productos para continuar con tu compra!")
            return
        }
        println("\n" + "✨".repeat(40))
        println("          🧾 FACTURA DE COMPRA 🧾          ")
        println("✨".repeat(40))
        var total = 0.0
        println("\n📦 Producto       | 🔢 Cant | 💵 Precio | 📊 Subtotal")
        println("-".repeat(50))
        productos.forEach { (producto, cantidad) ->
            val subtotal = cantidad * producto.precio

            println("${producto.nombre.padEnd(15)} | ${cantidad.toString().padEnd(5)} | ${producto.precio} USD | ${subtotal} USD")

            total += subtotal
        }

        println("-".repeat(50))
        println("💰 TOTAL A PAGAR: ${"%.2f".format(total)} USD")
        println("✨".repeat(40))

        println("\n🙌 ¡Gracias por confiar en nosotros!")
        println("📅 Fecha: ${java.time.LocalDate.now()} ⏰ Hora: ${java.time.LocalTime.now().withNano(0)}")
        println("🎉 ¡Vuelva pronto y disfrute su compra!\n")
    }
}
