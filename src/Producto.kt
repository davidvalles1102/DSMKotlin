data class Producto(
    //  almacena el nombre del producto.
    val nombre: String,

    // almacena el precio del producto.
    val precio: Double,

    //  almacena la cantidad disponible en stock del producto.
    var cantidadDisponible: Int
) {

    // Sobrescribe el metodo equals para definir cómo se comparan dos objetos de tipo Producto.

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Producto) return false
        return nombre == other.nombre && precio == other.precio
    }

    // Sobrescribe el método hashCode para generar un código hash único para cada producto.
    override fun hashCode(): Int {
        // Calcula el hash code combinando el hash code del nombre y el precio el número 31 ayuda a reducir colisiones.
        return 31 * nombre.hashCode() + precio.hashCode()
    }
}