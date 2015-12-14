package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import sprite.player.SpriteListCreator;
import framework.GameObject;
import framework.ObjectId;

public class Player extends GameObject {
	private float gravity = 0.5f;
	private BufferedImage sprite;
	private ArrayList<BufferedImage> currentAnim = new ArrayList<>();
	private final String default_anim = "running_right";
	private HashMap<String, ArrayList<BufferedImage>> spriteHash = new HashMap<String, ArrayList<BufferedImage>>();
	public Player(float x, float y, ObjectId id) {
		super(x, y, id);
		facingRight = true;
		spriteHash = SpriteListCreator.SpriteHashCreator(new File("resources/Player"));
		currentAnim = spriteHash.get(default_anim);
		sprite = currentAnim.get(0);
		// TODO Auto-generated constructor stub
	}
	
	private void Collision(ArrayList<GameObject> object){
		for(GameObject gameobject : object){
			if(gameobject instanceof Block){
				if(getBounds().intersects(gameobject.getBounds())){
					y = gameobject.getY()-sprite.getHeight();
					falling =false;
					velY=0;
				}
			}
		}
	}
	@Override
	public void tick(ArrayList<GameObject> object) {
		Collision(object);
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		if(falling || jumping)
			velY+=gravity;
		if(movingRight){
			facingRight=true;
			sprite = spriteHash.get("running_right").get(0);
			velX= 5;
		}
		if(movingLeft){
			facingRight = false;
			sprite = spriteHash.get("running_left").get(0);
			velX= -5;
		}
		if(!(movingRight || movingLeft))
			velX =0;
		if(jumping && !falling){
			velY = -7;
			jumping = false;
			falling = true;
		}
		if(shoot){
			
		}
			
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(sprite, (int)x, (int)y, null);

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int) y, sprite.getWidth(), sprite.getHeight());
	}

}