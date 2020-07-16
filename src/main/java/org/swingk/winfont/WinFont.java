package org.swingk.winfont;

/**
 * Enum which enumerates some standard Windows 10 fonts.
 *
 * See https://docs.microsoft.com/en-us/typography/fonts/windows_10_font_list
 */
public enum WinFont {
    ARIAL("Arial", "Arial.ttf"),
    ARIAL_BOLD("Arial Bold", "Arialbd.ttf"),
    CALIBRI("Calibri", "Calibri.ttf"),
    CALIBRI_BOLD("Calibri Bold", "Calibrib.ttf"),
    CALIBRI_LIGHT("Calibri Light", "Calibril.ttf"),
    CANDARA("Candara", "Candara.ttf"),
    CONSOLAS("Consolas", "Consola.ttf"),
    CORBEL("Corbel", "Corbel.ttf"),
    CORBEL_BOLD("Corbel Bold", "Corbelb.ttf"),
    CORBEL_ITALIC("Corbel Italic", "Corbeli.ttf"),
    COURIER_NEW("Courier New", "Cour.ttf"),
    COURIER_NEW_BOLD("Courier New Bold", "Courbd.ttf"),
    COURIER_NEW_ITALIC("Courier New Italic", "Couri.ttf"),
    MICROSOFT_SANS_SERIF("Microsoft Sans Serif", "Micross.ttf"),
    TAHOMA("Tahoma", "Tahoma.ttf"),
    TAHOMA_BOLD("Tahoma Bold", "Tahomabd.ttf"),
    VERDANA("Verdana", "Verdana.ttf"),
    VERDANA_BOLD("Verdana Bold", "Verdanab.ttf"),
    SEGOE_UI("Segoe UI", "Segoeui.ttf"),
    SEGOE_UI_BOLD("Segoe UI Bold", "Segoeuib.ttf"),
    TREBUCHET_MS("Trebuchet MS", "Trebuc.ttf"),
    TREBUCHET_MS_BOLD("Trebuchet MS Bold", "Trebucbd.ttf");

    private String fontName;
    private String fontFile;

    WinFont(String fontName, String fontFile) {
        this.fontName = fontName;
        this.fontFile = fontFile;
    }

    /**
     * For example, "Tahoma Bold".
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * For example, "Tahomabd.ttf".
     */
    public String getFontFile() {
        return fontFile;
    }
}
