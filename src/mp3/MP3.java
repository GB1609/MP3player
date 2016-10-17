package mp3;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.player.Player;
public class MP3
{
	private String filename;
	private Player player;
	private InputStream in;
	private int pausePosition;
	private long totSong;
	private boolean life;
	public MP3(String path)
	{
		this.filename = path;
	}
	public void close()
	{
		if (this.in != null)
		{
			this.life = false;
			this.player.close();
		}
	}
	public void pause()
	{
		if (this.player != null)
		{
			try
			{
				this.pausePosition = this.in.available();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			this.close();
		}
	}
	public void play()
	{
		try
		{
			this.life = true;
			this.in = new FileInputStream(this.filename);
			this.player = new Player(this.in);
			this.totSong = this.in.available();
		}
		catch (Exception e)
		{
			System.out.println("Problem playing file " + this.filename);
			System.out.println(e);
		}
		new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					MP3.this.player.play();
					while (!MP3.this.player.isComplete() && MP3.this.life)
					{
					}
					if (MP3.this.life)
						MediaPlayer.nextSong();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
	public void resume()
	{
		try
		{
			this.life = true;
			this.in = new FileInputStream(this.filename);
			this.player = new Player(this.in);
			this.totSong = this.in.available();
			this.in.skip(this.totSong - this.pausePosition);
			this.pausePosition = 0;
		}
		catch (Exception e)
		{
			System.out.println("Problem playing file " + this.filename);
			System.out.println(e);
		}
		new Thread()
		{
			@Override
			public void run()
			{
				try
				{
					MP3.this.player.play();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}
}