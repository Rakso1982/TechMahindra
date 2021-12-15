package techmahindra.pruebatecnica.steps;

import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.MatcherAssert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import techmahindra.pruebatecnica.pageobjects.RevisarViajePageObjects;
import techmahindra.pruebatecnica.utilities.Utilidades;

public class RevisarViajeSteps {

	RevisarViajePageObjects revisarViajePageObjects;
	Utilidades utilidades;
	
	@Step
	public void abrirUrlVivaAir() {
		revisarViajePageObjects.open();
	}

	@Step
	public void seleccionarSoloIda() {
		Serenity.takeScreenshot();
		if (revisarViajePageObjects.mensajeCookies()){
			revisarViajePageObjects.aceptarCookies();
		}
		revisarViajePageObjects.seleccionarSoloIda();
		Serenity.takeScreenshot();
	}
	
	@Step
	public void seleccionarOrigen(String strOrigen) {
		revisarViajePageObjects.seleccionarOrigen(strOrigen);
		Serenity.takeScreenshot();
	}

	@Step
	public void seleccionarDestino(String strDestino) {
		revisarViajePageObjects.seleccionarDestino(strDestino);
		Serenity.takeScreenshot();
	}

	@Step
	public void seleccionarFecha(String strFecha) {
		revisarViajePageObjects.seleccionarFecha(strFecha);
		Serenity.takeScreenshot();
	}
	
	@Step
	public void buscarVuelos() {
		revisarViajePageObjects.buscarVuelos();
		Serenity.takeScreenshot();
	}

	@Step
	public void validarOrdenPrecios() {
		Map<Integer, String> listaVuelos = new HashMap<>();
		Map<Integer, Integer> valoresSinOrdenar = new HashMap<>();
		Map<Integer, Integer> valoresOrdenados = new HashMap<>();
		int cont = 1;
		
		listaVuelos = revisarViajePageObjects.obtenerListaVuelos();
		revisarViajePageObjects.validarOrdenPrecios();
		valoresSinOrdenar = utilidades.obtenerValoresSinOrdenar(listaVuelos);
		valoresOrdenados = utilidades.obtenerValoresOrdenados(valoresSinOrdenar);
		
		Serenity.takeScreenshot();
		
		for (Entry<Integer, Integer> entry : valoresOrdenados.entrySet()) {
			MatcherAssert.assertThat(valoresOrdenados.get(cont), is(entry.getValue()));
			cont += 1;
		}
	}
}
