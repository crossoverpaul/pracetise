package com.guozz.reptiles.cnvd;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 * 应用程序
 * @author Administrator
 *
 */
public class TestReptilesCNVD_WebApplication implements Runnable{

	@Override
	public void run() {
		System.out.println("-------------应用程序----------------------------");
		//获取采集要用的参数
		String collectUrl ="http://www.cnvd.org.cn/flaw/typeResult?max=20&offset=0&typeId=29";
		String collectPage = "10";
		Set<String> urlSet = new HashSet<String>();
		try {
			for (int j = 0; j <= Integer.parseInt(collectPage); j++) {
				Connection conn = Jsoup.connect("http://www.cnvd.org.cn/flaw/typeResult?max=20&offset="+j*20+"&typeId=29");
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
				Document doc = conn.timeout(100000).get();
				Elements elements = doc.select("table[class=tlist]");
				Elements links = elements.select("a");
				for (Element element : links) {
					String detailUrl = element.attr("abs:href");
						urlSet.add(detailUrl);
				}
			}
			
			for (String url : urlSet) {
				Connection connDetail = Jsoup.connect(url);
				connDetail.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
				// 设置请求类型
				Document docDetail = connDetail.timeout(100000).get();
				Elements elementsDetail = docDetail.select("tbody");
				if(!"".equals(elementsDetail.text()) && null != elementsDetail.text()){
					Iterator iterator = elementsDetail.iterator();
					System.out.println("--------------------");
					while(iterator.hasNext()){
						Element element =(Element) iterator.next();
						Elements elementsTr =element.select("tr");
						if(!"".equals(elementsTr.text()) && null != elementsTr.text()){
							Iterator<Element> iteratorTr = elementsTr.iterator();
							while(iteratorTr.hasNext()){
								String result=iteratorTr.next().text();
								System.out.println(result);
								try {
									String filePath ="d:\\cnvd";
									File file=new File(filePath);    
									if  (!file .exists()  && !file .isDirectory())      
									{       
									    file .mkdirs();    
									} 
									
									filePath =filePath+File.separator+"WebApplication.txt";
									    FileWriter  fw = new FileWriter(filePath, true);
										BufferedWriter  bw = new BufferedWriter(fw);
									    bw.append(result+"\n\r");
									bw.close();
									fw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
					System.out.println("--------------------");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}
}
