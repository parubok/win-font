package org.swingk.winfont;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidSystemPropertyTest {
    @Test
    void invalidFontDir() {
        System.setProperty(WinFontFactory.DIR_PROP, "*non-existing-dir-3*");
        for (WinFont winFont : WinFont.values()) {
            try {
                WinFontFactory.getFont(winFont);
                Assertions.fail("Exception was not thrown.");
            } catch (FontUnavailableException e) {
                Assertions.assertFalse(e.isFontsDirectoryAvailable());
                Assertions.assertNotNull(e.getMessage());
                Assertions.assertNotNull(e.getLocalizedMessage());
            }
        }
        System.clearProperty(WinFontFactory.DIR_PROP);
    }
}
