package org.swingk.winfont;

import java.awt.Font;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

/**
 * This utility allows to load fonts directly from files in "Windows\fonts" directory.
 */
public class WinFontFactory {

    private static FontsDirectory winFontsDir;
    private static String error;

    private WinFontFactory() {
    }

    private static void init(WinFont winFont) throws FontUnavailableException {
        if (winFontsDir == null && error == null) {
            Path d = getWinFontsDir();
            if (d != null) {
                winFontsDir = new FontsDirectory(d);
            } else {
                error = "Unable to locate Windows fonts directory";
            }
        }
        if (error != null) {
            throw new FontUnavailableException(error, false, winFont);
        }
    }

    /**
     * @param winFont Font to load. Not null.
     * @return Font loaded from file in Windows\fonts directory.
     * @throws FontUnavailableException If the font cannot be loaded.
     */
    public static Font getFont(WinFont winFont) throws FontUnavailableException {
        Objects.requireNonNull(winFont);
        init(winFont);
        return winFontsDir.getFont(winFont);
    }

    /**
     * https://support.microsoft.com/en-us/help/314960/how-to-install-or-remove-a-font-in-windows
     * http://stackoverflow.com/questions/4339037/getting-system32-folder-location-in-java
     *
     * @return null If the Windows fonts directory was not found (e.g. on Linux OS).
     */
    private static Path getWinFontsDir() {
        Path fontsDir = null;
        // SYSTEMROOT and WINDIR are identical in NT systems, but WINDIR also works for older, 9x kernel-based windows
        for (String envVar : Arrays.asList("WINDIR", "SystemRoot")) {
            String envVarValue = System.getenv(envVar);
            if (envVarValue != null && !envVarValue.isEmpty()) {
                Path envVarPath = Paths.get(envVarValue, "fonts");
                if (Files.isDirectory(envVarPath)) {
                    fontsDir = envVarPath;
                    break;
                }
            }
        }
        return fontsDir;
    }
}
