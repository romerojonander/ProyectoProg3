package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import framework.GameObject;
import framework.ObjectId;
/**
 * Clase bala, que dispara el personaje
 * @author Pablosensi
 *
 */
public class Bullet extends GameObject {
	volatile BufferedImage sprite;
	public Bullet(float x, float y, ObjectId id, boolean right) {
		super(x, y, id);
		if(right){
			try {
				sprite = ImageIO.read(new File("resources\\bullet.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			velX = 7;
		}

		else{
			try {
				sprite = ImageIO.read(new File("resources\\bullet2.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			velX= -7;
		}

		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(ArrayList<GameObject> object) {
		x+=velX;
		y+=velY;
		Collision(object);
		for(GameObject gameobject: object){
			if(gameobject instanceof Player){

			}
		}
		// TODO Auto-generated method stub

	}

	private void Collision(ArrayList<GameObject> object){
//		for(int i =0; i<object.size(); i++){
//			GameObject TempObject = object.get(i);
//			if(TempObject instanceof Enemigos)
//				
//				if(this.getBounds().intersects(((Enemigos) TempObject).getBounds()) || this.getBounds().intersects(((Enemigos) TempObject).getBounds())){
//					for(int e =0; e<object.size(); e++){
//						GameObject TempObject1 = object.get(e);
//						if(TempObject.equals(this))
//					object.remove(e);
//
//				}
//		}}
	}




	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(sprite, (int)x, (int)y, null);

	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x, (int)y, sprite.getWidth(), sprite.getHeight());
	}

}
