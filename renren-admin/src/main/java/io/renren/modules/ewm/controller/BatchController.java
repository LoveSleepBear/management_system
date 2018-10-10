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

import io.renren.modules.ewm.entity.BatchEntity;
import io.renren.modules.ewm.service.BatchService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 批次信息表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@RestController
@RequestMapping("ewm/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ewm:batch:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = batchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{batchId}")
    @RequiresPermissions("ewm:batch:info")
    public R info(@PathVariable("batchId") Integer batchId){
        BatchEntity batch = batchService.selectById(batchId);

        return R.ok().put("batch", batch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ewm:batch:save")
    public R save(@RequestBody BatchEntity batch){
        batchService.insert(batch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ewm:batch:update")
    public R update(@RequestBody BatchEntity batch){
        ValidatorUtils.validateEntity(batch);
        batchService.updateAllColumnById(batch);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ewm:batch:delete")
    public R delete(@RequestBody Integer[] batchIds){
        batchService.deleteBatchIds(Arrays.asList(batchIds));

        return R.ok();
    }

}
