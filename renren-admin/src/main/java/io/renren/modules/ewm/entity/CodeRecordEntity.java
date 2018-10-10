package io.renren.modules.ewm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 二维码生成记录表
 * 
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@TableName("code_record")
public class CodeRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录id
	 */
	@TableId
	private Integer recordId;
	/**
	 * 批次id
	 */
	private Integer batchId;
	/**
	 * 产生数量
	 */
	private Integer num;
	/**
	 * 操作人员id
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
	 * 设置：记录id
	 */
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	/**
	 * 获取：记录id
	 */
	public Integer getRecordId() {
		return recordId;
	}
	/**
	 * 设置：批次id
	 */
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	/**
	 * 获取：批次id
	 */
	public Integer getBatchId() {
		return batchId;
	}
	/**
	 * 设置：产生数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：产生数量
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：操作人员id
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人员id
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
