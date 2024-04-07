package Cursova;

import java.awt.Color;
import java.awt.Graphics;

public class Figure implements IDrawable 
{

	protected Vector2 startPoint = new Vector2();
	protected Vector2 endPoint = new Vector2();
	
	protected Color color = Color.BLACK;
	
	public Color GetColor() 
	{
		return color;
	}
	
	public void SetColor(Color value)
	{
		color = value;
	}
	
	@Override
	public Vector2 GetStartPosition() 
	{
		return startPoint;		
	}
	
	@Override
	public void SetStartPosition(Vector2 value) 
	{
		startPoint.x = value.x;
		startPoint.y = value.y;
	}
	
	@Override
	public Vector2 GetEndPosition() 
	{
		return endPoint;		
	}
	
	@Override
	public void SetEndPosition(Vector2 value) 
	{
		endPoint.x = value.x;
		endPoint.y = value.y;
	}
	
	@Override
	public void DrawFigure(Graphics g) 
	{
		// TODO Auto-generated method stub
	}


}
