/**
 * Copyright (c) 2012-2013, Howie Lau 刘文豪.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.howie.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Provides operations with Stream
 * 
 * @author howieceo@163.com
 * @time Nov 9, 2012 2:30:02 PM
 */
public final class StreamUtils {
	private static final int BUFFER_SIZE = 8 * 1024; // 8 KB

	public static void copyStream(InputStream is, OutputStream os)
			throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];

		while (true) {
			int count = is.read(bytes, 0, BUFFER_SIZE);
			if (count == -1) {
				break;
			}
			os.write(bytes, 0, count);
		}
	}
}
