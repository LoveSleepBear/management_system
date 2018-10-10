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

import io.renren.modules.ewm.entity.CodeKeyEntity;
import io.renren.modules.ewm.service.CodeKeyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 二维码秘钥表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@RestController
@RequestMapping("ewm/codekey")
public class CodeKeyController {
    @Autowired
    private CodeKeyService codeKeyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ewm:codekey:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = codeKeyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{keyId}")
    @RequiresPermissions("ewm:codekey:info")
    public R info(@PathVariable("keyId") Integer keyId){
        CodeKeyEntity codeKey = codeKeyService.selectById(keyId);

        return R.ok().put("codeKey", codeKey);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ewm:codekey:save")
    public R save(@RequestBody CodeKeyEntity codeKey){
        codeKeyService.insert(codeKey);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ewm:codekey:update")
    public R update(@RequestBody CodeKeyEntity codeKey){
        ValidatorUtils.validateEntity(codeKey);
        codeKeyService.updateAllColumnById(codeKey);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ewm:codekey:delete")
    public R delete(@RequestBody Integer[] keyIds){
        codeKeyService.deleteBatchIds(Arrays.asList(keyIds));

        return R.ok();
    }

}
