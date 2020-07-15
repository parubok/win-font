Small Java library to obtain instances of `java.awt.Font` for font files in Windows fonts directory (usually `c:\Windows\fonts`).
A viwer application `org.swingk.winfont.Viewer` is available under `test` root.

Main motivation for having this library is to prevent legal issues, since bundling and redistributing Windows fonts with 3rd party software is usually [forbidden](https://docs.microsoft.com/en-us/typography/fonts/font-faq).

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
