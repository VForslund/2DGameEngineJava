package com.victor.engine.gfx;

public class Font {
	
	public static final Font STANDARD = new Font("/Fonts/standard.png");
	private Image fontimage;
	private int[] offsets;
	private int[] widths;
	
	public Font(String path) {
		fontimage = new Image(path);
		offsets = new int[59];
		widths = new int[59];
		int unicode = 0;
		
		for (int i = 0; i < fontimage.getW(); i++) {
			if(fontimage.getP()[i] == 0xff0000ff) {
				offsets[unicode] = i;
			}
			if(fontimage.getP()[i] == 0xffffff00) {
				widths[unicode] = i - offsets[unicode];
				unicode++;
			}
		}
		
	}

	public Image getFontimage() {
		return fontimage;
	}

	public void setFontimage(Image fontimage) {
		this.fontimage = fontimage;
	}

	public int[] getOffsets() {
		return offsets;
	}

	public void setOffsets(int[] offsets) {
		this.offsets = offsets;
	}

	public int[] getWidths() {
		return widths;
	}

	public void setWidths(int[] widths) {
		this.widths = widths;
	}

}
