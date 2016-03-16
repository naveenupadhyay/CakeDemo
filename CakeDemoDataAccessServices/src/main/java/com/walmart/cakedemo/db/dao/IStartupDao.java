
package com.walmart.cakedemo.db.dao;

import java.util.List;

import com.walmart.cakedemo.entity.CakeBorderType;
import com.walmart.cakedemo.entity.CakeDecoratorType;
import com.walmart.cakedemo.entity.CakeDemoProperty;
import com.walmart.cakedemo.entity.CakeFlowerType;
import com.walmart.cakedemo.entity.CakeIcingFlavors;
import com.walmart.cakedemo.entity.CakeShape;
import com.walmart.cakedemo.entity.Order;
import com.walmart.cakedemo.entity.SignatureCake;
import com.walmart.cakedemo.model.request.SubmitOrderRequest;

public interface IStartupDao {

    public List<CakeDemoProperty> getProperties();

	List<CakeFlowerType> getCakeFlowerType();

	List<CakeBorderType> getCakeBorderType();

	List<CakeDecoratorType> getCakeDecoratorType();

	List<CakeIcingFlavors> getCakeIcingFlavors();

	List<CakeShape> getCakeShape();

	List<SignatureCake> getSignatureCake();

	public Integer submitOrder(SubmitOrderRequest request);

	public List<Order> getAllOrders();

	public void updateOrderStatus(String orderId, String status);

}
