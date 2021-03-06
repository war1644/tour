package com.lxs.notification.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.0-milestone1
 * 2014-01-07T14:49:30.734+08:00
 * Generated source version: 3.0.0-milestone1
 * 
 */
@WebService(targetNamespace = "http://www.lxs.com", name = "INotificationServiceWs")
@XmlSeeAlso({})
public interface INotificationServiceWs {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sendBroadcast", targetNamespace = "http://www.lxs.com", className = "com.lxs.SendBroadcast")
    @WebMethod
    @ResponseWrapper(localName = "sendBroadcastResponse", targetNamespace = "http://www.lxs.com", className = "com.lxs.SendBroadcastResponse")
    public java.lang.String sendBroadcast(
        @WebParam(name = "title", targetNamespace = "")
        java.lang.String title,
        @WebParam(name = "message", targetNamespace = "")
        java.lang.String message,
        @WebParam(name = "uri", targetNamespace = "")
        java.lang.String uri
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sendNotifcationToUsers", targetNamespace = "http://www.lxs.com", className = "com.lxs.SendNotifcationToUsers")
    @WebMethod
    @ResponseWrapper(localName = "sendNotifcationToUsersResponse", targetNamespace = "http://www.lxs.com", className = "com.lxs.SendNotifcationToUsersResponse")
    public java.lang.String sendNotifcationToUsers(
        @WebParam(name = "users", targetNamespace = "")
        java.lang.String users,
        @WebParam(name = "title", targetNamespace = "")
        java.lang.String title,
        @WebParam(name = "message", targetNamespace = "")
        java.lang.String message,
        @WebParam(name = "uri", targetNamespace = "")
        java.lang.String uri
    );
}
