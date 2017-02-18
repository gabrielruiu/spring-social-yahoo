package com.github.gabrielruiu.springsocial.yahoo.module;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public class ImageFieldValue extends FieldValue {

	private String imageUrl;
	private String imageType;
	private String imageSource;
	private String imageMetadata;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public String getImageMetadata() {
		return imageMetadata;
	}

	public void setImageMetadata(String imageMetadata) {
		this.imageMetadata = imageMetadata;
	}
}
