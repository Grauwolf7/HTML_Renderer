# HTML Renderer

An elegant HTML document generator written in Kotlin that demonstrates modern object-oriented design principles and Kotlin's powerful features. This project implements a flexible system for creating HTML documents programmatically, with a focus on clean code and type safety.

## Overview

The HTML Renderer uses the Composite pattern to build HTML documents from nested elements. It supports various HTML elements including headings, paragraphs, lists, and containers, all while maintaining proper indentation and structure in the generated HTML.

### Key Features

- Type-safe HTML element creation
- Flexible composition of nested elements
- Automatic proper indentation of generated HTML
- Support for ordered and unordered lists
- Convenient string extension functions for element creation
- Clean and maintainable Kotlin code showcasing modern programming practices

## Design

The project is built around several core interfaces that form a clear hierarchy:

- `Element`: The base interface for all HTML elements
- `TaggedElement`: Represents elements with opening and closing tags
- `TextElement`: For elements containing simple text
- `TaggedTextElement`: Combines tagged and text elements
- `ContainerElement`: For elements that can contain other elements

### Example Usage

```kotlin
val page = Page(
    "My First Page",
    "Welcome to HTML Renderer".h1(),
    Div(
        "This is a paragraph".p(),
        HTMLList(
            true,  // Creates an ordered list
            ListItem("First item"),
            ListItem("Second item")
        )
    )
)

val html = HTMLRenderer.render(page)

```
This will generate properly formatted HTML:

```
<html>
  <head>
    <title>My First Page</title>
  </head>
  <body>
    <h1>Welcome to HTML Renderer</h1>
    <div>
      <p>This is a paragraph</p>
      <ol>
        <li>First item</li>
        <li>Second item</li>
      </ol>
    </div>
  </body>
</html>
```

### Implementation Details
The project showcases several important Kotlin features and programming concepts:

Sealed interfaces for type safety
Data classes for clean element implementations
Extension functions for intuitive API design
String interpolation for HTML generation
Recursive rendering using the Composite pattern

## Getting Started

1. Clone the repository:
```git clone https://github.com/Grauwolf7/HTML_Renderer.git```

2. Open the project in IntelliJ IDEA or your preferred Kotlin IDE
3. Build and run the project to see example output
