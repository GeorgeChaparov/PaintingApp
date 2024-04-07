package Cursova;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JColorChooser;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JColorChooser colorChooser;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	public static void main(String[] args) 
	{
		MainFrame frame = new MainFrame();
	}

	public MainFrame() 
	{
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel toolPanel = new JPanel();
		toolPanel.setBackground(new Color(240, 240, 240));
		contentPane.add(toolPanel, BorderLayout.WEST);
		toolPanel.setLayout(new BorderLayout(0, 0));
		
		String[] values = new String[] {"Line", "Unfilled oval", "Filled rectangle", "Unsellected"};
		
		JPanel panel = new JPanel();
		toolPanel.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
				
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 255, 255));
		contentPane.add(canvas, BorderLayout.CENTER);
		canvas.setBackground(Color.gray);
		
		canvas.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				btnNewButton_1.setEnabled(canvas.HavePrev());
				btnNewButton.setEnabled(canvas.HaveNext());
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnNewButton = new JButton("Next");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				btnNewButton_1.setEnabled(true);
				
				canvas.GetNext();
				
				if (!canvas.HaveNext()) {
					btnNewButton.setEnabled(false);
				}
			}
		});
		
		btnNewButton_1 = new JButton("Prev");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton.setEnabled(true);
				
				canvas.GetPrev();
				
				if (!canvas.HavePrev()) {
					btnNewButton_1.setEnabled(false);
				}
			}
		});
		
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
		
		Button button = new Button("Change Color");
		panel.add(button);
		button.setSize(10, 10);
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (colorChooser.isVisible()) 
				{
					colorChooser.setVisible(false);
				}
				else 
				{
					colorChooser.setVisible(true);
				}
				
			}
		});
		
		colorChooser = new JColorChooser(Color.BLACK);
		
		colorChooser.setVisible(false);
		getContentPane().add(colorChooser, BorderLayout.SOUTH);
		
		canvas.pickedColor = colorChooser;
		
		Button button_1 = new Button("Show num items in list");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int br=0;
				for (int i = 0; i < canvas.GetAllFigures().size(); i++) {
					br++;
				}
				
				System.out.println(br);
			}
		});
		panel.add(button_1);
		
		JList<String> list = new JList<String>(values);
		list.setSelectedIndex(3);

		list.setToolTipText("");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		toolPanel.add(list, BorderLayout.NORTH);
		
		list.addListSelectionListener(new ListSelectionListener()
				{
					@Override
					public void valueChanged(ListSelectionEvent e) {
					
						if (canvas.GetCurrentFigure() != null) {
							canvas.SetCurrentFigure(null);
						}
						
						switch (list.getSelectedValue()) {
						case "Line":
							canvas.SetFigure(FigureType.Line);
							break;
							
						case "Unfilled oval":
							canvas.SetFigure(FigureType.UnfilledOval);
							break;
							
						case "Filled rectangle":
							canvas.SetFigure(FigureType.FilledRectangle);
							break;
							
						case "Unsellected":
							canvas.SetFigure(FigureType.Unsellected);
							break;
							
						default:
							break;
						}
					}
			
				});
		
		setVisible(true);
	}
}
