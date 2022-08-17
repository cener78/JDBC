package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;




public class JdbcQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
	// 1-ilgili driveri yuklemeliyiz(tv nin fisini tak, mesela baska alet calismasin, ne calisacagini bilsin

		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2- Baglanti olusturmaliyiz (mesela netflixin sifresini girip acmak gibi)
	
		
	Connection con	= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "120292"); //bunun sonuna createstatement yapabilirdim ama ustteki con u silmek kosuluyla
		
	// 3- SQL komutlari icin bir statement nesnesi olustur(mesela her kanal icin kumandada yada tv de kanal olusturma gibi birsey)	
		
    Statement st = con.createStatement();
		
	// SQL ifadeleri yazabilir ve calistirabiliriz (yani kumandada 1 e nbasarim ve trt1 gelir)	
	
		
    ResultSet veri=   st.executeQuery("SELECT isim,maas FROM personel WHERE id=123456789");	
		
	// 5- sonuclari aldik ve isledik	
	
		while (((ResultSet) veri).next()) {
        System.out.println(veri.getString("isim") + veri.getInt("maas"));
			
        System.out.println("Personel Adi : " + veri.getString(1)+"\n"+"Maas : "+veri.getInt(2) + " €");
         
		}
		
		
		
	// 6- Olusturulan nesneleri bellekten kaldiralim
		con.close();
		st.close();
		veri.close();
		
	
		
		

	}

}
