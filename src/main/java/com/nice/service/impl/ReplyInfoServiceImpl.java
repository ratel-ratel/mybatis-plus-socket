package com.nice.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nice.domain.ReplyInfo;
import com.nice.mapper.ReplyInfoMapper;
import com.nice.service.ReplyInfoService;
import com.nice.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangliang
 * @since 2017-08-28
 */
@Slf4j
@Service
public class ReplyInfoServiceImpl extends ServiceImpl<ReplyInfoMapper, ReplyInfo> implements ReplyInfoService {
    public ReplyInfoServiceImpl() {
        super();
    }

    public ReplyInfoServiceImpl(ReplyInfoMapper baseMapper) {
        this.baseMapper = baseMapper;
    }


    @Override
    public BaseResponse add(ReplyInfo model) {
        log.info("add ReplyInfo request is : {}", model);
        boolean back = this.insert(model);
        BaseResponse baseResponse = ResponseConvert.convert(back);
        log.info("add ReplyInfo response is : {}", baseResponse);
        return baseResponse;
    }

    @Override
    public BaseResponse delete(ReplyInfo model) {
        BaseResponse baseResponse;
        if (null == model || null == model.getId()) {
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1006.getCode());
        } else {
            boolean back = this.deleteById(model.getId());
            baseResponse = ResponseConvert.convert(back);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse update(ReplyInfo model) {
        BaseResponse baseResponse;
        if (null == model || null == model.getId()) {
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1006.getCode());
        } else {
            boolean back = this.updateById(model);
            baseResponse = ResponseConvert.convert(back);
        }
        return baseResponse;
    }

    @Override
    public BaseResponse query(ReplyInfo model) {
        BaseResponse baseResponse;
        if (null == model || null == model.getId()) {
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1006.getCode());
        } else {
            ReplyInfo data = this.selectById(model.getId());
            if (null != data) {
                baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
                baseResponse.setDataInfo(data);
            } else {
                baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1002.getCode());
            }
        }
        return baseResponse;
    }

    @Override
    public BaseResponse queryList(ReplyInfo model) {
        log.info("queryList request is : {}", model);
        BaseResponse baseResponse;
        EntityWrapper<ReplyInfo> ew = new EntityWrapper<ReplyInfo>();
        List<ReplyInfo> data = this.selectList(ew);
        if (null != data) {
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
            baseResponse.setDataList(data);
        } else {
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1002.getCode());
        }
        log.info("queryList response is : {}", baseResponse);
        return baseResponse;
    }


}
