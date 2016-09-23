package com.dentalapp.services;

import java.io.FileInputStream;
import java.util.Map;

public interface DocumentOperations {
	
	public FileInputStream createWordDoument(Map<String, String[]> requestValues);

}
