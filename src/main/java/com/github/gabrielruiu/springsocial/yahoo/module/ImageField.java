package com.github.gabrielruiu.springsocial.yahoo.module;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public class ImageField extends Field {

	private ImageFieldValue value;

	@Override
	public ImageFieldValue getValue() {
		return value;
	}

	public void setValue(ImageFieldValue value) {
		this.value = value;
	}
}
