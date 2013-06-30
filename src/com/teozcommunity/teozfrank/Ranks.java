package com.teozcommunity.teozfrank;



public class Ranks {
	
	private String rankName;
	private Double rankPrice;
	private String rankDesc;
	private String rankPerms;
	
	
	public Ranks()
	{
		rankName = "";
		rankPrice = 0.00;
		rankDesc = "";
		rankPerms = "";
	}
	
	public Ranks(String rankName, Double rankPrice, String rankDesc,
			String rankPerms) {
		super();
		this.rankName = rankName;
		this.rankPrice = rankPrice;
		this.rankDesc = rankDesc;
		this.rankPerms = rankPerms;
	}

	public void setRankName(String r)
	{
		rankName = r;
	}
	
	public String getRankName()
	{
		return rankName;
	}
	
	public void setRankPrice(Double p)
	{
		rankPrice = p;
	}
	
	public Double getRankPrice()
	{
		return rankPrice;
	}
	
	public void setRankDesc(String d)
	{
		rankDesc = d;
	}
	
	public String getRankDesc()
	{
		return rankDesc;
	}
	
	public void setRankPerms(String ps)
	{
		rankPerms = ps;
	}
	
	public String getRankPerms()
	{
		return rankPerms; 
	}

	@Override
	public String toString() {
		return "Ranks [rankName=" + rankName + ", rankPrice=" + rankPrice
				+ ", rankDesc=" + rankDesc + ", rankPerms=" + rankPerms + "]";
	}
	
	

}
