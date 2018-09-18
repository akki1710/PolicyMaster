package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.poiji.bind.Poiji;

import study.db.Db;

public class main {
	
	
	private String strVehicleCode;
	
	
	public static void main(String[] args) throws Exception {
		/*hiString a="akash"hi  ;
		StringBuilder c=new StringBuilder("akash");
		StringBuffer d=new StringBuffer("akash");
		System.out.println(a+"chauhan");
		System.out.println(c.append("chauhan"));
		System.out.println(d.append("chauhan"));
		
		String prop_num="7894563211";
		String premium="5456.55";
		List<String> al=new ArrayList<>();
		al.add(prop_num);
		al.add(premium);
		for(String s:al) {
			System.out.println(s);
		}
		Map< String,Double> hm = new HashMap<>();
		hm.put("prop-num", 123456987888d);
		hm.put("premium", 5454.33);
		
		Set< Map.Entry< String,Double> > st = hm.entrySet();   
		 
	       for (Map.Entry< String,Double> me:st)
	       {
	           System.out.print(me.getKey()+":");
	           System.out.println(me.getValue());
	       }
		
		DateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1=null;
		try {
			date1 = originalFormat.parse(strPrevPolExpDt);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		String formattedDate = targetFormat.format(date1); 
		
		System.out.println(formattedDate);
		String a="Self(20),Spouse(21)";
		String str[] = a.split(",");
		 List<String> al = new ArrayList<String>();
		 al = Arrays.asList(str);
		 //System.out.println(str[0]);
		 for(String s: al){
	            System.out.println(s);
	        }
		String a="Self(20),Spouse(21),";
		System.out.println("a: "+a);
		String b[]=a.split("\\(");
		System.out.println("b[0]: "+b[0]);
		//System.out.println("b[1]: "+b[1]);
		//System.out.println("b[2]: "+b[2]);
		
		for(int i=0;i<b.length;i++) {
			System.out.println("b[i]: "+b[i]);
		}
		String c[]=b[1].split("\\)");
		String d[]=b[2].split("\\)");
		String e[]=c[1].split(",");

		System.out.println(b[0]);
		System.out.println("c[0]: "+c[0]);
		System.out.println("c[1]: "+c[1]);
		System.out.println("d[0]: "+d[0]);
		System.out.println("e[1]: "+e[1]);
		
		for(int i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
		
		String a="5383.0";
		String s1[]=a.split("\\.");
		String d=s1[0];
		System.out.println(d);
		Integer b=Integer.parseInt(d);
		Integer c=b/12;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		Integer a=5383;
		Integer b=a/12;
		System.out.println(b);
		
		String s="Akash";
		
		String s1[]=s.split("\\s");
		
		String firstname=s1[0];
		String lastname=null;
		
		try {
		 lastname=s1[1];
		
		
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Array out");
		}
		if(lastname==null) {
			lastname="";
		}
		System.out.println(firstname);
		System.out.println("lastname: "+lastname);
		String datestr="17-10-1994";
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();  
		 Date utilDate1 = formatter.parse(datestr);
		 String PolicyFromDt=formatter.format(utilDate1);
		 Calendar c = Calendar.getInstance();
		
		    c.setTime(utilDate1);
		    c.add(Calendar.DAY_OF_MONTH, -364);
		    Date end=c.getTime();
		    String PolicyToDt=formatter.format(end);
		    System.out.println(PolicyFromDt);
		    System.out.println(PolicyToDt);
	       String day="22";
	       String month="10";
	       String year="1994";
	       String datestr=year + "-" + month + "-" + day;
	       String datestr1=day + "/" + month + "/" + year;
	       SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        String DateOfBirth=datestr1;
	        System.out.println(DateOfBirth);
	       System.out.println(datestr);
	       System.out.println(datestr1);
		List<ProdMasters> pm=Poiji.fromExcel(new File("E://API//Shriram//MASTER KITS/Prod Masters.xls"), ProdMasters.class);
		Integer a=pm.size();
		//System.out.println(a);
		ProdMasters pm1=pm.get(0);
		//System.out.println(pm1.getProdcode());
		//System.out.println(pm1.getProddesc());
		String[] s=pm1.toString().split(",");
		System.out.println(s[0]);
		System.out.println(s[1]);
		//System.out.println(s);
		//System.out.println(pm.get(1).toString());
		 * 	
		String fileName = "E://API//Shriram//MASTER KITS/TWO_WHEELER_TEST_MASTER_19_05_2018.xls";
        String cellContent = "DREAM YUGA ELECTRIC START ALLOY";
        
        InputStream input = new FileInputStream(fileName);
        
        HSSFWorkbook wb = new HSSFWorkbook(input);
        HSSFSheet sheet = wb.getSheetAt(0);
        String a=abc(sheet, cellContent);
        System.out.println(a);*/
	}
	
	public String ifModel(String Model,String FuelType) {
		String VEH_CODE = null;
		try {
			Connection con=Db.myGetConnection();
			String query1 = "select VEH_CODE from carmaster where MODEL_DESC like ? && FUEL=?";
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.setString(1, Model + "%");
			stmt.setString(2, FuelType);
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				VEH_CODE= rs.getString("VEH_CODE");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return VEH_CODE;
		
	}
	public String ifByke(String Bike_Model) {
		String holdgetValue=null;
		try {
			Connection con=Db.myGetConnection();
			//String name="KINE";
			String query1 = "select VEH_CODE from bikemaster where MODEL_DESC like ?";
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.setString(1, Bike_Model+"%");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				String VEH_CODE = rs.getString("VEH_CODE");
				holdgetValue=VEH_CODE;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(holdgetValue.isEmpty())
		{
			return null;
		}
		else
		{
			return holdgetValue;	
		}
		
	}
	public String[] ifRegyr(String Regyr,String Claim) {
		if(Regyr.equals("Brandnew")) {
			String g[]=new String[6];
	    	    g[0]="MOT-PRD-001";
	    	    g[1]="FRESH";
	    	    g[2]="ADDON_01";
	    	    g[3]="Brandnew";
	    	    g[4]="0";
	    	    g[5]="0";
	    	    
	    	return g;    
		}
		else {
			String g[]=new String[6];
    	    g[0]="MOT-PRD-001";
    	    g[1]="RENEWAL OF OTHERS";
    	    g[2]="ADDON_01";
    	    g[3]=Regyr;
    	    g[4]="1";
    	    g[5]="0";
    	   return g; 
		}
		
	}
	public String[] ifBykeRegyr(String Regyr,String Claim) {
		if(Regyr.equals("Brandnew")) {
			String g[]=new String[6];
	    	    g[0]="MOT-PRD-002";
	    	    g[1]="FRESH";
	    	    g[2]="ADDON_01";
	    	    g[3]="Brandnew";
	    	    g[4]="0";
	    	    g[5]="0";
	    	    
	    	return g;    
		}
		else {
			String g[]=new String[6];
    	    g[0]="MOT-PRD-002";
    	    g[1]="RENEWAL OF OTHERS";
    	    g[2]="ADDON_01";
    	    g[3]=Regyr;
    	    g[4]="1";
    	    g[5]="0";
    	   return g; 
		}
		
	}

	public String[] Title(String prefix) {
		if(prefix.equals("Mr.")) {
			String g[]=new String[2];
			g[0]="1";
			g[1]="M";
			
			return g;
		}
		else if(prefix.equals("Mrs.")) {
			String g[]=new String[2];
			g[0]="2";
			g[1]="F";
			
			return g;
		}
		else if(prefix.equals("Miss.")) {
			String g[]=new String[2];
			g[0]="4";
			g[1]="F";
			
			return g;
		}
		return null;
		
	}
	public String city(String RTOCODE) {
		String holdgetValue=null;
		try {
			Connection con=Db.myGetConnection();
			//String name="KINE";
			String query1 = "select RTOCITY from Shriram_RTOMASTER where RTOCODE= ?";
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.setString(1, RTOCODE);
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				String RTOCITY = rs.getString("RTOCITY");
				holdgetValue=RTOCITY;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(holdgetValue.isEmpty())
		{
			return null;
		}
		else
		{
			return holdgetValue;	
		}
		
		
	}
	public String insurer(String insurer) {
		String holdgetValue=null;
		try {
			Connection con=Db.myGetConnection();
			//String name="KINE";
			String query1 = "select CC_DESC from Shriram_Insurer where CC_DESC like ?";
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.setString(1, insurer+"%");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				String CC_DESC = rs.getString("CC_DESC");
				holdgetValue=CC_DESC;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(holdgetValue.isEmpty())
		{
			return null;
		}
		else
		{
			return holdgetValue;	
		}
	}
	
	
	//Religare
	
	public String[] TitleReligare(String title) {
		String g[]=new String[2];
		if(title.equals("Mr.")) {
			g[0]="MR";
			g[1]="MALE";
			
			return g;
		}
		else if(title.equals("Mrs.")) {
			g[0]="MS";
			g[1]="FEMALE";
			
			return g;
		}
		else if(title.equals("Miss.")) {
			g[0]="MS";
			g[1]="FEMALE";
			
			return g;
		}
		return null;
		
	}
	public String[] religare_disease(String disease) {
		String [] diseases=new String[3];
		if(disease.equals("asthma,")) {
			diseases[0]="H104";
			diseases[1]="HEDCFLEAFFOUR";
			diseases[2]="YES";
			return diseases;
		}
		else if(disease.equals("diabetes,")) {
			diseases[0]="H106";
			diseases[1]="HEDCFLEAFSIX";
			diseases[2]="YES";
			return diseases;
		}
		else if(disease.equals("heartailments,")) {
			diseases[0]="H102";
			diseases[1]="HEDCFLEAFTWO";
			diseases[2]="YES";
			return diseases;
		}
		else if(disease.equals("hypertension,")) {
			diseases[0]="H103";
			diseases[1]="HEDCFLEAFTHREE";
			diseases[2]="YES";
			return diseases;
		}
		else if(disease.equals("thyroid,")) {
			diseases[0]="H105";
			diseases[1]="HEDCFLEAFFIVE";
			diseases[2]="YES";
			return diseases;
		} else {
			diseases[0]="";
			diseases[1]="";
			diseases[2]="";
			return diseases;
		}
		
	}
	//---------------------apollo----------------------
	
		public static String[] Titleapollo(String salutation) {
			if (salutation.equals("Mr.")) {
				String g[] = new String[2];
				g[0] = "MR";
				g[1] = "1";

				return g;
			} else if (salutation.equals("Mrs.")) {
				String g[] = new String[2];
				g[0] = "MRS";
				g[1] = "2";

				return g;
			} else if (salutation.equals("Miss.")) {
				String g[] = new String[2];
				g[0] = "MISS";
				g[1] = "2";

				return g;
			} /*else if (salutation.equals("master.")) {
				String g[] = new String[2];
				g[0] = "MASTER";
				g[1] = "1";

				return g;
			}

			else if (salutation.equals("babygirl.")) {
				String g[] = new String[2];
				g[0] = "BABYGIRL";
				g[1] = "2";

				return g;
			} else if (salutation.equals("babyboy.")) {
				String g[] = new String[2];
				g[0] = "BABYBOY";
				g[1] = "1";

				return g;
			}
	*/
			return null;

		}
		
		
		

	//----------------------------------------------
	}
