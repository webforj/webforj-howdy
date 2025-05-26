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
import com.webforj.component.layout.flexlayout.FlexLayout;
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
  private FlexLayout self = getBoundComponent();

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
    self.setMaxWidth("800px");
    self.setStyle("margin", "0 auto");

    // WebforJ Logo/Title
    H2 title = new H2("Built with webforJ");
    title.setStyle("color", "var(--dwc-color-primary)");
    title.setStyle("text-align", "center");
    title.setStyle("margin-bottom", "var(--dwc-space-m)");

    // Main description
    Paragraph mainDesc = new Paragraph(
      "webforJ is a powerful Java framework for building modern web applications " +
      "with a component-based architecture. Write your entire application in Java " +
      "while delivering a rich, responsive user experience."
    );
    mainDesc.setStyle("text-align", "center");
    mainDesc.setStyle("font-size", "1.1rem");
    mainDesc.setStyle("margin-bottom", "var(--dwc-space-l)");

    // Features section
    Div featuresSection = new Div();
    featuresSection.setStyle("background", "var(--dwc-color-surface-2)");
    featuresSection.setStyle("padding", "var(--dwc-space-l)");
    featuresSection.setStyle("border-radius", "var(--dwc-border-radius-m)");
    featuresSection.setStyle("margin-bottom", "var(--dwc-space-l)");

    H3 featuresTitle = new H3("Why Choose webforJ?");
    featuresTitle.setStyle("margin-bottom", "var(--dwc-space-m)");

    Paragraph feature1 = new Paragraph("🚀 <b>Component-Based Architecture</b> - Build reusable UI components with ease");
    feature1.setHtml("true");
    feature1.setStyle("margin-bottom", "var(--dwc-space-s)");

    Paragraph feature2 = new Paragraph("☕ <b>100% Java</b> - No JavaScript required, leverage your existing Java skills");
    feature2.setHtml("true");
    feature2.setStyle("margin-bottom", "var(--dwc-space-s)");

    Paragraph feature3 = new Paragraph("📱 <b>Responsive Design</b> - Built-in responsive components that work on all devices");
    feature3.setHtml("true");
    feature3.setStyle("margin-bottom", "var(--dwc-space-s)");

    Paragraph feature4 = new Paragraph("🎨 <b>Rich UI Components</b> - Extensive library of pre-built components including charts, grids, and more");
    feature4.setHtml("true");
    feature4.setStyle("margin-bottom", "var(--dwc-space-s)");

    Paragraph feature5 = new Paragraph("⚡ <b>Hot Reload</b> - See your changes instantly during development");
    feature5.setHtml("true");

    featuresSection.add(featuresTitle, feature1, feature2, feature3, feature4, feature5);

    // Call to action
    Div ctaSection = new Div();
    ctaSection.setStyle("text-align", "center");
    ctaSection.setStyle("margin-top", "var(--dwc-space-l)");

    Paragraph ctaText = new Paragraph("Ready to build your next web application with Java?");
    ctaText.setStyle("font-size", "1.1rem");
    ctaText.setStyle("margin-bottom", "var(--dwc-space-m)");

    Button learnMoreBtn = new Button("Learn More at webforj.com");
    learnMoreBtn.setTheme(ButtonTheme.PRIMARY);
    learnMoreBtn.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('https://webforj.com', '_blank');")
    );

    Button docsBtn = new Button("View Documentation");
    docsBtn.setTheme(ButtonTheme.DEFAULT);
    docsBtn.setStyle("margin-left", "var(--dwc-space-s)");
    docsBtn.onClick(e -> 
      com.webforj.Page.getCurrent().executeJs("window.open('https://docs.webforj.com', '_blank');")
    );

    ctaSection.add(ctaText, learnMoreBtn, docsBtn);

    // Version info
    Paragraph version = new Paragraph("This application is built with webforJ version 25.00");
    version.setStyle("text-align", "center");
    version.setStyle("color", "var(--dwc-color-default-text-color)");
    version.setStyle("opacity", "0.7");
    version.setStyle("margin-top", "var(--dwc-space-xl)");
    version.setStyle("font-size", "0.9rem");

    self.add(title, mainDesc, featuresSection, ctaSection, version);
  }
}