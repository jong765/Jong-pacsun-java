package com.pacsun.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SftpUtil {

	private String sftpHost;
	private String sftpUser;
	private String sftpPassword;
	private String sftpDir;
	private String sftpKeyLoc;
	private static final int SFTPPORT = 22;

	private Session session;
	private Channel channel;
	private ChannelSftp channelSftp;
	private JSch jsch;
	private Properties config;

	private static String errorMessage = "";

	private static final Logger log = Logger.getLogger(SftpUtil.class);

	public void sendFile(File file) throws Exception {
		try {
			initialize();
			FileInputStream fis = new FileInputStream(file);
			channelSftp.put(fis, file.getName());
			fis.close();
		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			closeAll();
		}
	}

	public void sendFiles(List<File> fileList) throws Exception {
		try {
			initialize();
			for (File file : fileList) {
				FileInputStream fis = new FileInputStream(file);
				channelSftp.put(fis, file.getName());
				fis.close();
			}
		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			closeAll();
		}
	}

	@SuppressWarnings("unchecked")
	public File receiveFile(String destinationPath, String fileFilter) throws Exception {

		try {
			initialize();
			Vector<ChannelSftp.LsEntry> list = channelSftp.ls(fileFilter);
			for (ChannelSftp.LsEntry entry : list) {
				channelSftp.get(entry.getFilename(), destinationPath + entry.getFilename());
				channelSftp.rm(entry.getFilename());
			}

		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			closeAll();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Vector<LsEntry> receiveFiles(String destinationPath, String fileFilter) throws Exception {
		Vector<ChannelSftp.LsEntry> vector;
		try {
			initialize();
			vector = channelSftp.ls(fileFilter);
			for (ChannelSftp.LsEntry entry : vector) {
				channelSftp.get(entry.getFilename(), destinationPath + entry.getFilename());
				channelSftp.rm(entry.getFilename());
			}
		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			closeAll();
		}
		return vector;
	}

	private void initialize() throws Exception {

		jsch = new JSch();
		if (this.sftpKeyLoc != null)
			jsch.addIdentity(this.sftpKeyLoc);
		log.debug("sftpUser=" + sftpUser + ",sftpHost=" + sftpHost + ",sftpPort=" + SFTPPORT + ",sftpPassword=" + sftpPassword);
		try {
			session = jsch.getSession(sftpUser, sftpHost, SFTPPORT);
			if (this.sftpKeyLoc == null)
				session.setPassword(sftpPassword);
			config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(sftpDir);
		} catch (JSchException e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new JSchException();
		} catch (SftpException e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception();
		}
	}

	private void closeAll() {
		channelSftp.exit();
		channel.disconnect();
		session.disconnect();
	}

	public String getSftpHost() {
		return sftpHost;
	}

	public void setSftpHost(String sftpHost) {
		this.sftpHost = sftpHost;
	}

	public String getSftpUser() {
		return sftpUser;
	}

	public void setSftpUser(String sftpUser) {
		this.sftpUser = sftpUser;
	}

	public String getSftpPassword() {
		return sftpPassword;
	}

	public void setSftpPassword(String sftpPassword) {
		this.sftpPassword = sftpPassword;
	}

	public String getSftpDir() {
		return sftpDir;
	}

	public void setSftpDir(String sftpDir) {
		this.sftpDir = sftpDir;
	}

	@SuppressWarnings("unchecked")
	public List<File> receiveFileList(String destinationPath, String fileFilter) throws Exception {
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		try {
			JSch jsch = new JSch();
			if (this.sftpKeyLoc != null)
				jsch.addIdentity(this.sftpKeyLoc);
			log.debug("sftpUser=" + sftpUser + ",sftpHost=" + sftpHost + ",sftpPort=" + SFTPPORT + ",sftpPassword=" + sftpPassword);
			session = jsch.getSession(sftpUser, sftpHost, SFTPPORT);
			if (this.sftpKeyLoc == null)
				session.setPassword(sftpPassword);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(sftpDir);
			Vector<ChannelSftp.LsEntry> list = channelSftp.ls(fileFilter);
			for (ChannelSftp.LsEntry entry : list) {
				channelSftp.get(entry.getFilename(), destinationPath + entry.getFilename());
				channelSftp.rm(entry.getFilename());
			}

		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			channelSftp.exit();
			channel.disconnect();
			session.disconnect();
		}
		return null;
	}

	public void send(List<File> fileList) throws Exception {
		Session session = null;
		Channel channel = null;
		ChannelSftp channelSftp = null;
		try {
			JSch jsch = new JSch();
			if (this.sftpKeyLoc != null)
				jsch.addIdentity(this.sftpKeyLoc);
			session = jsch.getSession(sftpUser, sftpHost, SFTPPORT);
			if (this.sftpKeyLoc == null)
				session.setPassword(sftpPassword);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd(sftpDir);
			for (File file : fileList) {
				FileInputStream fis = new FileInputStream(file);
				channelSftp.put(fis, file.getName());
				fis.close();
			}
		} catch (Exception e) {
			errorMessage = this.getClass().getName() + " : " + StackTrace.getStackTrace(e);
			log.error(errorMessage);
			throw new Exception(errorMessage);
		} finally {
			channelSftp.exit();
			channel.disconnect();
			session.disconnect();
		}
	}

	public String getSftpKeyLoc() {
		return sftpKeyLoc;
	}

	public void setSftpKeyLoc(String sftpKeyLoc) {
		this.sftpKeyLoc = sftpKeyLoc;
	}

}
