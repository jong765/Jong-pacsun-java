package com.pacsun.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

public class FileUtils {

	private static final Logger log = Logger.getLogger(FileUtils.class);

	public static String readFile(String filePath) {
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			log.error("File reader failed for file '" + filePath + "':\n ");
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				log.error("File reader failed for file '" + filePath + "':\n ");
			}
		}
		return builder.toString();
	}

	public static File writeFile(String fileName, String folderPath, String content, boolean bOverwrite) throws Exception {
		log.debug("Begin FileUtils.writeFile()");
		String fullFileName = folderPath + fileName;
		log.debug("fullFileName=" + fullFileName);
		File file = new File(fullFileName);

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		Writer writer = null;

		try {
			fos = new FileOutputStream(fullFileName);
			osw = new OutputStreamWriter(fos);
			writer = new BufferedWriter(osw);
			if (file.exists()) {
				if (!bOverwrite) {
					log.debug("Appending to existing file.");
					writer.append(content);
				} else {
					writer.write(content);
				}
			} else {
				log.debug("Creating new file because it does not exist");
				writer.write(content);
			}
		} catch (Exception e) {
			log.error("Unable to write '" + content + "' to file '" + fullFileName + "':\n");
			throw new Exception(e);
		} finally {
			try {
				// if (fos != null)
				// fos.close();
				if (writer != null)
					writer.close();
				if (osw != null)
					osw.close();
			} catch (Exception e) {
				log.warn("Can't close the output writer. Moving on with life.");
				throw new Exception(e);
			}
		}
		log.debug("End FileUtils.writeFile()");
		return file;
	}

	public static boolean moveFile(String fromFullFileName, String toFullFileName) {

		File fromFile = new File(fromFullFileName);

		if (fromFile.renameTo(new File(toFullFileName))) {
			return true;
		} else {
			return false;
		}
	}

	public static File[] listFiles(String folderPath, final String filePrefix, final String fileExtension) {
		FilenameFilter fileNameFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				boolean selected = false;
				String lowercaseName = name.toLowerCase();
				if (filePrefix != null) {
					if (lowercaseName.startsWith(filePrefix.toLowerCase())) {
						selected = true;
					} else
						selected = false;
				}

				if (selected && fileExtension != null) {
					if (lowercaseName.endsWith(fileExtension.toLowerCase())) {
						selected = true;
					} else {
						selected = false;
					}
				}
				return selected;
			}
		};
		File[] fileList = new File(folderPath).listFiles(fileNameFilter);
		return fileList;
	}

	public static void sortFiles(File[] files) {
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.compare(f1.lastModified(), f2.lastModified());
			}
		});
	}

	public static void zipFiles(List<File> files, String targetZipFile) {

		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(targetZipFile);
			zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			for (File filePath : files) {
				File input = filePath;
				fis = new FileInputStream(input);
				ZipEntry ze = new ZipEntry(input.getName());
				System.out.println("Zipping the file: " + input.getName());
				zipOut.putNextEntry(ze);
				byte[] tmp = new byte[4 * 1024];
				int size = 0;
				while ((size = fis.read(tmp)) != -1) {
					zipOut.write(tmp, 0, size);
				}
				zipOut.flush();
				fis.close();
			}
			zipOut.close();
			System.out.println("Done... Zipped the files...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ex) {

			}
		}
	}
}
