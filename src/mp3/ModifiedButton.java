package mp3;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class ModifiedButton extends JButton
{
	private static final long serialVersionUID = 1;
	private MouseListener passOn;
	public ModifiedButton(String name, ImageIcon icon1, ImageIcon icon2, MediaFrame frame,
			ActionListener a)
	{
		super(icon1);
		this.passOn = new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
			}
			@Override
			public void mouseEntered(MouseEvent arg0)
			{
			}
			@Override
			public void mouseExited(MouseEvent arg0)
			{
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}
		};
		this.addActionListener(a);
		this.setBackground(Color.YELLOW);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setRolloverIcon(icon2);
		this.setSize(icon1.getIconWidth(), icon2.getIconHeight());
		this.addMouseListener(this.passOn);
	}
	public MouseListener getPassOn()
	{
		return this.passOn;
	}
	public void setIcon(ImageIcon image1, ImageIcon image2)
	{
		this.setIcon(image1);
		this.setRolloverIcon(image2);
	}
}
