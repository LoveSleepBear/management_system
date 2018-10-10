package io.renren.modules.ewm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 二维码信息表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 14:42:32
 */
@TableName("qr_code")
public class QrCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 唯一编号
	 */
	@TableId
	private String uniqueId;
	/**
	 * 批次信息id
	 */
	private Integer batchId;
	/**
	 * 扫描次数
	 */
	private Integer useNum;
	/**
	 * 状态1-待验证2-已验证3-失效
	 */
	private String status;
	/**
	 * 操作人id
	 */
	private String operatorId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 设置：唯一编号
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	/**
	 * 获取：唯一编号
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	/**
	 * 设置：批次信息id
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	/**
	 * 获取：批次信息id
	 */
	public Integer getBatchId() {
		return batchId;
	}
	/**
	 * 设置：扫描次数
	 */
	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}
	/**
	 * 获取：扫描次数
	 */
	public Integer getUseNum() {
		return useNum;
	}
	/**
	 * 设置：状态1-待验证2-已验证3-失效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态1-待验证2-已验证3-失效
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：操作人id
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人id
	 */
	public String getOperatorId() {
		return operatorId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
