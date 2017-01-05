package com.jiuyi.jyplant.order.dao.impl;

import org.springframework.stereotype.Repository;

import com.jiuyi.jyplant.order.dao.ExpressInfoDAO;
import com.jiuyi.jyplant.order.entity.ExpressInfo;
import com.jiuyi.jyplant.utils.hibernate.impl.BaseDao;
@Repository("ExpressInfoDAO")
public class ExpressInfoDAOImpl extends BaseDao<ExpressInfo, String> implements ExpressInfoDAO{

}
