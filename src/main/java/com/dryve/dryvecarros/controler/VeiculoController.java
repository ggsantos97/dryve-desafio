package com.dryve.dryvecarros.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dryve.dryvecarros.modelo.Veiculo;

@RestController
@RequestMapping( "/veiculos")
public class VeiculoController {
	
	
	@GetMapping()
	//produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
	@ResponseBody
	public ResponseEntity<Veiculo> buscaVeiculoPorPlaca(@RequestParam String placa){
		Veiculo ve = Veiculo.builder().placa(placa).build();
		return new ResponseEntity<Veiculo>(ve, HttpStatus.OK);
	}
	
//	@GetMapping()
//	//produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
//	@ResponseBody
//	public ResponseEntity<String> buscaVeiculo(){
//		return new ResponseEntity<String>("TESTE", HttpStatus.OK);
//	}

}
