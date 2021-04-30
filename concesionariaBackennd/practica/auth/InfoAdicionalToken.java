package com.concesionaria.practica.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.concesionaria.practica.entity.Cliente;
import com.concesionaria.practica.models.services.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	
	@Autowired
	private IClienteService iClienteService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Cliente cliente = iClienteService.findByUsuario(authentication.getName());
		
		Map<String, Object> info = new HashMap<>();
		
		info.put("id", cliente.getIdCliente());
		info.put("nombre", cliente.getNombre());
		info.put("apellido", cliente.getApellidoA());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
