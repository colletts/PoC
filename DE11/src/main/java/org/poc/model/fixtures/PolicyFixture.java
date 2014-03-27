package org.poc.model.fixtures;

import java.util.ArrayList;
import java.util.List;

import org.poc.model.Asset;
import org.poc.model.Policy;

/**
 * Test class to return test data 
 * 
 *
 */
public class PolicyFixture {

	public static final String POLICY_ID = "121212";
	public static final String POLICY_NAME = "Policy name";
	
	
	public static Policy getPolicy(String id, List<Asset> assets, String name){
		Policy policy = new Policy();
		policy.setId(id);
		policy.setInsuredAssets(AssetFixture.getAssets());
		policy.setName(name);
		return policy;
	}
	public static Policy getPolicy(){
		return getPolicy(POLICY_ID, AssetFixture.getAssets(), POLICY_NAME);
	}

	public static List<Policy> getPolicies(){
		List<Policy> policies = new ArrayList<Policy>();
		policies.add(getPolicy(POLICY_ID, AssetFixture.getAssets(), POLICY_NAME));
		return policies;
	}

}
