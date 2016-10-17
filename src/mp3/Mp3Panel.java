package mp3;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class Mp3Panel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private boolean inPause;
	private ModifiedButton next;
	private ModifiedButton previous;
	private ModifiedButton play;
	private ModifiedButton stop;
	private ModifiedButton chooseFolder;
	private ModifiedButton close;
	private ModifiedButton pgDown;
	private JFileChooser chooser;
	private JPanel underPanel;
	private JPanel onPanel;
	private TrackListPanel trackPanel;
	private boolean started;
	private JLabel currentSong;
	private final int sum = 40;
	private boolean tracksPresents;
	public Mp3Panel(MediaFrame mediaFrame)
	{
		this.started = false;
		this.tracksPresents = false;
		this.setLayout(new BorderLayout());
		this.setSize(708, 525);
		this.setBackground(Color.BLUE.brighter().brighter());
		this.setBorder(new LineBorder(Color.BLUE.darker().darker(), 5));
		this.requestFocus();
		this.onPanel = new JPanel();
		this.onPanel.setSize(this.getWidth(), 125 - this.sum);
		this.onPanel.setBackground(this.getBackground());
		this.onPanel.setLayout(new FlowLayout());
		this.underPanel = new JPanel();
		this.underPanel.setSize(this.getWidth(), this.sum);
		this.underPanel.setLayout(new BorderLayout());
		this.underPanel.setBackground(this.getBackground());
		this.currentSong = new JLabel("");
		this.currentSong.setForeground(Color.WHITE);
		this.currentSong.setFont(new Font("Consolas", 0, 15));
		this.requestFocusInWindow();
		this.next = new ModifiedButton("", ImageProvider.getNext1(), ImageProvider.getNext2(),
				mediaFrame, e -> this.changeSongN());
		this.previous = new ModifiedButton("", ImageProvider.getPrevious1(),
				ImageProvider.getPrevious2(), mediaFrame, e -> this.changeSongP());
		this.play = new ModifiedButton("", ImageProvider.getPlay1(), ImageProvider.getPlay2(),
				mediaFrame, e -> this.startOption());
		this.chooseFolder = new ModifiedButton("", ImageProvider.getFolder1(),
				ImageProvider.getFolder2(), mediaFrame, e -> this.selectFolder());
		this.close = new ModifiedButton("", ImageProvider.getClose1(), ImageProvider.getClose2(),
				mediaFrame, e -> System.exit(0));
		this.stop = new ModifiedButton("", ImageProvider.getStop1(), ImageProvider.getStop2(),
				mediaFrame, e -> this.stopall());
		this.pgDown = new ModifiedButton("", ImageProvider.getPgDown1(), ImageProvider.getPgDown2(),
				mediaFrame, e -> this.createListPanel(mediaFrame));
		this.onPanel.add(this.previous);
		this.onPanel.add(this.play);
		this.onPanel.add(this.stop);
		this.onPanel.add(this.next);
		this.onPanel.add(this.chooseFolder);
		this.onPanel.add(this.close);
		this.underPanel.add(this.currentSong, BorderLayout.WEST);
		this.underPanel.add(this.pgDown, BorderLayout.EAST);
		this.add(this.onPanel, BorderLayout.NORTH);
		this.add(this.underPanel, BorderLayout.SOUTH);
		this.chooser = new JFileChooser();
		this.chooser.setCurrentDirectory(new java.io.File("."));
		this.chooser.setDialogTitle("Seleziona la tua cartella musicale");
		this.chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.chooser.setAcceptAllFileFilterUsed(false);
		this.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(final KeyEvent e)
			{
				switch (e.getKeyCode())
				{
				case KeyEvent.VK_P:
					MediaPlayer.previousSong();
					break;
				case KeyEvent.VK_N:
					MediaPlayer.nextSong();
					break;
				case KeyEvent.VK_M:
					if (mediaFrame.getAudio())
						MediaPlayer.pause();
					else
						MediaPlayer.resume();
					mediaFrame.setAudio(!mediaFrame.getAudio());
					break;
				case KeyEvent.VK_SPACE:
					if (mediaFrame.getAudio())
						MediaPlayer.pause();
					else
						MediaPlayer.resume();
					mediaFrame.setAudio(!mediaFrame.getAudio());
					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
				default:
					break;
				}
			}
		});
	}
	private void changeSongN()
	{
		this.currentSong.setText(MediaPlayer.nextSong());
	}
	private void changeSongP()
	{
		this.currentSong.setText(MediaPlayer.previousSong());
	}
	private void createListPanel(MediaFrame frame)
	{
		if (this.started)
		{
			if (this.tracksPresents)
			{
				this.remove(this.trackPanel);
				this.trackPanel = null;
				frame.setSize(708, 125);
			}
			else
			{
				this.trackPanel = new TrackListPanel(frame, this.currentSong);
				this.trackPanel.setSize(frame.getWidth(), 400);
				this.trackPanel.setLayout(null);
				this.trackPanel.setVisible(true);
				this.add(this.trackPanel, BorderLayout.CENTER);
				frame.setSize(708, 525);
			}
			frame.setContentPane(this);
			frame.revalidate();
			this.repaint();
			this.tracksPresents = !this.tracksPresents;
		}
	}
	private void startOption()
	{
		if (MediaPlayer.isEmpty())
			this.selectFolder();
		else
		{
			if (this.inPause)
			{
				MediaPlayer.resume();
				this.play.setIcon(ImageProvider.getPause1(), ImageProvider.getPause2());
			}
			else
			{
				MediaPlayer.pause();
				this.play.setIcon(ImageProvider.getPlay1(), ImageProvider.getPlay2());
			}
			this.inPause = !this.inPause;
		}
	}
	private void stopall()
	{
		this.started = false;
		MediaPlayer.stopAll();
		this.currentSong.setText("");
	}
	public void selectFolder()
	{
		if (!this.started)
		{
			File name = null;
			if (this.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				name = new File(this.chooser.getSelectedFile().toString());
				if (name.exists())
					if (name.isDirectory())
					{
						String directory[] = name.list();
						for (String songName : directory)
							if (songName.contains(".mp3"))
								MediaPlayer.addSong(name.getPath() + "\\" + songName, songName);
						this.play.setIcon(ImageProvider.getPause1(), ImageProvider.getPause2());
						this.currentSong.setText(MediaPlayer.start(0));
						this.repaint();
						this.started = true;
					}
			}
		}
	}
}
