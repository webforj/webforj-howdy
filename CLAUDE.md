# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a WebforJ web application - a modern Java framework for building web applications with a component-based architecture. The application demonstrates a dashboard interface with routing, responsive UI components, and data visualization.

## Common Development Commands

### Running the Application
```bash
# Start development server with hot reload (http://localhost:8080)
mvn jetty:run

# Run on different port
mvn jetty:run -Djetty.port=8090
```

### Building
```bash
# Build WAR file
mvn clean package

# Build for production (uses webforj-prod.conf)
mvn clean package -Pprod
```

### Testing
```bash
# Run integration tests
mvn verify

# The project uses Playwright for browser testing
```

## Architecture

### Application Structure
- **Entry Point**: `Application.java` - Minimal setup with `@Routify` annotation for automatic routing
- **Routing**: Annotation-based routing with views in `com.webforj.howdy.views` package
- **Layout**: `MainLayout` serves as the root layout with navigation
- **Views**: `DashboardView`, `UsersView`, `YouView` are routed child views

### Key WebforJ Patterns
- Components extend WebforJ component classes (e.g., `Composite<AppLayout>`)
- Use `@Route` annotations for view routing
- UI is built programmatically using WebforJ's component API
- Styling via CSS files linked with `@StyleSheet` annotation

### Configuration
- Development config: `src/main/resources/webforj-dev.conf`
- Production config: `src/main/resources/webforj-prod.conf`
- Static resources: `src/main/resources/static/`

## Important Notes
- Java 21 is required
- The application uses Google Charts for data visualization via webforj-googlecharts dependency
- Hot reload is enabled in development mode with 1-second scan interval
- WAR packaging targets servlet containers