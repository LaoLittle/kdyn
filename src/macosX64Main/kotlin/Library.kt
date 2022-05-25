import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointed
import kotlinx.cinterop.CPointer

actual class Library actual constructor(handle: CPointer<out CPointed>):
    LibraryPlatform(handle) {
    actual fun close() {
        TODO()
    }

    actual fun <F: Function<*>> get(symbol: String): CPointer<CFunction<F>> {
        TODO()
    }

    actual companion object {
        actual fun open(file: String): Library? {
            TODO()
        }
    }
}