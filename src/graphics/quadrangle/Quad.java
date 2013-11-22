package graphics.quadrangle;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

import util.Rectangle;

public abstract class Quad {
	protected Rectangle area;
	protected static int vibo;
	
	protected final static int indexElementCount = Rectangle.elementCount();
	protected int buffluc;
		
	public void render(){
		bindVAO();
		bindVBO();
		bindVIBO();

		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		
		GL11.glDrawElements(GL11.GL_TRIANGLES, indexElementCount, GL11.GL_UNSIGNED_BYTE, 0);

		GL20.glDisableVertexAttribArray(2);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(0);
		
		unbindVIBO();
		unbindVBO();
		unbindVAO();
		
	}
	
	public abstract void move(float deltx, float delty);
	public abstract void remove(); // DO NOT USE// FORWARD IMPLEMENTATION ONLY
	
	public abstract int getStride();
	
	public abstract void setupVAO();
	public void setupVIBO(){
		ByteBuffer indexBuffer = BufferUtils.createByteBuffer(indexElementCount);
		indexBuffer.put(Rectangle.getOrder());
		indexBuffer.flip();
		
		vibo = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vibo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
	}
	public abstract void bindVAO();
	public abstract void unbindVAO();
	
	public abstract void bindVBO();
	public abstract void unbindVBO();
	public abstract void reloadVBO();
	public static void bindVIBO(){
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vibo);
	}
	
	public static void unbindVIBO(){
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		
	}
}