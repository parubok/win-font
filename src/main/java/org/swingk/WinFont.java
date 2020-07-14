package org.swingk;

/**
 * Enum which enumerates standard Windows 10 fonts.
 *
 * See https://docs.microsoft.com/en-us/typography/fonts/windows_10_font_list
 */
public enum WinFont {
    ARIAL("Arial", "Arial.ttf"),
    ARIAL_BOLD("Arial Bold", "Arialbd.ttf"),
    CALIBRI("Calibri", "Calibri.ttf"),
    CALIBRI_BOLD("Calibri Bold", "Calibrib.ttf"),
    CALIBRI_LIGHT("Calibri Light", "Calibril.ttf"),
    TAHOMA("Tahoma", "Tahoma.ttf"),
    TAHOMA_BOLD("Tahoma Bold", "Tahomabd.ttf"),
    VERDANA("Verdana", "Verdana.ttf"),
    VERDANA_BOLD("Verdana Bold", "Verdanab.ttf"),
    SEGOE_UI("Segoe UI", "Segoeui.ttf"),
    SEGOE_UI_BOLD("Segoe UI Bold", "Segoeuib.ttf");

    /**
     * Font name.
     */
    String name;

    /**
     * Font file.
     */
    String file;

    WinFont(String name, String file) {
        this.name = name;
        this.file = file;
    }
}
