data class Div(
    override val elements: List<Element>
) : ContainerElement {

    override val tag: String
        get() = "div"

    // this() is a call of the primary constructor, elements.toList() = ListItem[] gets passed as parameter
    constructor(vararg elements: Element) : this(elements.toList())
}