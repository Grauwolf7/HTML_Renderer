data class HTMLList(
    override val elements: List<ListItem>,
    val ordered: Boolean
) : ContainerElement {
    override val tag: String
        get() = if (ordered) "ol" else "ul"

    constructor(ordered: Boolean, vararg items: ListItem) : this(items.toList(), ordered)
}