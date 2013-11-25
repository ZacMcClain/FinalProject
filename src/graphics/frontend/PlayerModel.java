package graphics.frontend;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

import graphics.Texture;
import graphics.quadrangle.Dynamic;
import graphics.quadrangle.Vec10quad;
import util.Rectangle;

public class PlayerModel extends Dynamic{
	public static Texture sprite;
	public static String spriteURL = "resources/schmile.png";
	
	public PlayerModel(Rectangle rect, float[] tint) {
		super(rect, tint);
		sprite = new Texture();
		sprite.load(spriteURL);
		
	}

	@Override
	public void bindTexture() {
		GL13.glActiveTexture(Texture.textureUnit);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, sprite.textureID);
	}
}