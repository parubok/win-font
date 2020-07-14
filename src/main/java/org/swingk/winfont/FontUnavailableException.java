package org.swingk.winfont;

public class FontUnavailableException extends RuntimeException {
    private final boolean fontsDirectoryAvailable;
    private final WinFont winFont;

    public FontUnavailableException(String msg, Exception source, boolean fontsDirectoryAvailable, WinFont winFont) {
        super(msg, source);
        this.fontsDirectoryAvailable = fontsDirectoryAvailable;
        this.winFont = winFont;
    }

    public FontUnavailableException(String msg, boolean fontsDirectoryAvailable, WinFont winFont) {
        super(msg);
        this.fontsDirectoryAvailable = fontsDirectoryAvailable;
        this.winFont = winFont;
    }

    /**
     * @return True if the problem is only with the specific font, false if the fonts directory was not located at all.
     */
    public boolean isFontsDirectoryAvailable() {
        return fontsDirectoryAvailable;
    }

    /**
     * @return The requested font.
     */
    public WinFont getWinFont() {
        return winFont;
    }
}
