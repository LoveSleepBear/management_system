package io.renren.modules.ewm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.ewm.dao.CodeKeyDao;
import io.renren.modules.ewm.entity.CodeKeyEntity;
import io.renren.modules.ewm.service.CodeKeyService;


@Service("codeKeyService")
public class CodeKeyServiceImpl extends ServiceImpl<CodeKeyDao, CodeKeyEntity> implements CodeKeyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CodeKeyEntity> page = this.selectPage(
                new Query<CodeKeyEntity>(params).getPage(),
                new EntityWrapper<CodeKeyEntity>()
        );

        return new PageUtils(page);
    }

}
