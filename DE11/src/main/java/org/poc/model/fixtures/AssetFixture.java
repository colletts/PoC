package org.poc.model.fixtures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.poc.model.Asset;
import org.poc.model.Location;

/**
 * Test class to return test data 
 * 
 *
 */

public class AssetFixture {

	public static final String ASSET_ID_1 = "a122121";
	public static final String ASSET_ID_2 = "a122121";
	public static final String ASSET_ID_3 = "a122121";
	public static final BigDecimal SUM_INSURED_1 = new BigDecimal("20000");
	public static final BigDecimal SUM_INSURED_2 = new BigDecimal("30000");
	public static final BigDecimal SUM_INSURED_3 = new BigDecimal("23000");
	
	
	public static Asset getAsset(String id, Location location, BigDecimal sumInsured){
		Asset asset = new Asset();
		asset.setId(id);
		asset.setLocation(location);
		asset.setSumInsured(sumInsured);
		return asset;		
	}
	
	public static Asset getAsset(){
		return getAsset(ASSET_ID_1, LocationFixture.getLocation(),SUM_INSURED_1);
		
	}

	public static List<Asset> getAssets(){
		List<Asset> assets = new ArrayList<Asset>();
		assets.add(getAsset(ASSET_ID_1, LocationFixture.getLocation(),SUM_INSURED_1));
		assets.add(getAsset(ASSET_ID_2, LocationFixture.getLocation(),SUM_INSURED_2));
		assets.add(getAsset(ASSET_ID_3, LocationFixture.getLocation(),SUM_INSURED_3));
		return assets;
	}
	
}
