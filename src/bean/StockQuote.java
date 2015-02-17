package bean;

import java.io.InputStream;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

public class StockQuote {

	private double change;
	private double daysLow;
	private double daysHigh;
	private double yearHigh;
	private double yearLow;
	private String name;
	private String symbol;
	private String stockExchange;
	private double lastTradePrice;

	private String failMessage;


	public String getStockData()
	{		

		String fullUrlStr1="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%3D'"
				+this.symbol+"'&"+"format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

		try{
			URL fullUrl = new URL(fullUrlStr1);
			InputStream is = fullUrl.openStream();

			JSONTokener tok = new JSONTokener(is);

			JSONObject result = new JSONObject(tok);


			JSONObject q = result.getJSONObject("query");

			JSONObject result1 = q.getJSONObject("results");

			JSONObject quote =result1.getJSONObject("quote");

			setChange(quote.getDouble("Change"));
			setName(quote.getString("Name"));
			setDaysLow(quote.getDouble("DaysLow"));
			setDaysHigh(quote.getDouble("DaysHigh"));
			setStockExchange(quote.getString("StockExchange"));
			setSymbol(quote.getString("Symbol"));
			setYearHigh(quote.getDouble("YearHigh"));
			setYearLow(quote.getDouble("YearLow"));
			setLastTradePrice(quote.getDouble("LastTradePriceOnly"));
			setFailMessage("");
			is.close();

			return "success";

		}catch(Exception e)
		{
			setFailMessage("*Enter Proper TICKR Symbol");
			return "fail";
		}
	}
	
	public Boolean validateTickr(String tickr){
		String fullUrlStr1="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%3D'"
				+tickr+"'&"+"format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

		try{
			URL fullUrl = new URL(fullUrlStr1);
			InputStream is = fullUrl.openStream();

			JSONTokener tok = new JSONTokener(is);

			JSONObject result = new JSONObject(tok);


			JSONObject q = result.getJSONObject("query");

			JSONObject result1 = q.getJSONObject("results");

			JSONObject quote =result1.getJSONObject("quote");
			setChange(quote.getDouble("Change"));
			return true;
		}
		catch(Exception e){
			return false;
		}

	}
	
	public String getTickrSymbol(String tickr){
		String fullUrlStr1="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%3D'"
				+tickr+"'&"+"format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

		try{
			URL fullUrl = new URL(fullUrlStr1);
			InputStream is = fullUrl.openStream();

			JSONTokener tok = new JSONTokener(is);

			JSONObject result = new JSONObject(tok);


			JSONObject q = result.getJSONObject("query");

			JSONObject result1 = q.getJSONObject("results");

			JSONObject quote =result1.getJSONObject("quote");
			return quote.getString("Symbol");
		}
		catch(Exception e){
			return e.getMessage();
		}
	}

	public String reset()
	{
		setFailMessage("");
		setSymbol("");
		return("reset");
	}

	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getDaysLow() {
		return daysLow;
	}
	public void setDaysLow(double daysLow) {
		this.daysLow = daysLow;
	}
	public double getDaysHigh() {
		return daysHigh;
	}
	public void setDaysHigh(double daysHigh) {
		this.daysHigh = daysHigh;
	}
	public double getYearHigh() {
		return yearHigh;
	}
	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}
	public double getYearLow() {
		return yearLow;
	}
	public void setYearLow(double yearLow) {
		this.yearLow = yearLow;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public String getFailMessage() {
		return failMessage;
	}


	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}
	public String returnSuccess()
	{	
		setSymbol("");
		setFailMessage("");
		return "success";}

	public double getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(double lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
	}
	
	}