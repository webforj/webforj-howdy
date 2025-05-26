package com.webforj.howdy.util;

/**
 * Exception thrown when nickname generation fails.
 * 
 * This exception is used to indicate that the {@link NicknameGenerator}
 * was unable to generate a unique nickname after exhausting all available
 * combinations of adjectives and nouns.
 * 
 * @author webforJ Team
 * @since 1.0
 * @see NicknameGenerator
 */
public class NicknameGenerationException extends Exception {
    /**
     * Constructs a new nickname generation exception with the specified detail message.
     * 
     * @param message the detail message explaining why nickname generation failed
     */
    public NicknameGenerationException(String message) {
        super(message);
    }
}
