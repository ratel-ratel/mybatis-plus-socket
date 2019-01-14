package com.nice.controller;


import com.nice.domain.ReplyInfo;
import com.nice.service.ReplyInfoService;
import com.nice.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yinxicheng
 * @since 2018-12-25
 */
@RestController
@Slf4j
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("/replyInfo")
public class ReplyInfoController  {
    private ReplyInfoService replyInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestBody ReplyInfo vo) {
        return replyInfoService.add(vo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestBody ReplyInfo vo) {
        return replyInfoService.update(vo);
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse query(@RequestBody ReplyInfo vo) {
        return replyInfoService.query(vo);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestBody ReplyInfo vo) {
        return replyInfoService.delete(vo);
    }

    @RequestMapping(value = "/queryList")
    @ResponseBody
    public BaseResponse queryList() {
        ReplyInfo vo = new ReplyInfo();
        return replyInfoService.queryList(vo);
    }

}
