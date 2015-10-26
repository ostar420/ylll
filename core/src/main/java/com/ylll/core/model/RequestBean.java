/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.model;

/**
 *
 * @author YL
 * @param <T>
 */
public class RequestBean<T> {
    
    private String  project_seq;
    private String  project_version;
    private T data ;
 
    /**
     * @return the project_seq
     */
    public String getProject_seq() {
        return project_seq;
    }

    /**
     * @param project_seq the project_seq to set
     */
    public void setProject_seq(String project_seq) {
        this.project_seq = project_seq;
    }

    /**
     * @return the project_version
     */
    public String getProject_version() {
        return project_version;
    }

    /**
     * @param project_version the project_version to set
     */
    public void setProject_version(String project_version) {
        this.project_version = project_version;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

   
}
