package io.renren.modules.ewm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 批次信息表
 * 
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@TableName("batch")
public class BatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 批次id
	 */
	@TableId
	private Integer batchId;
	/**
	 * 批次名称
	 */
	private String batchName;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 生产日期
	 */
	private Date productDate;
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
	 * 设置：批次名称
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	/**
	 * 获取：批次名称
	 */
	public String getBatchName() {
		return batchName;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：生产日期
	 */
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getProductDate() {
		return productDate;
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
