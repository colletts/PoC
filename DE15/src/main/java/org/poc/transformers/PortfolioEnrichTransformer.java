package org.poc.transformers;

import org.poc.model.Portfolio;
import org.poc.model.fixtures.PortfolioFixture;

public class PortfolioEnrichTransformer {

	public Portfolio enrichPortfolio(String name){		
		Portfolio portfolio = PortfolioFixture.getPortfolio();
		portfolio.setName(name);				
		return portfolio;				
	}
	
}
