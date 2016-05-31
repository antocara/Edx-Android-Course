package android.antocara.tipcalc;

import android.app.Application;

public class TipCalcApp extends Application {
  private final static String ABOUT_URL = "http://www.anpstudio.com";

  public static String getAboutUrl() {
    return ABOUT_URL;
  }
}
