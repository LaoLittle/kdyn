import kotlinx.cinterop.*

typealias RawPointer = CPointer<out CPointed>
abstract class LibraryPlatform(val handle: RawPointer) {
    // more
}

expect class Library(handle: CPointer<out CPointed>): LibraryPlatform {
    fun close()

    fun <F: Function<*>> get(symbol: String): CPointer<CFunction<F>>

    companion object {
        fun open(file: String): Library?
    }
}