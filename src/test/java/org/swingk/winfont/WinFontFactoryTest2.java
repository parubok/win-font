package org.swingk.winfont;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This test won't run automatically since it conflicts with other test when run together.
 */
public class WinFontFactoryTest2 {
    @Test
    void invalidFontFolder() {
        System.setProperty(WinFontFactory.DIR_PROP, "non-existing-dir-3");
        for (WinFont winFont : WinFont.values()) {
            Assertions.assertThrows(FontUnavailableException.class, () -> WinFontFactory.getFont(winFont));
        }
        System.clearProperty(WinFontFactory.DIR_PROP);
    }
}
