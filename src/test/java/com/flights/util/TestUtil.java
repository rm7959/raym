package com.flights.util;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestUtil {
	public static final ObjectMapper MAPPER = new ObjectMapper();
	static {
		MAPPER.registerModule(new Jdk8Module());
		MAPPER.registerModule(new JavaTimeModule());
	}

	public static String getJsonString(String fileName) {
		try {
			return new String(Files.readAllBytes(Paths.get(fileName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
