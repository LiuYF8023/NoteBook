package chap7;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloArg {
	public static void main(String[] args) {
		Locale currentLocale = null;
		if(args.length == 2){
			currentLocale = new Locale(args[0],args[1]);
		}else {
			currentLocale = Locale.getDefault(Locale.Category.FORMAT);
		}

	}
}
