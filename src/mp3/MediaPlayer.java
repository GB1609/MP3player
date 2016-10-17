package mp3;
import java.util.ArrayList;
import java.util.HashMap;
public class MediaPlayer
{
	private static HashMap<String, MP3> songsMap;
	private static ArrayList<String> songsIntMap;
	private static int currentSong;
	private static boolean playing;
	static
	{
		playing = true;
		songsMap = new HashMap<String, MP3>();
		songsIntMap = new ArrayList<String>();
	}
	public static void addSong(String path, String name)
	{
		songsMap.put(name, new MP3(path));
		songsIntMap.add(name);
	}
	public static HashMap<String, MP3> getSongsMap()
	{
		return songsMap;
	}
	public static boolean isEmpty()
	{
		return songsMap.isEmpty();
	}
	public static String nextSong()
	{
		if (playing && !songsMap.isEmpty())
		{
			stop(currentSong);
			if ((currentSong + 1) < songsMap.size())
				currentSong++;
			else
				currentSong = 0;
			start(currentSong);
			return songsIntMap.get(currentSong);
		}
		return "";
	}
	public static void pause()
	{
		songsMap.get(songsIntMap.get(currentSong)).pause();
		playing = false;
	}
	public static String previousSong()
	{
		if (playing && !songsMap.isEmpty())
		{
			stop(currentSong);
			if (currentSong > 0)
				currentSong--;
			else
				currentSong = songsMap.size() - 1;
			start(currentSong);
			return songsIntMap.get(currentSong);
		}
		return "";
	}
	public static void resume()
	{
		songsMap.get(songsIntMap.get(currentSong)).resume();
		playing = true;
	}
	public static void setCurrentSong(String song)
	{
		for (int i = 0; i < songsIntMap.size(); i++)
			if (song.equals(songsIntMap.get(i)))
			{
				currentSong = i;
				return;
			}
	}
	public static String start(int s)
	{
		if (playing)
		{
			songsMap.get(songsIntMap.get(s)).play();
			currentSong = s;
		}
		else
			resume();
		return songsIntMap.get(s);
	}
	public static void stop(int level)
	{
		songsMap.get(songsIntMap.get(level)).close();
	}
	public static void stop(String song)
	{
		songsMap.get(song).close();
	}
	public static void stopAll()
	{
		for (String m : songsIntMap)
		{
			songsMap.get(m).close();
			songsMap.remove(m);
		}
		songsIntMap.removeAll(songsIntMap);
	}
}
