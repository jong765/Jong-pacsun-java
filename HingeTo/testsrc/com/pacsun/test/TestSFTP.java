package com.pacsun.test;

import com.pacsun.util.SftpUtil;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestSFTP
{
  public static void main(String[] args)
    throws Exception
  {
    String sftpHost = "files.hingeto.com";
    String sftpUser = "pacsun-staging";
    String sftpPassword = "DropShip2017!";
    String sftpDir = "misc";

    SftpUtil sftpUtil = new SftpUtil();
    sftpUtil.setSftpHost(sftpHost);
    sftpUtil.setSftpUser(sftpUser);
    sftpUtil.setSftpPassword(sftpPassword);
    sftpUtil.setSftpDir(sftpDir);

    List fileList = new ArrayList();
    File file = new File("/Custom/QUA/Hingeto/Test3.txt");
    fileList.add(file);
    sftpUtil.sendFiles(fileList);

    System.out.println("SFTP tested successfully.");
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.test.TestSFTP
 * JD-Core Version:    0.6.0
 */