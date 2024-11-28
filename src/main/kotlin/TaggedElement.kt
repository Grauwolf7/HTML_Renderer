sealed interface TaggedElement : Element {
    val tag: String //abstract read-only property

    // default implementation for tags
    // openTag and closeTag calculate their value from abstract tag-property
    val openTag: String
        get() = "<$tag>"

    val closeTag: String
        get() = "</$tag>"
}