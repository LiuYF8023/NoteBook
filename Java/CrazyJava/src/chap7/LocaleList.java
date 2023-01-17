package chap7;

import java.util.Locale;

public class LocaleList {
	public static void main(String[] args) {
		Locale[] localeList = Locale.getAvailableLocales();
		for (Locale locale: localeList) {
			System.out.println(locale.getDisplayCountry() + " = " + locale.getCountry());
		}
	}
}
