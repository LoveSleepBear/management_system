package io.renren.modules.ewm.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 二维码秘钥表
 * 
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@TableName("code_key")
public class CodeKeyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 秘钥id
	 */
	@TableId
	private Integer keyId;
	/**
	 * 私钥
	 */
	private String priKey;
	/**
	 * 公钥
	 */
	private String pubKey;
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
	 * 设置：秘钥id
	 */
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	/**
	 * 获取：秘钥id
	 */
	public Integer getKeyId() {
		return keyId;
	}
	/**
	 * 设置：私钥
	 */
	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}
	/**
	 * 获取：私钥
	 */
	public String getPriKey() {
		return priKey;
	}
	/**
	 * 设置：公钥
	 */
	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}
	/**
	 * 获取：公钥
	 */
	public String getPubKey() {
		return pubKey;
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
