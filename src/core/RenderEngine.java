package core;

import graphics.backend.TextureManager;
import graphics.frontend.BackgroundImage;
import graphics.frontend.GuiElement;
import graphics.frontend.Placeable;
import graphics.frontend.PlayerModel;
import graphics.quadrangle.Quad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;


public class RenderEngine {
	public static Quad quads;
	public static PlayerModel dquadStaticHandle;
	public static BackgroundImage squadStaticHandle;
	public static GuiElement guiStaticHandle;
	
	public static int ProgramID;
	public static int fragmentShaderID;
	public static int vertexShaderID;

	
	public static void render(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		squadStaticHandle.render();
		dquadStaticHandle.render();
		guiStaticHandle.render();
	}
	
	public static void setup(){
		TextureManager.setup();
		dquadStaticHandle = new PlayerModel();
		dquadStaticHandle.staticSetup();

		squadStaticHandle = new BackgroundImage();
		squadStaticHandle.staticSetup();
		
		guiStaticHandle = new GuiElement();
		guiStaticHandle.staticSetup();

		initializeShaders();
		initializeProgram();
	}
	
	public static void test(){

		Placeable.setup();
		guiStaticHandle.populate();
	}

	
	
	

	
	@SuppressWarnings("deprecation")
	public static int loadShader(String source, int type){
		int shaderID;
		StringBuilder shader = new StringBuilder();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(source));
			String line;
			while(( line = reader.readLine()) != null){
				shader.append(line).append("\n");
			}
			
			reader.close();
		} catch (IOException e){
			e.printStackTrace();
			System.exit(2);
		}
		
		shaderID = GL20.glCreateShader(type);
		GL20.glShaderSource(shaderID, shader);
		GL20.glCompileShader(shaderID);
		
		System.out.println("Shader ID:" +shaderID + "\nInfo: "+ GL20.glGetShaderInfoLog(shaderID, 1024));
		
		if (GL20.glGetShader(shaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			System.err.println("Could not compile shader.");
			System.exit(-1);
			}
		return shaderID;
	}
	
	public static void initializeShaders(){
		vertexShaderID = loadShader("src/graphics/backend/vertex.glsl", GL20.GL_VERTEX_SHADER);
		fragmentShaderID = loadShader("src/graphics/backend/fragment.glsl", GL20.GL_FRAGMENT_SHADER);
	}
	
	public static void initializeProgram(){
		ProgramID = GL20.glCreateProgram();
		GL20.glAttachShader(ProgramID, vertexShaderID);
		GL20.glAttachShader(ProgramID, fragmentShaderID);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		
		//GL20.glBindAttribLocation(ProgramID, 0, "position");
		//GL20.glBindAttribLocation(ProgramID, 1, "uv");
		//GL20.glBindAttribLocation(ProgramID, 2, "tint");
		
		GL20.glLinkProgram(ProgramID);
		GL20.glValidateProgram(ProgramID);
		GL20.glUseProgram(ProgramID);
	}
}
