package io.renren.modules.ewm.controller;

import io.renren.common.annotation.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 */
@RestController
@RequestMapping("/ewm/apply")
public class ApplyController {

    private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);

    @RequestMapping("single")
    @SysLog("单次申请二维码")
    public void single(@RequestBody String strData){



    }


}
