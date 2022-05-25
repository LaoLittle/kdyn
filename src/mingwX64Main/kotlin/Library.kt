import kotlinx.cinterop.*
import platform.windows.*

actual class Library actual constructor(handle: CPointer<out CPointed>) :
    LibraryPlatform(handle) {
    private val windowsHandle = handle.reinterpret<HINSTANCE__>()

    actual fun close() {
        FreeLibrary(windowsHandle)
    }

    actual fun <F: Function<*>> get(symbol: String): CPointer<CFunction<F>> {
        val fn = GetProcAddress(windowsHandle, symbol) ?: throw LibraryLoadingException("Error code: ${GetLastError()}")

        return fn.reinterpret()
    }

    actual companion object {
        actual fun open(file: String): Library? {
            val handle = LoadLibraryExW(file, null, 0)
            return handle?.let { Library(it) }
        }
    }


}