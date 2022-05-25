import kotlinx.cinterop.invoke
import kotlinx.cinterop.pointed
import platform.posix.dlopen
import platform.posix.dlsym
import kotlin.test.Test

class Test {
    @Test
    operator fun invoke() {
        val a = Library.open("./liblib.so")
        val fn = a!!.get<() -> Unit>("test")
        fn()
    }
}