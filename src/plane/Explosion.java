package plane;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * ��ը��
 * @author Administrator
 *
 */
public class Explosion {
	
	public static Image image[] = {
			new Image("image/bigExplosion.gif"),
			new Image("image/explosion.gif")
	};
	/**
	 * �ڣ�x,y����������ը
	 * @param x ����x
	 * @param y ����y
	 * @param i ��ը����
	 */
	public static void play(double x,double y,int i){
		ImageView imageView = new ImageView(image[i]);
		imageView.setX(x);
		imageView.setY(y);
		GameFrame.pane.getChildren().add(imageView);
	}
	
}
