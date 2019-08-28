package com.pacsun.hingeto.imagedownload.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pacsun.hingeto.imagedownload.dto.ImageDto;
import com.pacsun.util.SaveImageFromUrl;

@ContextConfiguration({ "classpath:imageDownloadApplicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageDownloaderTest {
	List<ImageDto> imageDtoList1;
	List<ImageDto> imageDtoList2;
	List<ImageDto> imageDtoList3;
	List<ImageDto> imageDtoList4;

	@Value("${merchantry.host.name}")
	private String IMAGE_HOST_NAME;

	@Value("${productexport.imagefile.image.queue.folder}")
	private String IMAGE_QUEUE_FOLDER;

	@Value("${merchantry.host.name}")
	private String MERCHANTRY_HOSTNAME;

	@Autowired
	ImageDownloadProcess imageDownloadProcess;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.imageDtoList1 = new ArrayList();
		String url = "https://stg.merchantry.net/mp/product/image/30231/256/295/886482713320.jpg";
		for (int i = 0; i < 20; i++) {
			ImageDto imageDto = new ImageDto();
			String destinationFileName = getDestinationFile(url, 1, 2, 3, i);
			imageDto.setUrl(url);
			imageDto.setDestinationFileName(destinationFileName);
			this.imageDtoList1.add(imageDto);
		}

		this.imageDtoList2 = new ArrayList();
		url = "https://stg.merchantry.net/mp/product/image/30231/341/290/886482713313-1.jpg";
		for (int i = 0; i < 20; i++) {
			ImageDto imageDto2 = new ImageDto();
			String destinationFileName = getDestinationFile(url, 5, 6, 7, i);
			imageDto2.setUrl(url);
			imageDto2.setDestinationFileName(destinationFileName);
			this.imageDtoList2.add(imageDto2);
		}

		this.imageDtoList3 = new ArrayList();
		url = "https://stg.merchantry.net/mp/product/image/30231/56/439/35104100_CHARCOAL.jpg";
		for (int i = 0; i < 20; i++) {
			ImageDto imageDto3 = new ImageDto();
			String destinationFileName = getDestinationFile(url, 7, 7, 7, i);
			imageDto3.setUrl(url);
			imageDto3.setDestinationFileName(destinationFileName);
			this.imageDtoList3.add(imageDto3);
		}

		this.imageDtoList4 = new ArrayList();
		url = "https://stg.merchantry.net/mp/product/image/30231/56/439/35104100_CHARCOAL.jpg";
		for (int i = 0; i < 20; i++) {
			ImageDto imageDto4 = new ImageDto();
			String destinationFileName = getDestinationFile(url, 8, 8, 8, i);
			imageDto4.setUrl(url);
			imageDto4.setDestinationFileName(destinationFileName);
			this.imageDtoList4.add(imageDto4);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiThreading() {
		ImageDownloader downloader1 = null;
		ImageDownloader downloader2 = null;
		ImageDownloader downloader3 = null;
		ImageDownloader downloader4 = null;

		System.out.println(new Date());
		downloader1 = new ImageDownloader(this.imageDtoList1, this.IMAGE_HOST_NAME);
		downloader2 = new ImageDownloader(this.imageDtoList2, this.IMAGE_HOST_NAME);
		downloader3 = new ImageDownloader(this.imageDtoList3, this.IMAGE_HOST_NAME);
		downloader4 = new ImageDownloader(this.imageDtoList4, this.IMAGE_HOST_NAME);
		try {
			while ((downloader1.t.isAlive()) || (downloader2.t.isAlive()) || (downloader3.t.isAlive()) || (downloader4.t.isAlive())) {
				Thread.sleep(3000L);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread run is over");
		System.out.println(new Date());
	}

	@Test
	public void loadTest() throws IOException {
		String url = "https://stg.merchantry.net/mp/product/image/30237/286/253/35195007_BLACK.jpg";
		String destinationFileName = this.imageDownloadProcess.getDestinationFile(url, 1, 2, 3, 4);

		Date date1 = new Date();
		for (int i = 1; i <= 20; i++) {
			SaveImageFromUrl.setHostName(this.MERCHANTRY_HOSTNAME);
			SaveImageFromUrl.saveImage(url, destinationFileName);
			System.out.println(i + " images downloaded.");
		}
		System.out.println("START: " + date1);
		System.out.println("END: " + new Date());
	}

	@Test
	public void testGetDestinationFile() {
		String url1 = "https://stg.merchantry.net/mp/product/image/30237/277/145/25106101_WHITE.jpg";
		String url2 = "https://stg.merchantry.net/mp/product/image/30237/277/145/25106101_WHITE-1.jpg";
		String url3 = "https://stg.merchantry.net/mp/product/image/30237/277/145/25106101_WHITE-2.jpg";

		String imageFileName = this.imageDownloadProcess.getDestinationFile(url1, 1, 2, 3, 4);
		System.out.println(imageFileName);
		imageFileName = this.imageDownloadProcess.getDestinationFile(url2, 1, 2, 3, 4);
		System.out.println(imageFileName);
		imageFileName = this.imageDownloadProcess.getDestinationFile(url3, 1, 2, 3, 4);
		System.out.println(imageFileName);
	}

	private String getDestinationFile(String url, int classz, int vendor, int style, int color) {
		String fileName = FilenameUtils.getBaseName(url).trim();
		String view = "";

		if (fileName.indexOf("-1") > -1)
			view = "_" + fileName.substring(fileName.indexOf("-") + 1);
		else {
			view = "";
		}

		return this.IMAGE_QUEUE_FOLDER + String.format("%04d", new Object[] { Integer.valueOf(classz) })
				+ String.format("%05d", new Object[] { Integer.valueOf(vendor) })
				+ String.format("%04d", new Object[] { Integer.valueOf(style) }) + "NEW" + view + "_"
				+ String.format("%03d", new Object[] { Integer.valueOf(color) }) + "." + FilenameUtils.getExtension(url).trim();
	}
}

/*
 * Location: C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_imagedownload.jar Qualified Name:
 * com.pacsun.hingeto.imagedownload.process.ImageDownloaderTest JD-Core Version: 0.6.0
 */