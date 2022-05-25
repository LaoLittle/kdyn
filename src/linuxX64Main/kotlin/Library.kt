import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.toKString
import platform.posix.dlclose
import platform.posix.dlerror
import platform.posix.dlopen
import platform.posix.dlsym

actual class Library actual constructor(handle: RawPointer) :
    LibraryPlatform(handle) {
    actual fun close() {
        val code = dlclose(handle)

        when (code) { // todo
        }
    }

    actual fun <F: Function<*>> get(symbol: String): CPointer<CFunction<F>> {
        val fn = dlsym(handle, symbol)
        when (val message = dlerror()?.toKString()) {
            null -> return fn!!.reinterpret()
            else -> throw LibraryLoadingException(message)
        }
    }

    actual companion object {
        actual fun open(file: String): Library? {
            val handle = dlopen(file, 1 or 0)

            return handle?.let { Library(it) }
        }
    }
}