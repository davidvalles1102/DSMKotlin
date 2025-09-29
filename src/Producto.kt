data class Producto(
    // variable que almacena el nombre del producto.
    val nombre: String,

    // variable que almacena el precio del producto.
    val precio: Double,

    // variable que almacena la cantidad disponible en stock del producto.
    var cantidadDisponible: Int
) {

    // Sobrescribe el método equals para definir cómo se comparan dos objetos de tipo Producto.
    override fun equals(other: Any?): Boolean {
        // Verifica si el objeto comparado es el mismo (misma referencia en memoria).
        if (this === other) return true

        // Verifica si el objeto comparado no es de tipo Producto.
        if (other !is Producto) return false

        // Compara los nombres y precios de los productos para determinar si son iguales.
        return nombre == other.nombre && precio == other.precio
    }

    // Sobrescribe el método hashCode para generar un código hash único para cada producto.
    override fun hashCode(): Int {
        // Calcula el hash code combinando el hash code del nombre y el precio el número 31 ayuda a reducir colisiones.
        return 31 * nombre.hashCode() + precio.hashCode()
    }
}