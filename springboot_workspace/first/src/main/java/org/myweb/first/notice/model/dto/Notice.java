package org.myweb.first.notice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.myweb.first.notice.jpa.entity.NoticeEntity;

import java.sql.Date;

@Data  //@Getter, @Setter, @ToString, @Equals, @HashCode 오버라이딩 까지 자동 생성됨
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {
	@NotBlank
	private int noticeNo;
	@NotBlank
	private String noticeTitle;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date noticeDate;
	private String noticeWriter;
	private String noticeContent;
	private String originalFilePath;
	private String renameFilePath;
	private String importance;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date impEndDate;
	private int readCount;

	public NoticeEntity toEntity() {
		return NoticeEntity.builder()
				.noticeNo(noticeNo)
				.noticeTitle(noticeTitle)
				.noticeDate(noticeDate)
				.noticeWriter(noticeWriter)
				.noticeContent(noticeContent)
				.originalFilePath(originalFilePath)
				.renameFilePath(renameFilePath)
				.importance(importance != null? importance : "N")
				.impEndDate(impEndDate == null ? null : new Date(impEndDate.getTime()))
				.readCount(readCount)
				.build();
	}


}
