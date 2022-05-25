class LibraryLoadingException(override val message: String?): Exception() {
    constructor(): this(null)
}

class LibraryNotFoundException(override val message: String?): Exception() {
    constructor(): this(null)
}