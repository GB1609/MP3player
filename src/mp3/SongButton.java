package mp3;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
public class SongButton extends JButton
{
	private static final long serialVersionUID = 1;
	private boolean evidence;
	private Font font;
	private MouseListener passOn;
	public SongButton(String name, MediaFrame frame, ActionListener a)
	{
		super(name);
		this.passOn = new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
			}
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				if (SongButton.this.evidence)
					SongButton.this.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
				if (SongButton.this.evidence)
					SongButton.this.setContentAreaFilled(false);
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				SongButton.this.setContentAreaFilled(false);
			}
		};
		this.addActionListener(a);
		this.setBackground(Color.BLUE.darker().darker());
		this.evidence = true;
		this.setContentAreaFilled(false);
		this.setForeground(Color.WHITE);
		this.setBorderPainted(false);
		this.font = new Font("Consolas", 0, 14);
		this.setFont(this.font);
		this.setFocusPainted(false);
		this.addMouseListener(this.passOn);
	}
	public MouseListener getPassOn()
	{
		return this.passOn;
	}
	public void setEvidence(boolean b)
	{
		this.evidence = false;
	}
}
