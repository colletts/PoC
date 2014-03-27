package org.poc.model.fixtures;

import java.util.ArrayList;
import java.util.List;

import org.poc.model.Portfolio;

public class PortfolioFixture {

	public static String PORTFOLIO_ID = "p1210";
	
	public static Portfolio getPortfolio(){
		Portfolio portfolio = new Portfolio();
		portfolio.setId(PORTFOLIO_ID);
		portfolio.setPolicies(PolicyFixture.getPolicies());
		return portfolio;
	}
	
	public static List<Portfolio> getPortfolios(){
		List<Portfolio> portfolios = new ArrayList<Portfolio>();
		portfolios.add(getPortfolio());
		return portfolios;
	}
}
