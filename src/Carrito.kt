import java.text.DecimalFormat
import java.util.logging.FileHandler
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

class Carrito {
    companion object {
        private val fileHandler = FileHandler("carrito.log", true).apply {
            formatter = SimpleFormatter()
        }
        private val logger: Logger = Logger.getLogger(Carrito::class.java.name).apply {
            addHandler(fileHandler)
            useParentHandlers = false
        }

        init {
            Runtime.getRuntime().addShutdownHook(Thread { fileHandler.close() })
        }
    }

    private val productosEnCarrito = mutableMapOf<Producto, Int>()

    fun agregarProducto(producto: Producto, cantidad: Int) {
        if (cantidad > producto.cantidadDisponible) {
            val msg = "No hay suficiente stock de ${producto.nombre}. Disponible: ${producto.cantidadDisponible}"
            println(msg)
            logger.warning(msg)
            return
        }
        productosEnCarrito[producto] = productosEnCarrito.getOrDefault(producto, 0) + cantidad
        producto.cantidadDisponible -= cantidad
        val msg = "${cantidad}x ${producto.nombre} agregado al carrito."
        println(msg)
        logger.info(msg)
    }

    fun eliminarProducto(producto: Producto) {
        val cantidadActual = productosEnCarrito[producto]
        if (cantidadActual != null) {
            productosEnCarrito.remove(producto)
            producto.cantidadDisponible += cantidadActual
            val msg = "${cantidadActual}x ${producto.nombre} eliminado del carrito."
            println("🗑️ $msg")
            logger.info(msg)
        } else {
            val msg = "El producto no está en el carrito."
            println("⚠️ $msg")
            logger.warning(msg)
        }
    }

    fun vaciarCarrito() {
        productosEnCarrito.clear()
        logger.info("Carrito vaciado tras compra finalizada.")
    }

    fun mostrarCarrito() {
        if (productosEnCarrito.isEmpty()) {
            println("El carrito está vacío.")
            logger.info("El carrito está vacío.")
            return
        }

        val df = DecimalFormat("#,##0.00")
        val entries = productosEnCarrito.entries

        var nameWidth = "Producto".length
        var cantWidth = "Cant.".length
        var precioWidth = "Precio (USD/u)".length
        var subtotalWidth = "Subtotal (USD)".length

        for (e in entries) {
            val p = e.key
            val c = e.value
            nameWidth = maxOf(nameWidth, p.nombre.length)
            cantWidth = maxOf(cantWidth, c.toString().length)
            precioWidth = maxOf(precioWidth, df.format(p.precio).length)
            subtotalWidth = maxOf(subtotalWidth, df.format(p.precio * c).length)
        }

        fun line(l: Char, mid: Char, r: Char, fill: Char): String =
            "$l${fill.toString().repeat(nameWidth + 2)}" +
                    "$mid${fill.toString().repeat(cantWidth + 2)}" +
                    "$mid${fill.toString().repeat(precioWidth + 2)}" +
                    "$mid${fill.toString().repeat(subtotalWidth + 2)}$r"

        println("\n🛒 Carrito de Compras")
        println(line('┌', '┬', '┐', '─'))
        println(
            "│ " + "Producto".padEnd(nameWidth) +
                    " │ " + "Cant.".padStart(cantWidth) +
                    " │ " + "Precio (USD/u)".padStart(precioWidth) +
                    " │ " + "Subtotal (USD)".padStart(subtotalWidth) + " │"
        )
        println(line('├', '┼', '┤', '─'))

        var total = 0.0
        var totalItems = 0

        for (e in entries) {
            val p = e.key
            val c = e.value
            val subtotal = p.precio * c
            total += subtotal
            totalItems += c

            println(
                "│ " + p.nombre.padEnd(nameWidth) +
                        " │ " + c.toString().padStart(cantWidth) +
                        " │ " + df.format(p.precio).padStart(precioWidth) +
                        " │ " + df.format(subtotal).padStart(subtotalWidth) + " │"
            )
        }

        println(line('└', '┴', '┘', '─'))
        println("Artículos: $totalItems")
        println("Total: USD ${df.format(total)}")
        logger.info("Carrito mostrado: $totalItems artículos, total USD ${df.format(total)}")
    }

    fun total(): Double = productosEnCarrito.entries.sumOf { it.key.precio * it.value }

    fun obtenerProductos(): Map<Producto, Int> = productosEnCarrito
}
