package mp3;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
public class DragMouseListener extends MouseInputAdapter
{
	Point location;
	MouseEvent pressed;
	@Override
	public void mouseDragged(MouseEvent me)
	{
		Component component = me.getComponent();
		this.location = component.getLocation(this.location);
		int x = (this.location.x - this.pressed.getX()) + me.getX();
		int y = (this.location.y - this.pressed.getY()) + me.getY();
		component.setLocation(x, y);
	}
	@Override
	public void mousePressed(MouseEvent me)
	{
		this.pressed = me;
	}
}
