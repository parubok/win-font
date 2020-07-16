package org.swingk.winfont;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinFontFactoryTest {
    @Test
    void checkFonts() {
        for (WinFont winFont : WinFont.values()) {
            Assertions.assertNotNull(WinFontFactory.getFont(winFont));
        }
    }
}
