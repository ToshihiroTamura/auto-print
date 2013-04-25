package print;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Printable,Pageableインターフェースの実装。
 * kws拡張子のファイルを画像として読み込み、logo画像を左下に貼って印刷する
 */
public class KwsPrintable implements Printable, Pageable {
	private PageFormat pf;
	//	private String path;
	private Image i, logo;

	public KwsPrintable() {
	}

	public KwsPrintable(PageFormat pf) {
		this.pf = pf;
	}

	/**
	 * パスから画像を読み込む
	 * @param path jpgのパス
	 */
	public KwsPrintable(String path) {
		//		this.path = path;
		i = loadImage(path);
		logo = loadImage("C:\\Users\\QB\\Dropbox\\CRASH\\ふぁごっしゅ\\picture\\234615362 - コピー.png");
	}

	/**
	 * 印刷するメソッド
	 */
	public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
		if (i != null) {
			//			g.drawImage(i, (int) pf.getImageableX(), (int) pf.getImageableY(), (int) pf.getImageableWidth(),
			//					(int) pf.getImageableHeight(),
			//					null);
			g.drawImage(i, 0, 0, (int) pf.getWidth(),
					(int) pf.getHeight(),
					null);
			//			g.drawImage(logo, (int) pf.getImageableX() + 10, (int) (pf.getHeight() - pf.getImageableY() - 25), 20, 20,
			//					null);
			g.drawImage(logo, 10, (int) (pf.getHeight() - 50), 40, 40,
					null);

			return Printable.PAGE_EXISTS;
		}
		else
			return Printable.NO_SUCH_PAGE;
	}

	/**
	 * 画像を読み込むメソッド
	 * @param fileName
	 * @return image
	 */
	private Image loadImage(String fileName) {
		InputStream is = null;
		try {
			is = new FileInputStream(fileName);
			BufferedImage img = ImageIO.read(is);
			return img;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
	}

	@Override
	public int getNumberOfPages() {
		return 1;
	}

	@Override
	public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
		return pf;
	}

	@Override
	public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
		return this;
	}

}