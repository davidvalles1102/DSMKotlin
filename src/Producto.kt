data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidadDisponible: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Producto) return false
        return nombre == other.nombre && precio == other.precio
    }
    override fun hashCode(): Int {
        return 31 * nombre.hashCode() + precio.hashCode()
    }
}