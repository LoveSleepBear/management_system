package io.renren.modules.ewm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ewm.dao.CodeRecordDao;
import io.renren.modules.ewm.entity.CodeRecordEntity;
import io.renren.modules.ewm.service.CodeRecordService;


@Service("codeRecordService")
public class CodeRecordServiceImpl extends ServiceImpl<CodeRecordDao, CodeRecordEntity> implements CodeRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CodeRecordEntity> page = this.selectPage(
                new Query<CodeRecordEntity>(params).getPage(),
                new EntityWrapper<CodeRecordEntity>()
        );

        return new PageUtils(page);
    }

}
