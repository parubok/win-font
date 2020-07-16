Small Java library to obtain instances of `java.awt.Font` for some [standard fonts](https://docs.microsoft.com/en-us/typography/fonts/windows_10_font_list) in Windows font directory (usually `c:\Windows\fonts`).

Path to the font directory may be specified via system property `org.swingk.winfont.fontDir` (e.g. for unit testing).

A viewer application `org.swingk.winfont.Viewer` is available under `test` root.

Main motivation for having this library is to allow using high quality fonts provided with Windows while preventing legal issues, since bundling and redistributing Windows fonts with 3rd party software is usually [forbidden](https://docs.microsoft.com/en-us/typography/fonts/font-faq).

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
