package io.renren.modules.ewm.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ewm.dao.QrCodeDao;
import io.renren.modules.ewm.entity.QrCodeEntity;
import io.renren.modules.ewm.service.QrCodeService;


@Service("qrCodeService")
public class QrCodeServiceImpl extends ServiceImpl<QrCodeDao, QrCodeEntity> implements QrCodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String uniqueId = (String) params.get("uniqueId");
        String batchId = (String) params.get("batchId");
        Page<QrCodeEntity> page = this.selectPage(
                new Query<QrCodeEntity>(params).getPage(),
                new EntityWrapper<QrCodeEntity>()
                        .eq(StringUtils.isNotBlank(uniqueId),"unique_id", uniqueId.trim())
                        .eq(StringUtils.isNotBlank(batchId),"batch_id", batchId.trim())
        );

        return new PageUtils(page);
    }

}
