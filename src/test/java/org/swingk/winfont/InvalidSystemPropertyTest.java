package org.swingk.winfont;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidSystemPropertyTest {
    @Test
    void invalidFontDir() {
        System.setProperty(WinFontFactory.DIR_PROP, "non-existing-dir-3");
        for (WinFont winFont : WinFont.values()) {
            Assertions.assertThrows(FontUnavailableException.class, () -> WinFontFactory.getFont(winFont));
        }
        System.clearProperty(WinFontFactory.DIR_PROP);
    }
}
