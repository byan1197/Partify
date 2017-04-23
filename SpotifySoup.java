import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class SpotifySoup {
	Document doc;
	Elements nowPlayingLink;
	public SpotifySoup() throws IOException {
		doc = Jsoup.connect("http://play.spotify.com").get();
		nowPlayingLink = doc.select("h3#track-name");
	}	
	
	private void updateDocument() throws IOException{
		doc = Jsoup.connect("http://play.spotify.com").get();
		nowPlayingLink = doc.select("h3#track-name");
	}
	
	private String getLink(){
		String url = nowPlayingLink.attr("abs:href");
		return url;
	}
}