package io.renren.modules.ewm.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.ewm.entity.QrCodeEntity;

import java.util.Map;

/**
 * 二维码信息表
 *
 * @author syb
 * @email lovesleepbear@163.com
 * @date 2018-10-10 13:34:29
 */
public interface QrCodeService extends IService<QrCodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

