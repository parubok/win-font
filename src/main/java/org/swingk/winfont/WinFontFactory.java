package org.swingk.winfont;

import java.awt.Font;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * This utility allows to load fonts from files in "Windows\fonts" directory.
 */
public class WinFontFactory {

    public static final String DIR_PROP = "org.swingk.winfont.fontDir";

    private static FontsDirectory winFontsDir;
    private static FontUnavailableException error;

    private WinFontFactory() {
    }

    private static void init() throws FontUnavailableException {
        if (winFontsDir == null && error == null) {
            try {
                winFontsDir = new FontsDirectory(getWinFontsDir());
            } catch (FontUnavailableException ex) {
                error = ex;
            }
        }
        if (error != null) {
            throw error;
        }
    }

    /**
     * @param winFont Font to load. Not null.
     * @return Font loaded from file in Windows\fonts directory.
     * @throws FontUnavailableException If the font cannot be loaded.
     */
    public static Font getFont(WinFont winFont) throws FontUnavailableException {
        Objects.requireNonNull(winFont);
        init();
        return winFontsDir.getFont(winFont);
    }

    /**
     * https://support.microsoft.com/en-us/help/314960/how-to-install-or-remove-a-font-in-windows
     * http://stackoverflow.com/questions/4339037/getting-system32-folder-location-in-java
     *
     * @return Path of Windows font directory (usually 'c:\Windows\fonts').
     * @throws FontUnavailableException If the Windows font directory was not found (e.g. on Linux OS) or is not
     * accessible.
     */
    private static Path getWinFontsDir() throws FontUnavailableException {
        Path fontsDir = null;
        String dirPropValue = System.getProperty(DIR_PROP);
        if (dirPropValue != null) {
            Path propPath;
            try {
                propPath = Paths.get(dirPropValue);
            } catch (InvalidPathException ex) {
                throw new FontUnavailableException("System property " + DIR_PROP + " points to invalid location: "
                        + dirPropValue + ".", ex, false);
            }
            if (Files.isDirectory(propPath)) {
                fontsDir = propPath;
            } else {
                throw new FontUnavailableException("System property " + DIR_PROP + " points to a non-directory: "
                        + dirPropValue + ".", false);
            }
        } else {
            String envVarValue = System.getenv("WINDIR");
            if (envVarValue != null) {
                try {
                    Path envVarPath = Paths.get(envVarValue, "fonts");
                    if (Files.isDirectory(envVarPath)) {
                        fontsDir = envVarPath;
                    }
                } catch (InvalidPathException ex) {
                    // do nothing
                }
            }
            if (fontsDir == null) {
                throw new FontUnavailableException("Unable to access Windows fonts directory.", false);
            }
        }
        return Objects.requireNonNull(fontsDir);
    }
}
