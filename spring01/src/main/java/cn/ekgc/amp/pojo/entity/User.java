package cn.ekgc.amp.pojo.entity;

import cn.ekgc.amp.base.pojo.entity.BaseEntity;

/**
 * <b>用户实体信息</b>
 * @author Arthur
 * @version 1.0.0
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = -5464326451880465160L;
	private Long id;                        // 主键
	private String name;                    // 用户姓名
	private String cellphone;               // 手机号码
	private String password;                // 登录密码
	private Role role;                      // 用户角色
	private String idCard;                  // 身份证号码
	private String idCardImage;             // 身份证照片
	private String email;                   // 电子邮件
	private String avatar;                  // 头像
	private Integer auditStatus;            // 审核状态
	private String auditRemark;             // 审核意见

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCardImage() {
		return idCardImage;
	}

	public void setIdCardImage(String idCardImage) {
		this.idCardImage = idCardImage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
}
