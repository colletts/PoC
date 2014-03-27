package org.poc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name", "insuredAssets"})
public class Policy extends Identification {

	private String name;
	private List<Asset> insuredAssets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Asset> getInsuredAssets() {
		return insuredAssets;
	}
	public void setInsuredAssets(List<Asset> insuredAssets) {
		this.insuredAssets = insuredAssets;
	}
	@Override
	public String toString() {
		return "Policy [name=" + name + ", insuredAssets=" + insuredAssets
				+ ", getId()=" + getId() + "]";
	}

	
	
	
	
	
}
