package com.teozcommunity.teozfrank.ranklist.util;


import java.util.ArrayList;
import java.util.List;

public class Ranks {
	
	private String rankName;
	private Double rankPrice;
	private String rankDesc;
	private List<String> rankPerms;
	
	
	public Ranks() {
		rankName = "";
		rankPrice = 0.00;
		rankDesc = "";
		this.rankPerms = new ArrayList<String>();
	}

    public Ranks(String rankName) {
        super();
        this.rankName = rankName;
        this.rankPrice = null;
        this.rankDesc = null;
        this.rankPerms = null;
    }
	
	public Ranks(String rankName, Double rankPrice, String rankDesc,
			List<String> rankPerms) {
		super();
		this.rankName = rankName;
		this.rankPrice = rankPrice;
		this.rankDesc = rankDesc;
		this.rankPerms = rankPerms;
	}

	public void setRankName(String r) {
		rankName = r;
	}
	
	public String getRankName() {
		return rankName;
	}
	
	public void setRankPrice(Double p) {
		rankPrice = p;
	}
	
	public Double getRankPrice() {
		return rankPrice;
	}
	
	public void setRankDesc(String d) {
		rankDesc = d;
	}
	
	public String getRankDesc() {
		return rankDesc;
	}
	
	public void setRankPerms(List<String> permsIn) {
		rankPerms = permsIn;
	}
	
	public List<String> getRankPerms() {
		return rankPerms; 
	}

	@Override
	public String toString() {
		return "Ranks [rankName=" + rankName + ", rankPrice=" + rankPrice
				+ ", rankDesc=" + rankDesc + ", rankPerms=" + rankPerms + "]";
	}
	
	

}
