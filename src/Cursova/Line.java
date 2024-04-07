package Cursova;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Figure
{
	public Line()
	{		
		
	}
	
	public Line(Vector2 _startPoint, Vector2 _endPoint)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;
		
		endPoint.x = _endPoint.x;
		endPoint.y = _endPoint.y;
	}
	
	public Line(Vector2 _startPoint, Vector2 _endPoint, Color _color)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;
		
		endPoint.x = _endPoint.x;
		endPoint.y = _endPoint.y;
		
		color = _color;
	}
	
	public Line(int startPointX, int startPointY, int endPointX, int endPointY)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		endPoint.x = endPointX;
		endPoint.y = endPointY;
	}
	
	public Line(int startPointX, int startPointY, int endPointX, int endPointY, Color _color)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		endPoint.x = endPointX;
		endPoint.y = endPointY;
		
		color = _color;
	}
	
	@Override
	public void DrawFigure(Graphics g) 
	{
		g.setColor(color);
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
}
