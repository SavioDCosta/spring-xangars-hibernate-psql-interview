package com.saviodcosta.xangars.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLogs {
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	@Column(name = "change_log")
	private String changeLog;

	public AuditLogs() {
		super();
	}

	public AuditLogs(Timestamp updatedAt, String changeLog) {
		super();
		this.updatedAt = updatedAt;
		this.changeLog = changeLog;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(String changeLog) {
		this.changeLog = changeLog;
	}
	
	
}
