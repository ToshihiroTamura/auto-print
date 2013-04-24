package print;

import javax.print.PrintException;

public abstract class JPSPFunction {
	protected String path;

	JPSPFunction() {

	}

	protected abstract boolean print() throws PrintException;

	protected void setPath(String path) {
		this.path = path;
	}
}
