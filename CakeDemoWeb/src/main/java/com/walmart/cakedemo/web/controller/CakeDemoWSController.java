package com.walmart.cakedemo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walmart.cakedemo.db.dao.IStartupDao;
import com.walmart.cakedemo.entity.CakeBorderType;
import com.walmart.cakedemo.entity.CakeDecoratorType;
import com.walmart.cakedemo.entity.CakeFlowerType;
import com.walmart.cakedemo.entity.CakeIcingFlavors;
import com.walmart.cakedemo.entity.CakeShape;
import com.walmart.cakedemo.entity.Order;
import com.walmart.cakedemo.entity.SignatureCake;
import com.walmart.cakedemo.model.request.SubmitOrderRequest;
import com.walmart.cakedemo.model.response.SubmitOrderResponse;
import com.walmart.cakedemo.sro.CakeBorderTypeSRO;
import com.walmart.cakedemo.sro.CakeDecoratorTypeSRO;
import com.walmart.cakedemo.sro.CakeFlowerTypeSRO;
import com.walmart.cakedemo.sro.CakeIcingFlavorSRO;
import com.walmart.cakedemo.sro.CakeShapeSRO;
import com.walmart.cakedemo.sro.CustomCakeDetailSRO;
import com.walmart.cakedemo.sro.SignatureCakeSRO;

@Controller
public class CakeDemoWSController {

	private static final Logger LOG = LoggerFactory.getLogger(CakeDemoWSController.class);

	@Autowired
	IStartupDao startupDao;

	@RequestMapping(value = "getAllSignatureCakes", produces = "application/json")
	@ResponseBody
	List<SignatureCakeSRO> getAllSignatureCakes() {
		LOG.info("received request");
		List<SignatureCakeSRO> sro = new ArrayList<SignatureCakeSRO>();
		List<SignatureCake> cakes = startupDao.getSignatureCake();
		for (SignatureCake cake : cakes) {
			sro.add(new SignatureCakeSRO(cake.getId(), cake.getDescription(), cake.getCategory(), cake.getImageUrl(),
					cake.getCreated()));
		}
		return sro;
	}

	@RequestMapping(value = "getAllCustomCakeType", produces = "application/json")
	@ResponseBody
	CustomCakeDetailSRO getAllCustomCakeType() {
		CustomCakeDetailSRO returnSRO = new CustomCakeDetailSRO();

		List<CakeShape> shapes = startupDao.getCakeShape();
		List<CakeIcingFlavors> icingFlavors = startupDao.getCakeIcingFlavors();
		List<CakeFlowerType> flowerTypes = startupDao.getCakeFlowerType();
		List<CakeDecoratorType> decoratorTypes = startupDao.getCakeDecoratorType();
		List<CakeBorderType> borderTypes = startupDao.getCakeBorderType();
		/*
		 * List<CakeShapeSRO> shapeSROs = new ArrayList<CakeShapeSRO>();
		 * List<CakeIcingFlavorSRO> icingFlavorSROs = new
		 * ArrayList<CakeIcingFlavorSRO>(); List<CakeDecoratorTypeSRO>
		 * decoratorTypeSROs = new ArrayList<CakeDecoratorTypeSRO>();
		 * List<CakeBorderTypeSRO> borderTypeSROs = new
		 * ArrayList<CakeBorderTypeSRO>();
		 */

		for (CakeShape shape : shapes) {
			returnSRO.getShapes().add(
					new CakeShapeSRO(shape.getId(), shape.getCakeShape(), shape.getImageUrl(), shape.getCreated()));
		}

		for (CakeIcingFlavors flavor : icingFlavors) {
			returnSRO.getIcingFlavors().add(new CakeIcingFlavorSRO(flavor.getId(), flavor.getIcingFlavorName(),
					flavor.getImageUrl(), flavor.getCreated()));
		}

		for (CakeFlowerType flowerType : flowerTypes) {
			returnSRO.getFlowerType().add(new CakeFlowerTypeSRO(flowerType.getId(), flowerType.getFlowerTypeName(),
					flowerType.getImageUrl(), flowerType.getCreated()));
		}

		for(CakeDecoratorType decoratorType : decoratorTypes){
			returnSRO.getDecoratorType().add(new CakeDecoratorTypeSRO(decoratorType.getId(), decoratorType.getDecoratorTypeName(), decoratorType.getImageUrl(),
					decoratorType.getCreated()));
		}
		
		for(CakeBorderType borderType : borderTypes){
			returnSRO.getBordertype().add(new CakeBorderTypeSRO(borderType.getId(), borderType.getBorderTypeName(), borderType.getImageUrl(),
					borderType.getCreated()));
		}
		return returnSRO;
	}
	
	@RequestMapping(value = "submitOrder", produces = "application/json")
	@ResponseBody
	SubmitOrderResponse submitOrder(@RequestBody SubmitOrderRequest request){
		
		Integer orderCode = startupDao.submitOrder(request);
		SubmitOrderResponse response = new SubmitOrderResponse();
		response.setOrderCode(orderCode);
		response.setMessage("Order submitted successfully : " + orderCode);
		return response;
	}
	
	@RequestMapping(value = "getAllOrders", produces = "application/json")
	@ResponseBody
	 List<SubmitOrderRequest> getAllOrders(){
		List<SubmitOrderRequest> orderSROs = new ArrayList<SubmitOrderRequest>();
		List<Order> cakeOrders =  startupDao.getAllOrders();
		for(Order cakeOrder : cakeOrders){
			SubmitOrderRequest sro = new SubmitOrderRequest(cakeOrder.getImageUrl(), cakeOrder.getCakeDetails(), cakeOrder.getStatus(),
					cakeOrder.getDeliveredDate(),cakeOrder.getOrderTotal() , cakeOrder.getMobile() ,cakeOrder.getCakeType() , cakeOrder.getFeedbackType());
			 sro.setOrderCode(cakeOrder.getId());
			orderSROs.add(sro);
			
		}
		
		return orderSROs;
	}
	
	@RequestMapping(value = "updateOrderStatus", produces = "application/json")
	@ResponseBody
	String updateOrderStatus(String orderId,String status){
		startupDao.updateOrderStatus(orderId,status);
		
		return "Success";
	}
	
}
