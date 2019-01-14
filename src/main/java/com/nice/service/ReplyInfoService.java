package com.nice.service;


import com.baomidou.mybatisplus.service.IService;
import com.nice.domain.ReplyInfo;
import com.nice.utils.BaseResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangliang
 * @since 2017-08-28
 */
public interface ReplyInfoService extends IService<ReplyInfo> {
    public BaseResponse add(ReplyInfo model);

    public BaseResponse delete(ReplyInfo model);

    public BaseResponse update(ReplyInfo model);

    public BaseResponse query(ReplyInfo model);
    public BaseResponse queryList(ReplyInfo model);


}
