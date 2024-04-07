package Cursova;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;

public class Canvas extends Panel{
	
	private long lastTimeCheckForTime = 0;
	
	private Vector2 startPosition = new Vector2();
	private Vector2 endPosition = new Vector2();
	
	ArrayList<IDrawable> arrList = new ArrayList<IDrawable>();
	
	ArrayList<IDrawable> buffList = new ArrayList<IDrawable>();
	
	private FigureType figure = FigureType.Unsellected;
	
	IDrawable currentFigure = null;
	
	JColorChooser pickedColor;
	
	private boolean ShouldCreateFigure = false;
	
	public boolean HavePrev()
	{	
		return !arrList.isEmpty();
	}
	
	public boolean HaveNext()
	{	
		return !buffList.isEmpty();
	}
	
	public Vector2 GetStartPosition()
	{	
		return startPosition;
	}
	
	public Vector2 GetEndPosition()
	{
		return endPosition;
	}
	
	public FigureType GetFigure()
	{
		return figure;
	}
	
	public void SetFigure(FigureType value)
	{
		figure = value;
	}
	
	public void SetPickedColor(JColorChooser value)
	{
		pickedColor = value;
	}
	
	public IDrawable GetCurrentFigure()
	{
		return currentFigure;
	}
	
	public void SetCurrentFigure(IDrawable value)
	{
		currentFigure = value;
	}
	
	public ArrayList<IDrawable> GetAllFigures()
	{
		return arrList;
	}
	
	public Canvas()
	{
		setBackground(Color.WHITE);
		setVisible(true);
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {

			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
				if (System.nanoTime() - lastTimeCheckForTime > 10000000) {
					endPosition.x = e.getX();
					endPosition.y = e.getY();
					repaint();
					
					lastTimeCheckForTime = System.nanoTime();
				}
				
				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				arrList.add(currentFigure);
				currentFigure = null;			
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				buffList.clear();
				
				startPosition = new Vector2(e.getX(), e.getY());
				endPosition = new Vector2(e.getX(), e.getY());
				
				if (currentFigure != null) 
				{										
					currentFigure.SetStartPosition(startPosition);
				}				
				ShouldCreateFigure = true;
				repaint();			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void GetPrev() 
	{		
		buffList.add(arrList.get(arrList.size() - 1));
		
		arrList.remove(arrList.size() - 1);
		ShouldCreateFigure = false;
		repaint();
	}
	
	public void GetNext()
	{
		arrList.add(buffList.get(buffList.size() - 1));
		
		buffList.remove(buffList.size() - 1);
		ShouldCreateFigure = false;
		repaint();	
	}
	
	@Override
	public void paint(Graphics g)
	{
		for (int i = 0; i < arrList.size(); i++) 
		{
			arrList.get(i).DrawFigure(g);
		}

		if (currentFigure == null) 
		{	
			if (ShouldCreateFigure)
			{
				switch (figure) 
				{ 
				case Line : 							
						currentFigure = new Line(startPosition, endPosition, pickedColor.getColor());				
					break;				
					
				case UnfilledOval : 
						currentFigure = new UnfilledOval(startPosition, endPosition, pickedColor.getColor());
					break;	
									
				case FilledRectangle : 
						currentFigure = new FilledRectangle(startPosition, endPosition, pickedColor.getColor());
					break;	
					
				case Unsellected : 
						currentFigure = new ContinuousDrawing(startPosition, pickedColor.getColor(), 30);
				break;	
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + figure);
				}
				
				currentFigure.DrawFigure(g);
			}
			
		}
		else
		{
			Figure bufferFigure = (Figure)currentFigure;
			
			if (bufferFigure.GetColor() !=  pickedColor.getColor()) 
			{
				currentFigure = null;
			}
			else 
			{
				currentFigure.SetEndPosition(endPosition);
				currentFigure.DrawFigure(g);
			}
		}
	}
}
