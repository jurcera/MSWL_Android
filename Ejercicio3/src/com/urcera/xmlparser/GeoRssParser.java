/*
 *
 *  Copyright (C) 2012 GSyC/LibreSoft, Universidad Rey Juan Carlos.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/. 
 *
 *  Author : Roberto Calvo Palomino <rocapal at libresoft dot es>
 *  		 Jorge Fernandez <jfernandez at libresoft dot es>
 *
 */

package com.urcera.xmlparser;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class GeoRssParser{
    
	
    public ArrayList<GeoRSSNode> parseGeoRssURL (String url) 
    		throws
    		ParserConfigurationException, SAXException, IOException{
    	
    	ArrayList<GeoRSSNode> result = null;
    	try{
    		
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            GeoRSSReader reader = new GeoRSSReader();
           	sp.parse(url, reader);
           	result = reader.getArrayGeoNode();
           	
        }catch(ParserConfigurationException pcex){
        	//Log.w(TAG, pcex.toString());
        	throw pcex;
        }catch(SAXException saxex){
        	//Log.w(TAG, saxex.toString());
        	throw saxex;
        } catch (IOException ioex) {
        	//Log.w(TAG, ioex.toString());
        	throw ioex;
        }
        return result;
    }
    
    /**
     * GPXReader extends the DefaultHandler for a SAX parser, implementing
     * the specific parsing of labels for a GPX document.  
     */
    private class GeoRSSReader extends DefaultHandler {
    	
    	private StringBuilder contentBuffer; // This variable stores the tag's content.
    	private ArrayList<GeoRSSNode> aGeoRSSNode = new ArrayList<GeoRSSNode>();
    	
    	private String name = null;
    	private String description = null;
    	private String link = null;
    	private double latitude = -1.0;
    	private double longitude = -1.0;
    	//private double altitude = -1.0;
    	
    	public GeoRSSReader() {
    		clear();
    	}
    	   
    	public void clear() {
    		aGeoRSSNode.clear();
    		contentBuffer = new StringBuilder();
    	}
    	
    	/**
    	 * Returns an ArrayList of GeoNode objects as result of parsing a KML document.
    	 * 
    	 * @return An ArrayList of GeoNode objects as result of parsing a KML document.
    	 */
    	public ArrayList<GeoRSSNode> getArrayGeoNode(){
    		return aGeoRSSNode;
    	}

    	public void startDocument() throws SAXException{
    	}
    	
    	public void endDocument() throws SAXException{
    	}

    	/**
    	 * DefaultHandler::startElement() fires whenever an XML start 
    	 * tag is encountered.
    	 * 
    	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
    	 */
    	public void startElement(String uri, String localName, String qName, Attributes attributes){
    		// Clear content buffer
    		contentBuffer.delete(0, contentBuffer.length());
    	}

    	/**
    	 * The DefaultHandler::characters() function fires one or more times 
    	 * for each text node encountered.
    	 * 
    	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
    	 * @throws SAXException If there are problems while parsing the KML file (document malformed).
    	 */
    	public void characters(char buf[], int offset, int len) throws SAXException{
    		contentBuffer.append(String.copyValueOf(buf, offset, len));
    	}
        
    	/**
    	 * The DefaultHandler::endElement() function fires for each end tag.
    	 *
    	 * @see org.xml.sax.helpers.DefaultHandler#endElement(String, String, String)
    	 */
    	public void endElement(String uri, String localName, String qName) {   
        		
    		if("title".equals(localName))
    			name = contentBuffer.toString();
    		else if("description".equals(localName))
    			description = contentBuffer.toString();
    		// SUSO: a�adir link
    		else if("link".equals(localName))
    			link = contentBuffer.toString();    		
    		else if ("geo:lat".equals(qName)) 
    			latitude = new Double(contentBuffer.toString()).doubleValue();
    		else if ("geo:long".equals(qName))
    			longitude = new Double(contentBuffer.toString()).doubleValue();
    		else if("geo:rsspoint".equals(qName)) {
    			
    			String coordinate[] = contentBuffer.toString().split(" ");   			
    			
    			latitude = new Double(coordinate[0]).doubleValue(); 
    			longitude = new Double(coordinate[1]).doubleValue();    			
    		}
    		else if("item".equals(localName)) 
    		{
    			Log.d("GeoRssParser", "Title: " + name + " - Description: " + description);
    			Log.d("GeoRssParser", "Link" + link);
    			Log.d("GeoRssParser", "Lat: " + String.valueOf(latitude) + " - Long: " + String.valueOf(longitude));
    			aGeoRSSNode.add(new GeoRSSNode(name,description,link,latitude,longitude));
    		}
    		
    	}
    }
}