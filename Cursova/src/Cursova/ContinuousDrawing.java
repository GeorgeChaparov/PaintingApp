package Cursova;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class ContinuousDrawing extends Figure {

	private ArrayList<Line> segments = new ArrayList<Line>();
	
	private int pixselsToSkip = 1; 
	
	private Vector2 lastPosition = new Vector2();
	
	private Line currentSegment = null;
	
	public Vector2 GetLastPosition() 
	{
		return lastPosition;
	}
	
	@Override
	public void SetStartPosition(Vector2 value) 
	{
		startPoint.x = value.x;
		startPoint.y = value.y;
		
		if (segments.isEmpty() && currentSegment != null)
		{
			currentSegment.SetStartPosition(value);
			SetLastPosition(value);
		}
	}
	
	public void SetLastPosition(Vector2 value)
	{
		lastPosition.x = value.x;
		lastPosition.y = value.y;
	}
	
	public ContinuousDrawing()
	{		
		
	}
	
	public ContinuousDrawing(Vector2 _startPoint)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;
		
		lastPosition.x = _startPoint.x;
		lastPosition.y = _startPoint.y;
		
		endPoint.x = _startPoint.x;
		endPoint.y = _startPoint.y;
	}
	
	public ContinuousDrawing(Vector2 _startPoint, int _pixselsToSkip)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;		
		
		lastPosition.x = _startPoint.x;
		lastPosition.y = _startPoint.y;
		
		endPoint.x = _startPoint.x;
		endPoint.y = _startPoint.y;
		
		pixselsToSkip = _pixselsToSkip;
	}
	
	public ContinuousDrawing(Vector2 _startPoint, Color _color , int _pixselsToSkip)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;

		lastPosition.x = _startPoint.x;
		lastPosition.y = _startPoint.y;
		
		endPoint.x = _startPoint.x;
		endPoint.y = _startPoint.y;
		
		pixselsToSkip = _pixselsToSkip;
		
		color = _color;
	}
	
	public ContinuousDrawing(Vector2 _startPoint, Color _color)
	{		
		startPoint.x = _startPoint.x;
		startPoint.y = _startPoint.y;

		lastPosition.x = _startPoint.x;
		lastPosition.y = _startPoint.y;
		
		endPoint.x = _startPoint.x;
		endPoint.y = _startPoint.y;
		
		color = _color;
	}
	
	public ContinuousDrawing(int startPointX, int startPointY, int endPointX, int endPointY)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		lastPosition.x = startPointX;
		lastPosition.y = startPointY;
		
		endPoint.x = startPointX;
		endPoint.y = startPointY;
	}
	
	public ContinuousDrawing(int startPointX, int startPointY, int _pixselsToSkip)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;

		lastPosition.x = startPointX;
		lastPosition.y = startPointY;
		
		endPoint.x = startPointX;
		endPoint.y = startPointY;
		
		pixselsToSkip = _pixselsToSkip;
	}
	
	public ContinuousDrawing(int startPointX, int startPointY, Color _color)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		lastPosition.x = startPointX;
		lastPosition.y = startPointY;
		
		endPoint.x = startPointX;
		endPoint.y = startPointY;
		
		color = _color;
	}
	
	public ContinuousDrawing(int startPointX, int startPointY, Color _color, int _pixselsToSkip)
	{				
		startPoint.x = startPointX;
		startPoint.y = startPointY;
		
		lastPosition.x = startPointX;
		lastPosition.y = startPointY;
		
		endPoint.x = startPointX;
		endPoint.y = startPointY;
		
		color = _color;
		
		pixselsToSkip = _pixselsToSkip;
	}
	
	
	public void CreateContinuousDrawing(Graphics g) 
	{
		Vector2 buffPoint = new Vector2(lastPosition.x - endPoint.x, lastPosition.y - endPoint.y);
		
		if (currentSegment == null) 
		{
			currentSegment = new Line(lastPosition, endPoint, color);
			currentSegment.DrawFigure(g);
		}
		else 
		{
			if (Math.abs(buffPoint.x) > pixselsToSkip || Math.abs(buffPoint.y) > pixselsToSkip)
			{
				segments.add(currentSegment);
				
				SetLastPosition(currentSegment.endPoint);
				
				currentSegment = null;
			}
			else 
			{
				currentSegment.SetEndPosition(endPoint);
				currentSegment.DrawFigure(g);
			}
		}
	}
	
	@Override
	public void DrawFigure(Graphics g) 
	{
		CreateContinuousDrawing(g);
		for (int i = 0; i < segments.size(); i++) 
		{
			segments.get(i).DrawFigure(g);
		}
	}
}
