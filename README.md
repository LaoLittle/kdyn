# kdyn

Easy to use for loading dynamic library in Kotlin/Native

How to use
```kotlin
val lib = Library.open("./libname.so") ?: throw Exception()
val fn = lib.get<() -> Unit>("function_name")
fn()
```

### Support platform:
* Windows X64 (mingwX64)
* Linux X64

macOS is not supported yet