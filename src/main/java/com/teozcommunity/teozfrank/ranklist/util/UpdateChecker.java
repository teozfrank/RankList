package com.teozcommunity.teozfrank.ranklist.util;

import com.teozcommunity.teozfrank.ranklist.main.RankList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 17/08/13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class UpdateChecker {

    private RankList plugin;
    private URL fileFeed;
    private String version;
    private String version2;
    private String link;

    public UpdateChecker(RankList plugin,String url){
          this.plugin = plugin;
          try{
              this.fileFeed = new URL(url);
          }
          catch (MalformedURLException e){
              e.printStackTrace();
          }
    }

    public boolean updateAvailable(){
        try {
            InputStream input = this.fileFeed.openConnection().getInputStream();
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(input);
            Node latest = document.getElementsByTagName("item").item(0);
            NodeList children = latest.getChildNodes();

            this.version2 = children.item(1).getTextContent().replaceAll("[a-zA-Z]","");//trims letters
            this.version = version2.replaceAll(" ","");//trims white space
            this.link = children.item(3).getTextContent();

            if(!plugin.version.equals(this.version)){
                return true;
            }

        } catch (Exception e) {
            plugin.sendConsoleMessage.severe("error trying to check for updates!");
        }


        return false;
    }

    public String getVersion(){
        return this.version;
    }

    public String getLink(){
        return this.link;
    }

}
