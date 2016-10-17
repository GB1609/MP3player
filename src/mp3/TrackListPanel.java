package mp3;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
public class TrackListPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JScrollPane pane;
	private JPanel tracksPanel;
	public TrackListPanel(MediaFrame frame, JLabel currentSong)
	{
		this.requestFocus();
		this.setSize(frame.getWidth(), 400);
		this.setBackground(Color.BLUE.brighter().brighter());
		this.setLayout(null);
		this.setVisible(true);
		this.setBorder(new LineBorder(Color.BLUE.darker().darker(), 5));
		this.tracksPanel = new JPanel();
		this.tracksPanel.setLayout(new BoxLayout(this.tracksPanel, BoxLayout.Y_AXIS));
		this.tracksPanel.setOpaque(false);
		this.pane = new JScrollPane(this.tracksPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.pane.setOpaque(false);
		this.pane.getViewport().setOpaque(false);
		this.pane.setBounds(0, 0, this.getWidth() - 14, this.getHeight());
		for (String song : MediaPlayer.getSongsMap().keySet())
			this.tracksPanel.add(
					new SongButton(song, frame, e -> this.songSelected(song, currentSong)),
					this.tracksPanel);
		this.add(this.pane);
		this.setBounds(0, 126, frame.getWidth(), 400);
		this.setVisible(true);
	}
	private void songSelected(String song, JLabel songSelected)
	{
		MediaPlayer.stop(songSelected.getText());
		MediaPlayer.setCurrentSong(song);
		MediaPlayer.getSongsMap().get(song).play();
		songSelected.setText(song);
	}
}