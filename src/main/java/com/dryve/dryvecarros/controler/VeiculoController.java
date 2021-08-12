package com.dryve.dryvecarros.controler;

import com.dryve.dryvecarros.adapter.FipeIntegracaoRest;
import com.dryve.dryvecarros.dto.VeiculoDTO;
import com.dryve.dryvecarros.dto.VeiculoResponseDTO;
import com.dryve.dryvecarros.exception.ErroNegocialException;
import com.dryve.dryvecarros.service.IVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( "/veiculos")
public class VeiculoController {

	@Autowired
	private IVeiculoService service;

	@Autowired
	FipeIntegracaoRest fipeIntegracaoRest;
	
//	@GetMapping()
//	@ResponseBody
//	public ResponseEntity<VeiculoResponseDTO> buscaVeiculoPorPlaca(@RequestParam String idMarca,
//																   @RequestParam String idModelo,
//																   @RequestParam String ano) throws ErroNegocialException {
//		VeiculoResponseDTO ve = service.salvar();
//		//fipeIntegracaoRest.consultaPrecoFipe(idMarca, idModelo, ano);
//		return new ResponseEntity<VeiculoResponseDTO>(ve, HttpStatus.OK);
//	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<VeiculoResponseDTO> buscaVeiculo(@RequestBody @Valid VeiculoDTO dto) throws ErroNegocialException {
		VeiculoResponseDTO response = service.salva(dto);
		return new ResponseEntity<VeiculoResponseDTO>(response, HttpStatus.CREATED);
	}

}
