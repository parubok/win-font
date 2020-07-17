package org.swingk.winfont;

public class FontUnavailableException extends RuntimeException {
    private final boolean fontsDirectoryAvailable;

    public FontUnavailableException(String msg, Exception source, boolean fontsDirectoryAvailable) {
        super(msg, source);
        this.fontsDirectoryAvailable = fontsDirectoryAvailable;
    }

    public FontUnavailableException(String msg, boolean fontsDirectoryAvailable) {
        super(msg);
        this.fontsDirectoryAvailable = fontsDirectoryAvailable;
    }

    /**
     * @return True if the problem is only with the specific font, false if the fonts directory was not located at all.
     */
    public boolean isFontsDirectoryAvailable() {
        return fontsDirectoryAvailable;
    }
}
