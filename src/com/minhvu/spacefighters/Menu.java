package com.minhvu.spacefighters;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Menu
{
	private Rectangle playbutton;
	private Rectangle helpbutton;
	private Rectangle quitbutton;
	private Rectangle backbutton;
	
	public Menu()
	{
		playbutton = new Rectangle((Game.getInstance().getWidth() - 600) / 2, 700, 600, 100);
		helpbutton = new Rectangle((Game.getInstance().getWidth() - 600) / 2, 825, 600, 100);
		quitbutton = new Rectangle((Game.getInstance().getWidth() - 600) / 2, 950, 600, 100);
		backbutton = new Rectangle((Game.getInstance().getWidth() - 600) / 2, 950, 600, 100);
	}
	
	public void paint(Graphics2D g2d)
	{
		Font titlefont = new Font("arial", Font.BOLD, 500);
		Font subtitlefont = new Font("arial", Font.BOLD, 300);
		
		g2d.setFont(titlefont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("SPACE", (int) ((Game.getInstance().getWidth() - g2d.getFontMetrics().stringWidth("SPACE")) / 2), 400);
		
		g2d.setFont(subtitlefont);
		g2d.drawString("FIGHTERS", (int) ((Game.getInstance().getWidth() - g2d.getFontMetrics().stringWidth("FIGHTERS")) / 2), 665);

		Font buttonfont = new Font("arial", Font.BOLD, 100);
		g2d.setFont(buttonfont);
		
		if (Game.getInstance().getState().equals(Game.STATE.MENU))
		{
			g2d.setColor(Color.WHITE);
			g2d.fill(playbutton);
			g2d.fill(helpbutton);
			g2d.fill(quitbutton);
			
			g2d.draw(playbutton);
			g2d.draw(helpbutton);
			g2d.draw(quitbutton);
			
			g2d.setColor(Color.BLACK);
			g2d.drawString("PLAY", playbutton.x + (playbutton.width - g2d.getFontMetrics().stringWidth("PLAY")) / 2, playbutton.y + 85);
			g2d.drawString("HELP", helpbutton.x + (helpbutton.width - g2d.getFontMetrics().stringWidth("HELP")) / 2, helpbutton.y + 85);
			g2d.drawString("QUIT", quitbutton.x + (quitbutton.width - g2d.getFontMetrics().stringWidth("QUIT")) / 2, quitbutton.y + 85);
		}
		
		else if (Game.getInstance().getState().equals(Game.STATE.HELP))
		{
			Font helpfont = new Font("arial", Font.BOLD, 20);
			
			String helptextad = "Movement: Arrow Keys To Move";
			String helptextlr = "Space: Fires Missile";
			String helpobjective = "Objective: Destroy Enemies, Stay Alive";
			
			g2d.setColor(Color.WHITE);
			g2d.fill(backbutton);
			g2d.draw(backbutton);

			g2d.setFont(helpfont);
			g2d.drawString(helptextad, (int) ((Game.getInstance().getWidth() - g2d.getFontMetrics().stringWidth(helptextad)) / 2), 750);
			g2d.drawString(helptextlr, (int) ((Game.getInstance().getWidth() - g2d.getFontMetrics().stringWidth(helptextlr)) / 2), 800);
			g2d.drawString(helpobjective, (int) ((Game.getInstance().getWidth() - g2d.getFontMetrics().stringWidth(helpobjective)) / 2), 850);

			g2d.setFont(buttonfont);
			g2d.setColor(Color.BLACK);
			g2d.drawString("BACK", backbutton.x + (backbutton.width - g2d.getFontMetrics().stringWidth("BACK")) / 2, backbutton.y + 85);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		Point location = new Point(e.getX(), e.getY());
		
		if (Game.getInstance().getState().equals(Game.STATE.MENU))
		{
			if (playbutton.contains(location))
			{	
				Game.getInstance().setState(Game.STATE.GAME);
			}
			
			else if (helpbutton.contains(location))
			{
				Game.getInstance().setState(Game.STATE.HELP);
			}
			
			else if (quitbutton.contains(location))
			{
				System.exit(1);
			}
		}
		
		else if (Game.getInstance().getState().equals(Game.STATE.HELP))
		{
			if (backbutton.contains(location))
			{
				Game.getInstance().setState(Game.STATE.MENU);
			}
		}
	}
}
