package com.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_data_templates")
public class DataTemplates {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="template_name")
	private String templateName;
	
	@Column(name="template_type")
	private String templateType;
	
	@Column(name="is_enable")
	private Boolean isEnable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "DataTemplates [id=" + id + ", templateName=" + templateName + ", templateType=" + templateType
				+ ", isEnable=" + isEnable + "]";
	}

	

}
