package br.com.projetos.udemy;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo));
		return sum;
		
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		
		String number = replaceAll(strNumber);
		if (isNumeric(strNumber)) {
			return Double.parseDouble(number);
		}
		
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		
		String number = replaceAll(strNumber);
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	private String replaceAll(String strNumber) { 
		return strNumber.replaceAll(",", ".");
	}
}
