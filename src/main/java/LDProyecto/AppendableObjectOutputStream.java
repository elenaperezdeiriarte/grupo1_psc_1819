package LDProyecto;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

public class AppendableObjectOutputStream extends ObjectOutputStream {

	private static final Logger log = Logger.getLogger(AppendableObjectOutputStream.class.getName());
	public AppendableObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// do not write a header
	}

}
