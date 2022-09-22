package com.enotes.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.auditing.config.AuditingConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@Column(name = "create_dt",nullable = false,updatable = false)
	private Date cratedDate;
	
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "update_dt",nullable = false)
	private Date updateDate;

}