package cn.ekgc.amp.base.enums;

/**
 * <b>审核状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public enum AuditStatusEnum {
	AUDIT_STATUS_ING(0, "待审核"),
	AUDIT_STATUS_SUCCESS(1, "审核通过"),
	AUDIT_STATUS_FAILURE(2, "审核未通过");

	private Integer code;
	private String remark;

	private AuditStatusEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
