package mp3;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class ImageProvider
{
	private static ImageIcon play2;
	private static ImageIcon play1;
	private static ImageIcon stop2;
	private static ImageIcon stop1;
	private static ImageIcon pause2;
	private static ImageIcon pause1;
	private static ImageIcon next2;
	private static ImageIcon next1;
	private static ImageIcon previous1;
	private static ImageIcon previous2;
	private static ImageIcon close1;
	private static ImageIcon close2;
	private static ImageIcon folder1;
	private static ImageIcon folder2;
	private static ImageIcon pgDown1;
	private static ImageIcon pgDown2;
	private static Image iconSong;
	static
	{
		try
		{
			play1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("play.png")));
			play2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("play1.png")));
			iconSong = ImageIO.read(ImageProvider.class.getClassLoader().getResource("play1.png"));
			pgDown1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("pgDown.png")));
			pgDown2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("pgDown1.png")));
			stop1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("stop.png")));
			stop2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("stop1.png")));
			pause1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("pause.png")));
			pause2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("pause1.png")));
			previous1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("previous.png")));
			previous2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("previous1.png")));
			next1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("next.png")));
			next2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("next1.png")));
			folder1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("folder.png")));
			folder2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("folder1.png")));
			close1 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("close.png")));
			close2 = new ImageIcon(
					ImageIO.read(ImageProvider.class.getClassLoader().getResource("close1.png")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static ImageIcon getClose1()
	{
		return close1;
	}
	public static ImageIcon getClose2()
	{
		return close2;
	}
	public static ImageIcon getFolder1()
	{
		return folder1;
	}
	public static ImageIcon getFolder2()
	{
		return folder2;
	}
	public static Image getIconSong()
	{
		return iconSong;
	}
	public static ImageIcon getNext1()
	{
		return next1;
	}
	public static ImageIcon getNext2()
	{
		return next2;
	}
	public static ImageIcon getPause1()
	{
		return pause1;
	}
	public static ImageIcon getPause2()
	{
		return pause2;
	}
	public static ImageIcon getPgDown1()
	{
		return pgDown1;
	}
	public static ImageIcon getPgDown2()
	{
		return pgDown2;
	}
	public static ImageIcon getPlay1()
	{
		return play1;
	}
	public static ImageIcon getPlay2()
	{
		return play2;
	}
	public static ImageIcon getPrevious1()
	{
		return previous1;
	}
	public static ImageIcon getPrevious2()
	{
		return previous2;
	}
	public static ImageIcon getStop1()
	{
		return stop1;
	}
	public static ImageIcon getStop2()
	{
		return stop2;
	}
}
