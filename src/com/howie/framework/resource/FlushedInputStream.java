package com.howie.framework.resource;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author howieceo@163.com
 * @time Nov 9, 2012 3:05:08 PM
 */
public class FlushedInputStream extends FilterInputStream {

	public FlushedInputStream(InputStream inputStream) {
		super(inputStream);
	}

	@Override
	public long skip(long n) throws IOException {
		long totalBytesSkipped = 0L;
		while (totalBytesSkipped < n) {
			long bytesSkipped = in.skip(n - totalBytesSkipped);
			if (bytesSkipped == 0L) {
				int by_te = read();
				if (by_te < 0) {
					break; // we reached EOF
				} else {
					bytesSkipped = 1; // we read one byte
				}
			}
			totalBytesSkipped += bytesSkipped;
		}
		return totalBytesSkipped;
	}
}
