package com.proyectofinal.backend.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.proyectofinal.backend.entity.models.Users;
import com.proyectofinal.backend.service.IUserService;

@Component
public class AditionalInfoToken implements TokenEnhancer {
	
	@Autowired
	private IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Users usuario = userService.findByEmail(authentication.getName());
		Map<String, Object> info = new HashMap<>();		
		info.put("nombre", usuario.getNombre());
		info.put("apellido", usuario.getApellidos());
		info.put("telefono", usuario.getTelefono());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
