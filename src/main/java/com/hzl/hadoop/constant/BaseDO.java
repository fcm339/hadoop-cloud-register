package com.hzl.hadoop.constant;

import lombok.*;

import java.time.LocalDateTime;

/**
 * description
 *
 * @author hzl 2021/09/10 11:28 AM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseDO {

	private LocalDateTime creationDate;

	private Long createdBy;

	private LocalDateTime lastUpdateDate;

	private Long lastUpdatedBy;

	private Long objectVersionNumber;

	public void init(){
		this.setCreatedBy(1L);
		this.setCreationDate(LocalDateTime.now());
		this.setLastUpdateDate(LocalDateTime.now());
		this.setLastUpdatedBy(1L);
		this.setObjectVersionNumber(1L);
	}
}
