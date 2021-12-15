package techmahindra.pruebatecnica.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import techmahindra.pruebatecnica.steps.RevisarViajeSteps;

public class RevisarViajeDefinition {

	@Steps
	RevisarViajeSteps revisarViajeSteps;
	
	@Given("Ingreso a la web de vivaair")
	public void ingresoALaWebDeVivaair() {
		revisarViajeSteps.abrirUrlVivaAir();
	}
	
	@When("Selecciono solo ida")
	public void seleccionoSoloIda() {
		revisarViajeSteps.seleccionarSoloIda();
	}

	@When("Ingreso el origen {string}")
	public void ingresoElOrigen(String strOrigen) {
		revisarViajeSteps.seleccionarOrigen(strOrigen);
	}

	@When("Ingreso el destino {string}")
	public void ingresoElDestino(String strDestino) {
		revisarViajeSteps.seleccionarDestino(strDestino);
	}

	
	@When("Ingreso la fecha de ida {string}")
	public void ingresoLaFechaDeIda(String strFecha) {
		revisarViajeSteps.seleccionarFecha(strFecha);
	}
	
	@When("Busco vuelos disponibles")
	public void buscoVuelosDisponibles() {
		revisarViajeSteps.buscarVuelos();
	}
	

	@Then("Valido orden de los precios de menor a mayor")
	public void validoOrdenDeLosPreciosDeMenorAMayor() {
		revisarViajeSteps.validarOrdenPrecios();
	}
	
}
