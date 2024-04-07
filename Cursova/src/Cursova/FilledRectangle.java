package Cursova;

import java.awt.Color;
import java.awt.Graphics;

public class FilledRectangle extends Figure {

	@Override
	public void SetEndPosition(Vector2 value) 
	{
		endPoint.x = value.x - startPoint.x;
		endPoint.y = value.y - startPoint.y;
	}
	
	public FilledRectangle()
	{		
		
	}
	
	public FilledRectangle(Vector2 _startPoint, Vector2 _endPoint)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;
		
		endPoint.x = _endPoint.x - _startPoint.x;
		endPoint.y = _endPoint.y - _startPoint.y;
	}
	
	public FilledRectangle(Vector2 _startPoint, Vector2 _endPoint, Color _color)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;
		
		endPoint.x = _endPoint.x - _startPoint.x;
		endPoint.y = _endPoint.y - _startPoint.y;
		
		color = _color;
	}
	
	public FilledRectangle(int startPointX, int startPointY, int endPointX, int endPointY)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		endPoint.x = endPointX - startPointX;
		endPoint.y = endPointY - startPointY;
	}
	
	public FilledRectangle(int startPointX, int startPointY, int endPointX, int endPointY, Color _color)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		endPoint.x = endPointX - startPointX;
		endPoint.y = endPointY - startPointY;
		
		color = _color;
	}
	
	@Override
	public void DrawFigure(Graphics g) 
	{
		g.setColor(color);
		g.fillRect(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
}
