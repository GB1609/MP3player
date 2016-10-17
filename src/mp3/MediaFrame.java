package mp3;
import javax.swing.JFrame;
public class MediaFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Mp3Panel mp3;
	private DragMouseListener drag;
	private boolean audio;
	public MediaFrame()
	{
		super();
		this.audio = true;
		this.setIconImage(ImageProvider.getIconSong());
		this.setTitle("Mp3Tester");
		this.setSize(708, 125);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setLayout(null);
		this.drag = new DragMouseListener();
		this.addMouseListener(this.drag);
		this.addMouseMotionListener(this.drag);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.switchPanel();
		this.setVisible(true);
	}
	public boolean getAudio()
	{
		return this.audio;
	}
	public void setAudio(boolean b)
	{
		this.audio = b;
	}
	public void switchPanel()
	{
		this.mp3 = new Mp3Panel(this);
		this.setContentPane(this.mp3);
		this.mp3.requestFocus();
		this.mp3.setFocusable(true);
		this.revalidate();
	}
}
