package com.aspose.barcode.examples.barcode_image.rendering_features;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.examples.Utils;

public class RenderBarcodeToGraphicsObject {

	public static void main(String[] args) {
		// Create frame instance
		Frame f = new Frame();
		// Set frame size
		f.setSize(300, 300);
		// Create and add barcode instance to frame
		f.add(new MyBarCode());
		// Display frame
		f.setVisible(true);
	}
}

class MyBarCode extends java.awt.Canvas {
	
	public void paint(Graphics g) {
		
		// The path to the resource directory.
    	String dataDir = Utils.getDataDir(MyBarCode.class) + "BarcodeImage/RenderingFeatures/";
    	String fileName = dataDir + "barcode.png";
    	
		BarCodeBuilder bb = new BarCodeBuilder();
                bb.setEncodeType(com.aspose.barcode.EncodeTypes.CODE_128);
		bb.setCodeText("12345678");
		bb.save(fileName);
		
		// Load and Draw the image on applet
		MediaTracker tr = new MediaTracker(this);
		
		File sourceimage = new File(fileName);
		Image image;
		try {
			image = ImageIO.read(sourceimage);
			tr.addImage(image, 0);
			g.drawImage(image, 0, 0, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 300);
	}
}
