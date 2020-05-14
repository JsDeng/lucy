package com.lcehn.lucy.controller;

import com.lcehn.lucy.handler.Handler;
import com.lcehn.lucy.model.req.QccCompanyReq;
import com.lcehn.lucy.model.resp.CompanyQueryResp;
import com.lcehn.lucy.model.resp.QccCompanyResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.lcehn.lucy.constants.LucyConstants.COMPANY_INFO_PATH;


@RestController
public class CompanyController {

    @Autowired
    private Handler<CompanyQueryResp<QccCompanyResp>, QccCompanyReq> companyReqHandler;

    /**
     * 查询企业信息
     *
     * @param key
     * @param keyword
     * @return
     */
    @GetMapping(value = COMPANY_INFO_PATH)
    public CompanyQueryResp<QccCompanyResp> qccCompanyResps(@RequestParam("key") String key,
                                                            @RequestParam("keyword") String keyword) {
        QccCompanyReq qccCompanyReq = new QccCompanyReq();
        qccCompanyReq.setKeyword(keyword);
        qccCompanyReq.setKeyword(key);
        qccCompanyReq.setProvinceCode("");
        qccCompanyReq.setCityCode("");
        return companyReqHandler.handle(qccCompanyReq);
    }


}