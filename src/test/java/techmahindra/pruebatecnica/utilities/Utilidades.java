package techmahindra.pruebatecnica.utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Utilidades extends PageObject {

	String lstVuelos   = "//app-flight-results/app-flight";
	
	public Map<Integer, String> obtenerListaVuelos(){
		int cont = 1;
		Map<Integer, String> mapOriginal = new HashMap<>();
		
		List<String> lista = findAll(lstVuelos)
				.stream()
				.map(WebElementFacade::getText)
				.collect(Collectors.toList());
		
		
		for (String lis:lista) {				
			mapOriginal.put(cont, lis);
			cont += 1;
		}
		return mapOriginal;
	}
	
	public Map<Integer, Integer> obtenerValoresSinOrdenar(Map<Integer, String> mapOriginal){
		Map<Integer, Integer> mapSinOrdenar = new HashMap<>();
		
		for (var entry : mapOriginal.entrySet()) {
			String[] divLista = entry.getValue().split("\\r?\\n");
			int longitud = divLista.length;
			
			int valor = Integer.parseInt(divLista[longitud - 1].trim().split("\\s+")[0].replace(".", ""));
			
			mapSinOrdenar.put(entry.getKey(), valor);
		}
		
		return mapSinOrdenar;
	}
	
	public Map<Integer, Integer> obtenerValoresOrdenados(Map<Integer, Integer> mapSinOrdenar){
		Map<Integer, Integer> mapOrdenado = new HashMap<>();
		
		mapOrdenado = mapSinOrdenar.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByValue())
				  .collect(Collectors.toMap(
				    Map.Entry::getKey, 
				    Map.Entry::getValue, 
				    (viejo, nuevo) -> viejo, LinkedHashMap::new));
		
		return mapOrdenado;
	}
	
}
