package org.myweb.first.notice.model.dto;

import java.sql.Date;

public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = -8269302835859129601L;

	private int noticeNo;				//	NOTICENO	NUMBER
	private String noticeTitle;			//	NOTICETITLE	VARCHAR2(50 BYTE)
	private java.sql.Date noticeDate;	//	NOTICEDATE	DATE
	private String noticeWriter;		//	NOTICEWRITER	VARCHAR2(50 BYTE)
	private String noticeContent;		//	NOTICECONTENT	VARCHAR2(2000 BYTE)
	private String orginalFilePath;		//	ORIGINAL_FILEPATH	VARCHAR2(100 BYTE)
	private String renameFilePath;		//	RENAME_FILEPATH	VARCHAR2(100 BYTE)
	private String importance;			//	IMPORTANCE	CHAR(1 BYTE)
	private java.sql.Date impEndDate;	//	IMP_END_DATE	DATE
	private int readCound;				//	READCOUNT	NUMBER
	
	
	public Notice() {
		super();
	}


	public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
			String orginalFilePath, String renameFilePath) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.orginalFilePath = orginalFilePath;
		this.renameFilePath = renameFilePath;
	}


	public Notice(int noticeNo, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
			String orginalFilePath, String renameFilePath, String importance, Date impEndDate, int readCound) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.orginalFilePath = orginalFilePath;
		this.renameFilePath = renameFilePath;
		this.importance = importance;
		this.impEndDate = impEndDate;
		this.readCound = readCound;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public java.sql.Date getNoticeDate() {
		return noticeDate;
	}


	public void setNoticeDate(java.sql.Date noticeDate) {
		this.noticeDate = noticeDate;
	}


	public String getNoticeWriter() {
		return noticeWriter;
	}


	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public String getOrginalFilePath() {
		return orginalFilePath;
	}


	public void setOrginalFilePath(String orginalFilePath) {
		this.orginalFilePath = orginalFilePath;
	}


	public String getRenameFilePath() {
		return renameFilePath;
	}


	public void setRenameFilePath(String renameFilePath) {
		this.renameFilePath = renameFilePath;
	}


	public String getImportance() {
		return importance;
	}


	public void setImportance(String importance) {
		this.importance = importance;
	}


	public java.sql.Date getImpEndDate() {
		return impEndDate;
	}


	public void setImpEndDate(java.sql.Date impEndDate) {
		this.impEndDate = impEndDate;
	}


	public int getReadCound() {
		return readCound;
	}


	public void setReadCound(int readCound) {
		this.readCound = readCound;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeWriter=" + noticeWriter + ", noticeContent=" + noticeContent + ", orginalFilePath="
				+ orginalFilePath + ", renameFilePath=" + renameFilePath + ", importance=" + importance
				+ ", impEndDate=" + impEndDate + ", readCound=" + readCound + "]";
	}
	
	
	
}