Small Java library to obtain instances of `java.awt.Font` for font files in Windows fonts directory (usually `c:\Windows\fonts`).
A viwer application `org.swingk.winfont.Viewer` is available under `test` root.

Example:
```java
import org.swingk.winfont.WinFontFactory;
import org.swingk.winfont.WinFont;
import org.swingk.winfont.FontUnavailableException;

java.awt.Font tahomaFont = null;
try {
  tahomaFont = WinFontFactory.getFont(WinFont.TAHOMA);
} catch(FontUnavailableException e) {
  tahomaFont = ...; // provide some substitute
}
```
