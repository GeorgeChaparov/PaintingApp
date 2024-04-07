package Cursova;

import java.awt.Graphics;

public interface IDrawable
{
	public abstract void DrawFigure(Graphics g);
	 
	public abstract Vector2 GetStartPosition();
	 
	public abstract void SetStartPosition(Vector2 value);
	 
	public abstract Vector2 GetEndPosition();
	 
	public abstract void SetEndPosition(Vector2 value);
}