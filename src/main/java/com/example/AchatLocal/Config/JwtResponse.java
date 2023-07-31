package com.example.AchatLocal.Config;

import java.io.Serializable;

import com.example.AchatLocal.Model.Role;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String token;
	private final Role role;

	}