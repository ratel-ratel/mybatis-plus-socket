package com.nice.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangliang
 * @since 2017-08-28
 */

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply_info")
public class ReplyInfo extends Model<ReplyInfo> {

    private static final long serialVersionUID = 1L;
	@TableField("id")
	private Long id;
    /**
     * 用户号码
     */
	@TableField("open_id")
	private String openId;
    /**
     * 密码
     */
	@TableField("app_id")
	private String appId;

	@TableField("reply_key")
	private String replyKey;

	@TableField("message_type")
	private String messageType;

	@TableField("content")
	private String content;

	@TableField("title")
	private String title;

	@TableField("description")
	private String description;

	@TableField("url")
	private String url;

	@TableField("picture_url")
	private String pictureUrl;

	/**
	 * 创建人
	 */
	@TableField("created_by")
	private Long createdBy;
	/**
	 * 创建时间
	 */
	@TableField("created_time")
	private Long createdTime;
	/**
	 * 修改人
	 */
	@TableField("updated_by")
	private Long updatedBy;
	/**
	 * 修改时间
	 */
	@TableField("updated_time")
	private Long updatedTime;
	/**
	 * 删除状态
	 */
	@TableField("deleted")
	private Integer deleted;

    /**
     * 备注
     */
	@TableField("remark")
	private String remark;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
