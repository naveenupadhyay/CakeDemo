package com.walmart.cakedemo.sro;

import java.util.ArrayList;
import java.util.List;

public class CustomCakeDetailSRO {
	
	List<CakeShapeSRO> shapes = new ArrayList<CakeShapeSRO>();
	List<CakeIcingFlavorSRO> icingFlavors = new ArrayList<CakeIcingFlavorSRO>();
	List<CakeDecoratorTypeSRO> decoratorType = new ArrayList<CakeDecoratorTypeSRO>();
	List<CakeFlowerTypeSRO> flowerType = new ArrayList<CakeFlowerTypeSRO>();
	List<CakeBorderTypeSRO> bordertype = new ArrayList<CakeBorderTypeSRO>();

	public List<CakeShapeSRO> getShapes() {
		return shapes;
	}
	public void setShapes(List<CakeShapeSRO> shapes) {
		this.shapes = shapes;
	}
	public List<CakeIcingFlavorSRO> getIcingFlavors() {
		return icingFlavors;
	}
	public void setIcingFlavors(List<CakeIcingFlavorSRO> icingFlavors) {
		this.icingFlavors = icingFlavors;
	}
	public List<CakeDecoratorTypeSRO> getDecoratorType() {
		return decoratorType;
	}
	public void setDecoratorType(List<CakeDecoratorTypeSRO> decoratorType) {
		this.decoratorType = decoratorType;
	}
	public List<CakeFlowerTypeSRO> getFlowerType() {
		return flowerType;
	}
	public void setFlowerType(List<CakeFlowerTypeSRO> flowerType) {
		this.flowerType = flowerType;
	}
	public List<CakeBorderTypeSRO> getBordertype() {
		return bordertype;
	}
	public void setBordertype(List<CakeBorderTypeSRO> bordertype) {
		this.bordertype = bordertype;
	}
	
}
