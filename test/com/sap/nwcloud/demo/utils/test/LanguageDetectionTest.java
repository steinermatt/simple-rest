package com.sap.nwcloud.demo.utils.test;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;

/**
 * Language Detection Tests
 * 
 * @see http://code.google.com/p/language-detection/
 * @see http://search.maven.org/#artifactdetails%7Ccom.cybozu.labs%7Clangdetect%7C1.1-20120112%7Cjar
 * @see http://shuyo.wordpress.com/category/development/java/
 * 
 */
public class LanguageDetectionTest
{
	private static List<String> jsonProfiles = null;
	
	/**
     * Setup the profiles required for the {@link DetectorFactory}
     */
    @BeforeClass
    public static void setupProfiles() 
    {
    	// obtain a reference to the location to the jar file
    	// @see http://stackoverflow.com/questions/3627426/loading-a-file-relative-to-the-executing-jar-file
    	final String path = DetectorFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    	System.out.println(path);
		
		// name of the profile directory within the bundle/jar 
		final String profilesLocation = "profiles";
		
		ZipFile zip = null;
		
		try
		{
			 zip = new ZipFile(path);
			
			 jsonProfiles = new ArrayList<String>(50); 
			 
			for (Enumeration<?> list = zip.entries(); list.hasMoreElements();)
			{
				ZipEntry entry = (ZipEntry) list.nextElement();
				String entryName = entry.getName();

				if (entryName.startsWith(profilesLocation) && !entry.isDirectory() && entryName.indexOf(".sm/")==-1)
				{
					System.out.println("loadProfile ACCEPT:" + entryName);

					InputStream is = null;
                    try
                    {
                        is = zip.getInputStream(entry);
                        
                    	StringWriter writer = new StringWriter();
                    	IOUtils.copy(is, writer, "UTF-8");
                    	String profile = writer.toString();
                        
            			jsonProfiles.add(profile); 
                    } 
                    catch (Exception ex)
                    {
                    	ex.printStackTrace();
                    }
                    finally 
                    {
                        try
                        {
                            is.close();
                        }
                        catch (Exception e) {} // looking forward to Java 7 - Automatic Resource Management (ARM)  
                    }
				} // if-else
			} // enum
			
			DetectorFactory.loadProfile(jsonProfiles);
		}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    	}
		finally
		{
			try
            {
	            zip.close();
            }
            catch (Exception e) {} // looking forward to Java 7 - Automatic Resource Management (ARM)  
		}
    }
	
	
    @Test
    public void testLanguageDetectionJapanese() throws Exception 
    {
		
		Detector detector = DetectorFactory.create();
		detector.append("SAP のアプリケーションを実行・拡張するための基盤です。ビジネス統合の最適化、チームの生産性の向上、IT 環境の簡素化を実現するために役立ちます。");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals(Locale.JAPAN.getLanguage(), contentLanguage);
    }
    
    @Test
    public void testLanguageDetectionSpanish() throws Exception 
    {
		
		Detector detector = DetectorFactory.create();
		detector.append("Ejecute y amplíe las aplicaciones SAP al mismo tiempo que mejora la integración empresarial, fomenta la productividad de los equipos y simplifica el entorno de TI.");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals("es", contentLanguage);
    }
    
    @Test
    public void testLanguageDetectionGerman() throws Exception 
    {
		Detector detector = DetectorFactory.create();
		detector.append("Erweitern Sie Ihre SAP-Anwendungen und verbessern Sie gleichzeitig die Integration geschäftlicher Abläufe. Sie steigern die Produktivität Ihrer Teams und vereinfachen Ihre IT-Umgebung.");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals(Locale.GERMAN.getLanguage(), contentLanguage);
    }
    
    @Test
    public void testLanguageDetectionItalian() throws Exception 
    {
		Detector detector = DetectorFactory.create();
		detector.append("Esegui ed estendi le applicazioni SAP migliorando l'integrazione aziendale, massimizzando la produttività dei team e semplificando l'ambiente IT.");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals(Locale.ITALIAN.getLanguage(), contentLanguage);
    }
    
    @Test
    public void testLanguageDetectionFrench() throws Exception 
    {
		Detector detector = DetectorFactory.create();
		detector.append("Exécutez et développez vos applications SAP tout en améliorant l'intégration commerciale, en augmentant la productivité de votre équipe et en simplifiant votre environnement informatique.");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals(Locale.FRENCH.getLanguage(), contentLanguage);
    }
    
    @Test
    public void testLanguageDetectionChinese() throws Exception 
    {
		Detector detector = DetectorFactory.create();
		detector.append("运行并扩展您的 SAP 应用，同时加强业务整合，提高团队工作效率并简化 IT 环境。");
		String contentLanguage = (detector.detect());
		
		Assert.assertEquals("zh-cn", contentLanguage);
    }
}
