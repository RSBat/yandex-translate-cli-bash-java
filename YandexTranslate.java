import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class YandexTranslate {
	public static void main(String[] args) throws IOException {
		System.out.println(translate("ru", args[0]));
	}

	private static String translate(String lang, String enteredText) throws IOException {
		String textEscaped = enteredText.replace(" ", "%20");
		String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20150402T173446Z.82a90fe78ca2aeaf.a3bd7c7a0f72b260e28f5d92e4f242cf6ba189d3&lang="
				+ lang + "&text=" + textEscaped;
		URLConnection connection = null;
		try {
			connection = new URL(url).openConnection();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.printf("No text for translate");
		}
		InputStream response = connection.getInputStream();
		String json = new java.util.Scanner(response).nextLine();
		int start = json.indexOf("[");
		int end = json.indexOf("]");
		String translated = json.substring(start + 2, end - 1);
		if (translated.equals(enteredText)) {
			return translate("en", enteredText);
		} else return translated;
	}
}
