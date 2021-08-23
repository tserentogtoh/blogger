/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.blogger.dto;

/**
 *
 * @author tseke
 */
public class ResponseDTO {
    
    public boolean success;
    public String message;
    
    public ResponseDTO(boolean success){
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public static ResponseDTO getInstance(boolean success){
        return new ResponseDTO(success);
    }
    
    public static ResponseDTO getInstance(boolean success, String message){
        
        ResponseDTO response = new ResponseDTO(success);
        response.setMessage(message);
        return response;
        
    }
}
