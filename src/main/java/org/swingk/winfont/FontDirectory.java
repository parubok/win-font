package org.swingk.winfont;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import static java.nio.file.Files.newInputStream;

final class FontDirectory {

    private final Map<WinFont, Font> loadedFonts = new EnumMap<>(WinFont.class);

    private final Path dir;

    FontDirectory(Path dir) {
        this.dir = Objects.requireNonNull(dir);
    }

    private Path getFontFile(String fontFileName) throws FontUnavailableException {
        Objects.requireNonNull(fontFileName);
        Path fontFile = dir.resolve(fontFileName);
        if (!Files.exists(fontFile)) {
            throw new FontUnavailableException("File " + fontFileName + " does not exist in "
                    + dir.toString() + ".", true);
        }
        if (!Files.isReadable(fontFile)) {
            throw new FontUnavailableException("File " + fontFileName + " in " + dir.toString()
                    + " is not readable.", true);
        }
        return fontFile;
    }

    Font getFont(WinFont winFont) throws FontUnavailableException {
        Objects.requireNonNull(winFont);
        if (loadedFonts.containsKey(winFont)) {
            return loadedFonts.get(winFont); // already loaded
        }
        Path fontFile = getFontFile(winFont.getFontFile());
        Font font;
        try (InputStream is = newInputStream(fontFile)) {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException ex) {
            throw new FontUnavailableException("Unable to load font " + winFont.getFontName() + ".", ex, true);
        }
        loadedFonts.put(winFont, Objects.requireNonNull(font));
        return font;
    }
}
