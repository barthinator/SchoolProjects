package com.david.core;

import java.awt.image.DataBufferByte;

public class Renderer {
	
	private int width, height;
	private byte[] pixels;
	
	public Renderer(GameContainer gc){
		width = gc.getWidth();
		height = gc.getHeight();
		pixels = ((DataBufferByte)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear(){
		for (int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				
				int index = (x + y * width) * 4;
				
				pixels[index] = (byte)255;
				pixels[index + 1] = (byte)255;
				pixels[index + 2] = (byte)255;
				pixels[index + 3] = 0;
			}
		}
	}
}
