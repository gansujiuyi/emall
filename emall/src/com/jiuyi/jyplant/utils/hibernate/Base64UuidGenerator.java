package com.jiuyi.jyplant.utils.hibernate;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.jiuyi.jyplant.utils.UuidUtils;

public class Base64UuidGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
       System.out.println(UuidUtils.compressedUuid());
    	return UuidUtils.compressedUuid();
    }
}