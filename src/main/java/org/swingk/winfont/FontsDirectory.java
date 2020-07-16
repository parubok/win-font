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

final class FontsDirectory {

    private final Map<WinFont, Font> loadedFonts = new EnumMap<>(WinFont.class);

    private final Path dir;

    FontsDirectory(Path dir) {
        this.dir = Objects.requireNonNull(dir);
    }

    private Path getFontFile(WinFont winFont) throws FontUnavailableException {
        Objects.requireNonNull(winFont);
        Path fontFile = dir.resolve(winFont.getFontFile());
        if (!Files.exists(fontFile)) {
            throw new FontUnavailableException("File " + winFont.getFontFile() + " does not exist in directory "
                    + dir.toString() + ".", true, winFont);
        }
        if (!Files.isReadable(fontFile)) {
            throw new FontUnavailableException("File " + winFont.getFontFile() + " in directory " + dir.toString()
                    + " is not readable.", true, winFont);
        }
        return fontFile;
    }

    Font getFont(WinFont winFont) throws FontUnavailableException {
        Objects.requireNonNull(winFont);
        if (loadedFonts.containsKey(winFont)) {
            return loadedFonts.get(winFont); // already loaded
        }
        Path fontFile = getFontFile(winFont);
        Font font;
        try (InputStream is = Files.newInputStream(fontFile)) {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (IOException | FontFormatException ex) {
            throw new FontUnavailableException("Unable to load font " + winFont.getFontName() + ".", ex, true, winFont);
        }
        loadedFonts.put(winFont, Objects.requireNonNull(font));
        return font;
    }
}
