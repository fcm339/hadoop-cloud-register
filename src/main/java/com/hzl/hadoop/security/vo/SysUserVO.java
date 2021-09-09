package com.hzl.hadoop.security.vo;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * description
 *
 * @author hzl 2021/09/09 9:21 PM
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysUserVO {

	private Long id;

	private String name;

	private String password;

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
