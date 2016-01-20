/**
 * 
 */
package org.iq.gen.data;

import java.awt.image.BufferedImage;

/**
 * @author Indra
 * 
 */
public class Image extends BaseData {

	private static final long serialVersionUID = 1424682708143654044L;

	private BufferedImage image;
	private int imageBorder;
	private int imageWidth;
	private int imageHeight;
	private int[][] pixelArray;
	private String imageDescription;
	private String imageStyle;
	private String borderColor;
	private String backgroundColor;
	private String imageType;
	private Integer textShapeValue;
	private String textLine;
	private String letteringType;
	private int letteringHeight;
	private String letterPlacement;
	private String imageURL;

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getImageBorder() {
		return imageBorder;
	}

	public void setImageBorder(int imageBorder) {
		this.imageBorder = imageBorder;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public int[][] getPixelArray() {
		return pixelArray;
	}

	public void setPixelArray(int[][] pixelArray) {
		this.pixelArray = pixelArray;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageStyle() {
		return imageStyle;
	}

	public void setImageStyle(String imageStyle) {
		this.imageStyle = imageStyle;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Integer getTextShapeValue() {
		return textShapeValue;
	}

	public void setTextShapeValue(Integer textShapeValue) {
		this.textShapeValue = textShapeValue;
	}

	public String getTextLine() {
		return textLine;
	}

	public void setTextLine(String textLine) {
		this.textLine = textLine;
	}

	public String getLetteringType() {
		return letteringType;
	}

	public void setLetteringType(String letteringType) {
		this.letteringType = letteringType;
	}

	public int getLetteringHeight() {
		return letteringHeight;
	}

	public void setLetteringHeight(int letteringHeight) {
		this.letteringHeight = letteringHeight;
	}

	public String getLetterPlacement() {
		return letterPlacement;
	}

	public void setLetterPlacement(String letterPlacement) {
		this.letterPlacement = letterPlacement;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}