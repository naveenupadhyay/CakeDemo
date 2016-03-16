
package com.walmart.cakedemo.db.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.walmart.cakedemo.db.dao.IStartupDao;
import com.walmart.cakedemo.entity.CakeBorderType;
import com.walmart.cakedemo.entity.CakeDecoratorType;
import com.walmart.cakedemo.entity.CakeDemoProperty;
import com.walmart.cakedemo.entity.CakeFlowerType;
import com.walmart.cakedemo.entity.CakeIcingFlavors;
import com.walmart.cakedemo.entity.CakeShape;
import com.walmart.cakedemo.entity.Order;
import com.walmart.cakedemo.entity.SignatureCake;
import com.walmart.cakedemo.model.request.SubmitOrderRequest;

@Repository("startupDao")
@SuppressWarnings("unchecked")
@Transactional
public class StartupDaoImpl implements IStartupDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    @Override
    public List<SignatureCake> getSignatureCake() {
        Query query = sessionFactory.getCurrentSession().createQuery("from SignatureCake");
        return query.list();
    }

    @Override
    public List<CakeShape> getCakeShape() {
        Query query = sessionFactory.getCurrentSession().createQuery("from CakeShape");
        return query.list();
    }
    @Override
    public List<CakeIcingFlavors> getCakeIcingFlavors() {
        Query query = sessionFactory.getCurrentSession().createQuery("from CakeIcingFlavors");
        return query.list();
    }
    @Override
    public List<CakeDecoratorType> getCakeDecoratorType() {
        Query query = sessionFactory.getCurrentSession().createQuery("from CakeDecoratorType");
        return query.list();
    }
    @Override
    public List<CakeFlowerType> getCakeFlowerType() {
        Query query = sessionFactory.getCurrentSession().createQuery("from CakeFlowerType");
        return query.list();
    }
    @Override
    public List<CakeBorderType> getCakeBorderType() {
        Query query = sessionFactory.getCurrentSession().createQuery("from CakeBorderType");
        return query.list();
    }


	@Override
	public List<CakeDemoProperty> getProperties() {
		 Query query = sessionFactory.getCurrentSession().createQuery("from CakeDemoProperty");
	        return query.list();
	}


	@Override
	public Integer submitOrder(SubmitOrderRequest request) {
		Order cakeOrder = new Order(request.getImageUrl(), request.getCakeDetails(), new Date(), request.getDeliveredDate(),
				request.getOrderTotal(), request.getMobile(), request.getCakeType(), request.getFeedbackType());
		
		sessionFactory.getCurrentSession().save(cakeOrder);
		
		
		return cakeOrder.getId();
	}


	@Override
	public List<Order> getAllOrders() {
		 Query query = sessionFactory.getCurrentSession().createQuery("from Order");
	        return query.list();
	}


	@Override
	public void updateOrderStatus(String orderId, String status) {
		Query query =sessionFactory.getCurrentSession().createQuery("from Order where id=:orderId");
		 Order cakeOrder = (Order) query.uniqueResult();
		 cakeOrder.setStatus(status);
		 sessionFactory.getCurrentSession().merge(cakeOrder);
	}
   
}
