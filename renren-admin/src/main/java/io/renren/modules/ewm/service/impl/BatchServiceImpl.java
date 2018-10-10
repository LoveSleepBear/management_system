package io.renren.modules.ewm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ewm.dao.BatchDao;
import io.renren.modules.ewm.entity.BatchEntity;
import io.renren.modules.ewm.service.BatchService;


@Service("batchService")
public class BatchServiceImpl extends ServiceImpl<BatchDao, BatchEntity> implements BatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BatchEntity> page = this.selectPage(
                new Query<BatchEntity>(params).getPage(),
                new EntityWrapper<BatchEntity>()
        );

        return new PageUtils(page);
    }

}
