package com.pacsun.hingeto.imagedownload.process;

import com.pacsun.hingeto.imagedownload.dto.ImageDto;
import com.pacsun.util.SaveImageFromUrl;
import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;

public class ImageDownloader
  implements Runnable
{
  Thread t;
  private List<ImageDto> imageDtoList;
  private String hingetoHostName;
  private boolean downloadError = false;

  private static final Logger log = Logger.getLogger(ImageDownloader.class);
  String errorMessage = "";

  ImageDownloader(List<ImageDto> imageDtoList, String hostName) {
    this.imageDtoList = imageDtoList;
    this.hingetoHostName = hostName;
    this.t = new Thread(this, "image download thread");
    this.t.start();
  }

  public void run() {
    if (this.imageDtoList != null)
      for (ImageDto imageDto : this.imageDtoList) {
        String url = imageDto.getUrl();
        String destinationFile = imageDto.getDestinationFileName();
        if (new File(destinationFile).exists()) continue;
        try {
          SaveImageFromUrl.setHostName(getHingetoHostName());
          SaveImageFromUrl.saveImage(url, destinationFile);
        } catch (Exception e) {
          setDownloadError(true);
          this.errorMessage = ("Could not download image for the url: " + url);
          log.error(this.errorMessage);
        }
      }
  }

  public List<ImageDto> getImageDtoList()
  {
    return this.imageDtoList;
  }

  public void setImageDtoList(List<ImageDto> imageDtoList) {
    this.imageDtoList = imageDtoList;
  }

  public String getHingetoHostName() {
    return this.hingetoHostName;
  }

  public void setHingetoHostName(String hingetoHostName) {
    this.hingetoHostName = hingetoHostName;
  }

  public boolean isDownloadError() {
    return this.downloadError;
  }

  public void setDownloadError(boolean downloadError) {
    this.downloadError = downloadError;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_imagedownload.jar
 * Qualified Name:     com.pacsun.hingeto.imagedownload.process.ImageDownloader
 * JD-Core Version:    0.6.0
 */