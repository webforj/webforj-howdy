package com.webforj.howdy.views;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

/**
 * View component displaying information about webforJ framework.
 * 
 * This view serves as an educational showcase that:
 * <ul>
 *   <li>Highlights key features and benefits of webforJ</li>
 *   <li>Provides links to documentation and resources</li>
 *   <li>Demonstrates various UI components and styling techniques</li>
 * </ul>
 * 
 * The Credits view exemplifies webforJ's capabilities for creating
 * rich, informative content pages with interactive elements.
 * 
 * @author webforJ Team
 * @since 1.0
 */
@Route(value = "/credits", outlet = MainLayout.class)
@FrameTitle("Credits")
public class CreditsView extends Composite<FlexLayout> {

  /** The root FlexLayout component bound to this composite */
  private final FlexLayout self = getBoundComponent();

  /**
   * Constructs the Credits view with webforJ framework information.
   * 
   * Creates a visually appealing layout featuring:
   * <ul>
   *   <li>Framework description and overview</li>
   *   <li>Feature highlights with emoji icons</li>
   *   <li>Call-to-action buttons for learning resources</li>
   *   <li>Version information display</li>
   * </ul>
   * 
   * The view uses FlexLayout for responsive design and demonstrates
   * various styling techniques including CSS variables, HTML content
   * in paragraphs, and button theming.
   */
  public CreditsView() {
    self.setDirection(FlexDirection.COLUMN);
    self.setAlignment(FlexAlignment.CENTER);
    self.setStyle("padding", "var(--dwc-space-l)");
    self.setMaxWidth("900px");
    self.setStyle("margin", "0 auto");

    // WebforJ Logo/Title with animation
    H2 title = new H2("Built with webforJ");
    title.setStyle("color", "var(--dwc-color-primary)");
    title.setStyle("text-align", "center");
    title.setStyle("margin-bottom", "var(--dwc-space-m)");
    title.setStyle("font-size", "2.5rem");
    title.setStyle("animation", "fadeInDown 0.8s ease-out");

    // Main description
    Paragraph mainDesc = new Paragraph(
      "webforJ is a powerful Java framework for building modern web applications " +
      "with a component-based architecture. Write your entire application in Java " +
      "while delivering a rich, responsive user experience."
    );
    mainDesc.setStyle("text-align", "center");
    mainDesc.setStyle("font-size", "1.2rem");
    mainDesc.setStyle("margin-bottom", "var(--dwc-space-xl)");
    mainDesc.setStyle("color", "var(--dwc-color-default-text-color)");
    mainDesc.setStyle("opacity", "0.9");

    // Tabbed content section
    TabbedPane tabbedPane = new TabbedPane();
    tabbedPane.setStyle("margin-bottom", "var(--dwc-space-xl)");
    
    // Features tab
    Tab featuresTab = new Tab("Features", TablerIcon.create("rocket"));
    FlexLayout featuresWrapper = new FlexLayout();
    featuresWrapper.setDirection(FlexDirection.COLUMN);
    featuresWrapper.setAlignment(FlexAlignment.CENTER);
    featuresWrapper.setStyle("padding", "var(--dwc-space-l)");
    featuresWrapper.add(createFeaturesSection());
    tabbedPane.addTab(featuresTab, featuresWrapper);
    
    // Getting Started tab
    Tab gettingStartedTab = new Tab("Getting Started", TablerIcon.create("code"));
    FlexLayout gettingStartedWrapper = new FlexLayout();
    gettingStartedWrapper.setDirection(FlexDirection.COLUMN);
    gettingStartedWrapper.setStyle("padding", "var(--dwc-space-l)");
    gettingStartedWrapper.add(createGettingStartedSection());
    tabbedPane.addTab(gettingStartedTab, gettingStartedWrapper);
    
    // Resources tab
    Tab resourcesTab = new Tab("Resources", TablerIcon.create("book"));
    FlexLayout resourcesWrapper = new FlexLayout();
    resourcesWrapper.setDirection(FlexDirection.COLUMN);
    resourcesWrapper.setStyle("padding", "var(--dwc-space-l)");
    resourcesWrapper.add(createResourcesSection());
    tabbedPane.addTab(resourcesTab, resourcesWrapper);

    // Call to action buttons
    FlexLayout ctaSection = new FlexLayout();
    ctaSection.setJustifyContent(FlexJustifyContent.CENTER);
    ctaSection.setStyle("gap", "var(--dwc-space-m)");
    ctaSection.setStyle("margin-top", "var(--dwc-space-xl)");
    ctaSection.setStyle("flex-wrap", "wrap");

    Button learnMoreBtn = new Button("Visit webforJ.com");
    learnMoreBtn.setTheme(ButtonTheme.PRIMARY);
    learnMoreBtn.setStyle("font-size", "1.1rem");
    learnMoreBtn.setStyle("padding", "var(--dwc-space-l) var(--dwc-space-xl)");
    learnMoreBtn.setStyle("min-height", "48px");
    learnMoreBtn.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('https://webforj.com', '_blank');")
    );

    Button docsBtn = new Button("Documentation");
    docsBtn.setTheme(ButtonTheme.DEFAULT);
    docsBtn.setStyle("font-size", "1.1rem");
    docsBtn.setStyle("padding", "var(--dwc-space-l) var(--dwc-space-xl)");
    docsBtn.setStyle("min-height", "48px");
    docsBtn.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('https://docs.webforj.com', '_blank');")
    );

    Button githubBtn = new Button("GitHub");
    githubBtn.setTheme(ButtonTheme.DEFAULT);
    githubBtn.setStyle("font-size", "1.1rem");
    githubBtn.setStyle("padding", "var(--dwc-space-l) var(--dwc-space-xl)");
    githubBtn.setStyle("min-height", "48px");
    githubBtn.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('https://github.com/webforj', '_blank');")
    );

    ctaSection.add(learnMoreBtn, docsBtn, githubBtn);

    // Version and footer info
    Div footerSection = new Div();
    footerSection.setStyle("text-align", "center");
    footerSection.setStyle("margin-top", "var(--dwc-space-xl)");
    footerSection.setStyle("padding-top", "var(--dwc-space-l)");
    footerSection.setStyle("border-top", "1px solid var(--dwc-color-surface-3)");

    Paragraph version = new Paragraph("This application is built with webforJ version 25.00");
    version.setStyle("color", "var(--dwc-color-default-text-color)");
    version.setStyle("opacity", "0.7");
    version.setStyle("font-size", "0.9rem");
    version.setStyle("margin-bottom", "var(--dwc-space-s)");

    Paragraph copyright = new Paragraph("© 2025 webforJ. Built with ❤️ by the webforJ team.");
    copyright.setStyle("color", "var(--dwc-color-default-text-color)");
    copyright.setStyle("opacity", "0.6");
    copyright.setStyle("font-size", "0.85rem");

    footerSection.add(version, copyright);

    // Add styles for animations and hover effects
    Div styleContainer = new Div();
    styleContainer.setHtml(
      "<style>" +
      "@keyframes fadeInDown {" +
      "  from { opacity: 0; transform: translateY(-20px); }" +
      "  to { opacity: 1; transform: translateY(0); }" +
      "}" +
      "@keyframes fadeIn {" +
      "  from { opacity: 0; }" +
      "  to { opacity: 1; }" +
      "}" +
      ".feature-card:hover { transform: translateY(-5px); box-shadow: 0 5px 20px rgba(0,0,0,0.1); }" +
      ".resource-card:hover { transform: translateY(-3px); background: var(--dwc-color-surface-3); }" +
      "</style>"
    );

    self.add(styleContainer, title, mainDesc, tabbedPane, ctaSection, footerSection);
  }

  private FlexLayout createFeaturesSection() {
    FlexLayout featuresGrid = new FlexLayout();
    featuresGrid.setDirection(FlexDirection.ROW);
    featuresGrid.setStyle("flex-wrap", "wrap");
    featuresGrid.setStyle("gap", "var(--dwc-space-m)");
    featuresGrid.setJustifyContent(FlexJustifyContent.CENTER);

    // Feature cards
    featuresGrid.add(
      createFeatureCard("🚀", "Component-Based", "Build reusable UI components with ease"),
      createFeatureCard("☕", "100% Java", "No JavaScript required, leverage your Java skills"),
      createFeatureCard("📱", "Responsive", "Built-in responsive components for all devices"),
      createFeatureCard("🎨", "Rich UI Library", "Extensive pre-built components including charts"),
      createFeatureCard("⚡", "Hot Reload", "See your changes instantly during development"),
      createFeatureCard("🔒", "Enterprise Ready", "Secure, scalable, and production-tested")
    );

    return featuresGrid;
  }

  private Div createFeatureCard(String icon, String title, String description) {
    Div card = new Div();
    card.setStyle("background", "var(--dwc-color-surface-2)");
    card.setStyle("border-radius", "var(--dwc-border-radius-m)");
    card.setStyle("padding", "var(--dwc-space-l)");
    card.setStyle("width", "280px");
    card.setStyle("text-align", "center");
    card.setStyle("transition", "all 0.3s ease");
    card.setStyle("cursor", "pointer");
    card.setStyle("animation", "fadeIn 0.6s ease-out");
    
    // Add hover effect class
    card.addClassName("feature-card");

    Div iconDiv = new Div();
    iconDiv.setHtml(icon);
    iconDiv.setStyle("font-size", "3rem");
    iconDiv.setStyle("margin-bottom", "var(--dwc-space-m)");

    H3 cardTitle = new H3(title);
    cardTitle.setStyle("margin-bottom", "var(--dwc-space-s)");
    cardTitle.setStyle("color", "var(--dwc-color-primary)");

    Paragraph cardDesc = new Paragraph(description);
    cardDesc.setStyle("opacity", "0.8");
    cardDesc.setStyle("font-size", "0.95rem");

    card.add(iconDiv, cardTitle, cardDesc);
    return card;
  }

  private FlexLayout createGettingStartedSection() {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setStyle("padding", "var(--dwc-space-l)");
    section.setAlignment(FlexAlignment.CENTER);

    H3 title = new H3("Quick Start Guide");
    title.setStyle("margin-bottom", "var(--dwc-space-l)");
    title.setStyle("text-align", "center");

    // Step cards
    Div step1 = createStepCard("1", "Install Prerequisites", 
      "Ensure you have Java 21+ and Maven installed on your system.");
    
    Div step2 = createStepCard("2", "Create New Project", 
      "Use the webforJ Maven archetype to generate a new project structure.");
    
    Div step3 = createStepCard("3", "Run Your App", 
      "Execute 'mvn jetty:run' to start the development server with hot reload.");

    // Code example
    Div codeExample = new Div();
    codeExample.setStyle("background", "var(--dwc-color-surface-3)");
    codeExample.setStyle("border-radius", "var(--dwc-border-radius-m)");
    codeExample.setStyle("padding", "var(--dwc-space-l)");
    codeExample.setStyle("margin-top", "var(--dwc-space-l)");
    codeExample.setStyle("font-family", "monospace");
    codeExample.setStyle("max-width", "600px");
    
    Paragraph codeTitle = new Paragraph("<b>Example: Hello World Component</b>");
    codeTitle.setHtml("true");
    codeTitle.setStyle("margin-bottom", "var(--dwc-space-m)");
    
    Paragraph code = new Paragraph(
      "<pre>@Route(\"/\")<br>" +
      "public class HelloWorld extends Composite&lt;Div&gt; {<br>" +
      "  public HelloWorld() {<br>" +
      "    getBoundComponent().add(new H1(\"Hello, webforJ!\"));<br>" +
      "  }<br>" +
      "}</pre>"
    );
    code.setHtml("true");
    code.setStyle("font-size", "0.9rem");
    
    codeExample.add(codeTitle, code);

    section.add(title, step1, step2, step3, codeExample);
    return section;
  }

  private Div createStepCard(String number, String title, String description) {
    Div card = new Div();
    card.setStyle("display", "flex");
    card.setStyle("align-items", "center");
    card.setStyle("gap", "var(--dwc-space-m)");
    card.setStyle("margin-bottom", "var(--dwc-space-m)");
    card.setStyle("padding", "var(--dwc-space-m)");
    card.setStyle("background", "var(--dwc-color-surface-2)");
    card.setStyle("border-radius", "var(--dwc-border-radius-m)");
    card.setStyle("max-width", "600px");

    Div numberCircle = new Div();
    numberCircle.setHtml(number);
    numberCircle.setStyle("width", "40px");
    numberCircle.setStyle("height", "40px");
    numberCircle.setStyle("background", "var(--dwc-color-primary)");
    numberCircle.setStyle("color", "white");
    numberCircle.setStyle("border-radius", "50%");
    numberCircle.setStyle("display", "flex");
    numberCircle.setStyle("align-items", "center");
    numberCircle.setStyle("justify-content", "center");
    numberCircle.setStyle("font-weight", "bold");
    numberCircle.setStyle("flex-shrink", "0");

    Div content = new Div();
    H3 stepTitle = new H3(title);
    stepTitle.setStyle("margin-bottom", "var(--dwc-space-xs)");
    Paragraph stepDesc = new Paragraph(description);
    stepDesc.setStyle("opacity", "0.8");
    stepDesc.setStyle("margin", "0");
    
    content.add(stepTitle, stepDesc);
    card.add(numberCircle, content);
    
    return card;
  }

  private FlexLayout createResourcesSection() {
    FlexLayout section = new FlexLayout();
    section.setDirection(FlexDirection.COLUMN);
    section.setStyle("padding", "var(--dwc-space-l)");
    section.setAlignment(FlexAlignment.CENTER);

    H3 title = new H3("Learning Resources");
    title.setStyle("margin-bottom", "var(--dwc-space-l)");
    title.setStyle("text-align", "center");

    // Resource links
    FlexLayout resourceGrid = new FlexLayout();
    resourceGrid.setDirection(FlexDirection.ROW);
    resourceGrid.setStyle("flex-wrap", "wrap");
    resourceGrid.setStyle("gap", "var(--dwc-space-m)");
    resourceGrid.setJustifyContent(FlexJustifyContent.CENTER);

    resourceGrid.add(
      createResourceLink("📚", "Official Documentation", "Comprehensive guides and API reference", "https://docs.webforj.com"),
      createResourceLink("🎓", "Tutorials", "Step-by-step tutorials for beginners", "https://webforj.com/tutorials"),
      createResourceLink("💬", "Community Forum", "Get help and share knowledge", "https://forum.webforj.com"),
      createResourceLink("📺", "Video Courses", "Learn through video tutorials", "https://webforj.com/videos"),
      createResourceLink("🛠️", "Examples", "Browse sample applications", "https://github.com/webforj/webforj-examples"),
      createResourceLink("📰", "Blog", "Latest news and best practices", "https://blog.webforj.com")
    );

    section.add(title, resourceGrid);
    return section;
  }

  private Div createResourceLink(String icon, String title, String description, String url) {
    Div card = new Div();
    card.setStyle("background", "var(--dwc-color-surface-2)");
    card.setStyle("border-radius", "var(--dwc-border-radius-m)");
    card.setStyle("padding", "var(--dwc-space-l)");
    card.setStyle("width", "280px");
    card.setStyle("text-align", "center");
    card.setStyle("transition", "all 0.3s ease");
    card.setStyle("cursor", "pointer");
    
    card.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('" + url + "', '_blank');")
    );

    card.addClassName("resource-card");

    Div iconDiv = new Div();
    iconDiv.setHtml(icon);
    iconDiv.setStyle("font-size", "2.5rem");
    iconDiv.setStyle("margin-bottom", "var(--dwc-space-m)");

    H3 cardTitle = new H3(title);
    cardTitle.setStyle("margin-bottom", "var(--dwc-space-s)");
    cardTitle.setStyle("color", "var(--dwc-color-primary)");
    cardTitle.setStyle("font-size", "1.2rem");

    Paragraph cardDesc = new Paragraph(description);
    cardDesc.setStyle("opacity", "0.8");
    cardDesc.setStyle("font-size", "0.9rem");

    card.add(iconDiv, cardTitle, cardDesc);
    return card;
  }
}