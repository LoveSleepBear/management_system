package io.renren.modules.ewm.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.ewm.utils.IdUtils;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.ewm.entity.QrCodeEntity;
import io.renren.modules.ewm.service.QrCodeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;


/**
 * 二维码信息表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
@RestController
@RequestMapping("ewm/qrcode")
public class QrCodeController extends BaseEwmController {
    @Autowired
    private QrCodeService qrCodeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ewm:qrcode:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = qrCodeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uniqueId}")
    @RequiresPermissions("ewm:qrcode:info")
    public R info(@PathVariable("uniqueId") String uniqueId) {
        QrCodeEntity qrCode = qrCodeService.selectById(uniqueId);

        return R.ok().put("qrCode", qrCode);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ewm:qrcode:save")
    public R save(@RequestBody QrCodeEntity qrCode) {
        qrCode.setUniqueId(IdUtils.getUUIdAndTime());
        Date date = new Date();
        qrCode.setCreateTime(date);
        qrCode.setUpdateTime(date);
        Long userId = ShiroUtils.getUserId();
        qrCode.setUseNum(0);
        qrCode.setOperatorId(userId == null ? null : userId.toString());
        boolean b = qrCodeService.insertAllColumn(qrCode);
        logger.info("生成单张二维码-->{}", b);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ewm:qrcode:update")
    public R update(@RequestBody QrCodeEntity qrCode) {
        ValidatorUtils.validateEntity(qrCode);
        qrCodeService.updateAllColumnById(qrCode);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ewm:qrcode:delete")
    public R delete(@RequestBody String[] uniqueIds) {
        qrCodeService.deleteBatchIds(Arrays.asList(uniqueIds));

        return R.ok();
    }

}
