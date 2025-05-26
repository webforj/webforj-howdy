package com.webforj.howdy;

import com.webforj.App;
import com.webforj.annotation.AppProfile;
import com.webforj.annotation.Routify;
import com.webforj.annotation.StyleSheet;

/**
 * Main application entry point for the Howdy webforJ application.
 * 
 * This class serves as the bootstrap for the entire application, configuring
 * essential application-wide settings through annotations:
 * <ul>
 *   <li>Automatic route discovery for views</li>
 *   <li>Global stylesheet configuration</li>
 *   <li>Application profile metadata</li>
 * </ul>
 * 
 * The application demonstrates core webforJ concepts including component-based
 * UI development, routing, state management, and data visualization.
 * 
 * @author webforJ Team
 * @since 1.0
 */
@Routify(packages = "com.webforj.howdy.views")
@StyleSheet("ws://app.css")
@AppProfile(name = "Howdy", shortName = "Howdy")
public class Application extends App {}
