package com.intelematics.dao.user;

import com.intelematics.dao.AbstractDao;
import com.intelematics.domain.user.User;
import com.intelematics.exceptions.IntelematicsIllegalArgumentException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Ian on 3/2/2016.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    public User findByUsername(String username) {
        if(username == null || "".equals(username.trim())) {
            throw new IntelematicsIllegalArgumentException("Cannot get user for badly formed username");
        }

        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

}
