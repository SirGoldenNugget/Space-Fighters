package com.minhvu.spacefighters;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Star
{
	private Point location;
	private final int speed = 3;

	private static BufferedImage image = Sprite.getSprite(1056, 238, 32, 32);
	
	public Star()
	{
		location = new Point((int) (Math.random() * (Game.getInstance().getWidth() - image.getWidth(Game.getInstance()))), (int) (Math.random() * (Game.getInstance().getHeight() - image.getHeight(Game.getInstance()))));
	
		for (Star star : Game.getInstance().getStars())
		{
			while (getBounds().intersects(star.getBounds()))
			{
				location = new Point((int) (Math.random() * (Game.getInstance().getWidth() - image.getWidth(Game.getInstance()))), (int) (Math.random() * (Game.getInstance().getHeight() - image.getHeight(Game.getInstance()))));
			}
		}
	}
	
	public void paint(Graphics2D g2d)
	{
		g2d.drawImage(image, location.x, location.y, Game.getInstance());
	}
	
	public void move()
	{
		location.y += speed;
		
		if (location.y > Game.getInstance().getHeight())
		{
			location.x = (int) (Math.random() * (Game.getInstance().getWidth() - image.getWidth(Game.getInstance())));
			location.y = (int) (Math.random() * -1000) - image.getWidth(Game.getInstance());
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(location.x, location.y, image.getWidth(Game.getInstance()), image.getHeight(Game.getInstance()));
	}
}
