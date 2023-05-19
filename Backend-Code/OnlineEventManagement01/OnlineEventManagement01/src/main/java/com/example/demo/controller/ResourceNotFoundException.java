package com.example.demo.controller;

public class ResourceNotFoundException extends Exception 
{
	public ResourceNotFoundException(String message){
        super(message);
    }

}
