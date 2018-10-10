package io.renren.modules.ewm.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.ewm.entity.CodeRecordEntity;
import io.renren.modules.ewm.service.CodeRecordService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 二维码生成记录表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@RestController
@RequestMapping("ewm/coderecord")
public class CodeRecordController {
    @Autowired
    private CodeRecordService codeRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ewm:coderecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = codeRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    @RequiresPermissions("ewm:coderecord:info")
    public R info(@PathVariable("recordId") Integer recordId){
        CodeRecordEntity codeRecord = codeRecordService.selectById(recordId);

        return R.ok().put("codeRecord", codeRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ewm:coderecord:save")
    public R save(@RequestBody CodeRecordEntity codeRecord){
        codeRecordService.insert(codeRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ewm:coderecord:update")
    public R update(@RequestBody CodeRecordEntity codeRecord){
        ValidatorUtils.validateEntity(codeRecord);
        codeRecordService.updateAllColumnById(codeRecord);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ewm:coderecord:delete")
    public R delete(@RequestBody Integer[] recordIds){
        codeRecordService.deleteBatchIds(Arrays.asList(recordIds));

        return R.ok();
    }

}
