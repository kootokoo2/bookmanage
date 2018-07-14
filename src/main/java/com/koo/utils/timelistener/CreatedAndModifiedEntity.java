package com.koo.utils.timelistener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreatedAndModifiedEntity {
	@CreatedDate
	private LocalDateTime createdAt;

	@Setter(AccessLevel.PROTECTED)
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime modifiedAt;

	@Setter(AccessLevel.PROTECTED)
	private String modifiedBy;
}
