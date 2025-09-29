// Definición de una clase de datos (data class) llamada Producto.
// Las data classes en Kotlin son clases diseñadas para almacenar datos y generan automáticamente
// métodos como toString(), equals(), hashCode() y copy().
data class Producto(
    // Propiedad inmutable (val) que almacena el nombre del producto.
    val nombre: String,

    // Propiedad inmutable (val) que almacena el precio del producto.
    val precio: Double,

    // Propiedad mutable (var) que almacena la cantidad disponible en stock del producto.
    var cantidadDisponible: Int
) {

    // Sobrescribe el método equals para definir cómo se comparan dos objetos de tipo Producto.
    override fun equals(other: Any?): Boolean {
        // Verifica si el objeto comparado es el mismo (misma referencia en memoria).
        if (this === other) return true

        // Verifica si el objeto comparado no es de tipo Producto.
        if (other !is Producto) return false

        // Compara los nombres y precios de los productos para determinar si son iguales.
        // Dos productos se consideran iguales si tienen el mismo nombre y el mismo precio.
        return nombre == other.nombre && precio == other.precio
    }

    // Sobrescribe el método hashCode para generar un código hash único para cada producto.
    // Este método es importante cuando se usan objetos de tipo Producto en estructuras de datos
    // que dependen de hash codes, como HashMap o HashSet.
    override fun hashCode(): Int {
        // Calcula el hash code combinando el hash code del nombre y el precio.
        // El número 31 se usa comúnmente porque es un número primo y ayuda a reducir colisiones.
        return 31 * nombre.hashCode() + precio.hashCode()
    }
}