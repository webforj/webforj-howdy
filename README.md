# Howdy - A webforJ Sample Application

This sample application demonstrates how to build a modern web application using [webforJ](https://webforj.com), a powerful Java framework that lets you create rich web applications entirely in Java - no JavaScript required!

## 🚀 What You'll Learn

This sample showcases key webforJ concepts:
- **Component-based UI development** - Build reusable UI components
- **Routing and navigation** - Create multi-page applications with annotation-based routing
- **Layouts and styling** - Use flexible layouts and CSS styling
- **Data visualization** - Integrate Google Charts for dynamic data display
- **State management** - Handle application state with namespaces
- **Event handling** - Respond to user interactions

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- A modern web browser

## 🏃 Quick Start

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Howdy
   ```

2. **Run the application**
   ```bash
   mvn jetty:run
   ```

3. **Open your browser**
   Navigate to http://localhost:8080

The application will automatically reload when you make changes to the code!

## 🏗️ Project Structure

```
src/main/java/com/webforj/howdy/
├── Application.java          # Main application entry point
├── components/
│   └── NoData.java          # Reusable component example
├── util/
│   ├── NicknameGenerator.java    # Utility class example
│   └── NicknameGenerationException.java
└── views/
    ├── MainLayout.java      # Application layout with navigation
    ├── YouView.java         # Form input and validation example
    ├── DashboardView.java   # Data visualization with charts
    ├── UsersView.java       # Dynamic data display
    └── CreditsView.java     # Static content and external links
```

## 🔑 Key Concepts Explained

### 1. Application Entry Point (`Application.java`)

```java
@AppTitle("Howdy")
@Routify(packages = "com.webforj.howdy.views")
@StyleSheet("context://css/app.css")
@AppProfile
public class Application extends App {
}
```

- `@AppTitle` - Sets the application title
- `@Routify` - Enables automatic route discovery in the specified package
- `@StyleSheet` - Links global CSS styles
- `@AppProfile` - Defines app metadata

### 2. Routing and Navigation

webforJ uses annotation-based routing:

```java
@Route(value = "/dashboard", outlet = MainLayout.class)
@FrameTitle("Dashboard")
public class DashboardView extends Composite<FlexLayout> {
    // View implementation
}
```

- `@Route` - Defines the URL path and parent layout
- `@FrameTitle` - Sets the page title
- Views extend `Composite<T>` where T is the root component type

### 3. Component Architecture

Components are built using composition:

```java
public class YouView extends Composite<FlexLayout> {
    private FlexLayout self = getBoundComponent();
    private TextField nicknameInput = new TextField("Your Nickname:");
    private ListBox moodSelection = new ListBox("How are you?");
    
    public YouView() {
        self.setDirection(FlexDirection.COLUMN);
        self.add(nicknameInput, moodSelection);
    }
}
```

### 4. Event Handling

Handle user interactions with event listeners:

```java
Button submitButton = new Button("Submit");
submitButton.onClick(e -> {
    // Handle click event
    String value = textField.getText();
    Toast.show("Hello " + value);
});
```

### 5. State Management

Use PrivateNamespace for application state:

```java
PrivateNamespace model = new PrivateNamespace("HowdyApp", "Board", true);

// Store data
model.put("key", "value");

// Retrieve data
String value = (String) model.get("key");

// Listen for changes
model.onChange(event -> updateUI());
```

### 6. Data Visualization

Integrate charts easily:

```java
GoogleChart chart = new GoogleChart(GoogleChart.Type.BAR);
Map<String, Object> options = new HashMap<>();
options.put("title", "Chart Title");
chart.setOptions(options);

List<Object> data = new ArrayList<>();
data.add(Arrays.asList("Label", "Value"));
data.add(Arrays.asList("Item 1", 10));
chart.setData(data);
```

### 7. Styling

Apply styles using CSS variables and inline styles:

```java
component.setStyle("margin", "var(--dwc-space-m)");
component.setStyle("width", "80%");
component.addClassName("custom-class");
```

## 🛠️ Development Commands

```bash
# Run in development mode with hot reload
mvn jetty:run

# Build WAR file
mvn clean package

# Build for production
mvn clean package -Pprod

# Run tests
mvn verify

# Generate Javadoc documentation
mvn javadoc:javadoc

# Generate Javadoc and package as JAR
mvn javadoc:jar

# Generate aggregated Javadoc (for multi-module projects)
mvn javadoc:aggregate
```

The generated Javadoc will be available in `target/site/apidocs/`.

## 🎯 Best Practices

1. **Component Reusability** - Create small, focused components that can be reused
2. **Consistent Styling** - Use CSS variables for consistent theming
3. **Event Management** - Always clean up event listeners in `onDidDestroy()`
4. **Type Safety** - Leverage Java's type system for safer code
5. **Separation of Concerns** - Keep views, components, and utilities separate

## 📚 Learning Path

1. **Start with `Application.java`** - Understand the entry point
2. **Explore `MainLayout.java`** - Learn about layouts and navigation
3. **Study `YouView.java`** - See form handling and validation
4. **Examine `DashboardView.java`** - Learn data visualization
5. **Review `UsersView.java`** - Understand dynamic data display
6. **Check `CreditsView.java`** - See static content and external links

## 🔗 Resources

- [webforJ Documentation](https://docs.webforj.com)
- [webforJ Website](https://webforj.com)
- [Component Gallery](https://demo.webforj.com)
- [GitHub Repository](https://github.com/webforj)

## 🤝 Contributing

This is a sample application designed for learning. Feel free to fork, modify, and use it as a starting point for your own webforJ projects!

## 📄 License

This sample is provided as-is for educational purposes. Check the LICENSE file for details.