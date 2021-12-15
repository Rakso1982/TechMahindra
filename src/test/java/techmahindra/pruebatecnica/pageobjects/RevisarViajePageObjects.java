package techmahindra.pruebatecnica.pageobjects;

import java.util.Map;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import techmahindra.pruebatecnica.utilities.Utilidades;

@DefaultUrl ("https://www.vivaair.com/")

public class RevisarViajePageObjects extends PageObject {

	Utilidades utilidades;
	
	String strFechaP1  = "//div[@class='calendar__date_picker']//div[span[text() = '";
	String strFechaP2  = "'] and span[text() = '";
	String strFechaP3  = "']]/following-sibling::*[2]/div[";
	String strSoloIda  = "//span[contains(text(), 'Solo ida')]";
	String strOrigen   = "//input[@id='station' and not(@class='search__input')]";
	String strDestino  = "//input[@id='filter-station-second' and not(@class='search__input')]";
	String strCoockies = "//button[@class='cookies-info-bar__button btn-blue']";
	String btnBuscar   = "//button[@class='btn-blue ibe__button__desktop ibe__button']//span[@class='ibe__inputs-button']";
	
	public void seleccionarSoloIda() {
		find(By.xpath(strSoloIda)).waitUntilClickable().click();
	}

	public void seleccionarOrigen(String origen) {
		find(By.xpath(strOrigen)).waitUntilClickable().click();
		seleccionarCiudad(origen);
	}
	
	public void seleccionarDestino(String destino) {
		find(By.xpath(strDestino)).waitUntilClickable().click();
		seleccionarCiudad(destino);
	}

	public void seleccionarFecha(String strFechaI) {
		String strFecha = armarXpathFecha(strFechaI);
		
		find(By.xpath(strFecha)).waitUntilClickable().click();
	}
	
	public String armarXpathFecha(String strFechaI) {
		String[] lstFecha = strFechaI.split(",");
		return strFechaP1 + lstFecha[1] + strFechaP2 + lstFecha[2] + strFechaP3 + lstFecha[0] + "]";
	}
	
	public void  seleccionarCiudad(String strCiudad) {
		find(By.xpath("//div[text()='" + strCiudad +"']")).waitUntilClickable().click();
	}

	public boolean mensajeCookies() {
		return find(By.xpath(strCoockies)).isVisible();
	}

	public void aceptarCookies() {
		find(By.xpath(strCoockies)).waitUntilClickable().click();
	}

	public void buscarVuelos() {
		find(By.xpath(btnBuscar)).waitUntilClickable().click();
	}
	
	public Map<Integer, String> obtenerListaVuelos() {
		return utilidades.obtenerListaVuelos();
	}
	
	public boolean validarOrdenPrecios() {
		return true;
	}	
}
