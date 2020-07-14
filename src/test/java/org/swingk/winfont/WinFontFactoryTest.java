package org.swingk.winfont;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinFontFactoryTest {

    @Test
    void test_1() {
        for (WinFont winFont : WinFont.values()) {
            Assertions.assertNotNull(WinFontFactory.getFont(winFont));
        }
    }
}
