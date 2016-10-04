package com.game.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class StartGameText {

	private static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		try {

			File fXmlFile = new File("historia.xml");
			
	        InputStream inputStream= new FileInputStream(fXmlFile);
	        Reader reader = new InputStreamReader(inputStream,"UTF-8");
	        InputSource is = new InputSource(reader);
	        is.setEncoding("UTF-8");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();


			System.out.println("--------------------------------------------------------");
			
			System.out.println(doc.getElementsByTagName("titulo").item(0).getTextContent());

			System.out.println(doc.getElementsByTagName("historia").item(0).getTextContent());

			System.out.println("--------------------------------------------------------");
			
			Node noDecisao = doc.getElementsByTagName("decisao").item(0);
			NodeList noLs = noDecisao.getChildNodes();
			selecionaDecisao(noLs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selecionaDecisao(NodeList noLs){
		
		for(int i = 0; i < noLs.getLength(); i++){
			if( i%2 != 0 ){
				if(i < 3){
					System.out.println(noLs.item(i).getTextContent());
					System.out.println("--------------------------------------------------------");	
				}else{
					System.out.println(noLs.item(i).getChildNodes().item(1).getTextContent());
				}
			}
		}
		
		System.out.println("--------------------------------------------------------");
		System.out.print("R: ");
		int num = leia.nextInt();
		NodeList newNodeList = null;
		
		switch(num){
			case 1 : {
				newNodeList = noLs.item(3).getChildNodes().item(3).getChildNodes();
				
			}
			case 2 : {
				newNodeList = noLs.item(5).getChildNodes().item(3).getChildNodes();
			}
		}
		
		selecionaDecisao(newNodeList);

	}

}
