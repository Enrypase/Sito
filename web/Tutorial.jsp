<%-- 
    Document   : Tutorial
    Created on : 24-gen-2021, 19.39.15
    Author     : Enryp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="green">
        
        <!-- Attributi -->
        <%@ page errorPage="url" %>
        <%@ include file="altroFile.jsp" %>
        <%@taglib uri="esempio" prefix="fx" %>
        <!-- Aggiunge il tag <fx:esempio> -->
        
        <!-- DIRECTIVE Per fare import di librerie -->
        <%@ page import="java.util.Date, java.sql.*" %>
        
        <%!  //DECLARATION Serve per creare metodi, aggiungere variabili pubbliche fuori dal processRequest
            int value = 0;
        %>
        
        <%  //SCRIPTLET
            //Va in automatico nel processRequest del servlet. Tutte le variabili sono date da TomCat
            out.println("Ciao!");

            int i = 1;
            int j = 2;
            out.println(i + j);
        %>
        
        <!-- Per fare .out valore -->
        <%= "I: " + i %>
        
        <!-- Altri oggetti impliciti... -->
        <%
            //Per condividere un valore in tutta le pagine
            pageContext.setAttribute("nome", "Enrico", PageContext.SESSION_SCOPE);
        %>
        
        <!-- Gestione errori -->
        <%@ page errorPage="error.jsp" %> <!-- Ora si manda la pagina se c'è un errore -->
        <%
            int k = 9/0;
        %>
        
        <!-- Da inserire nell'altra pagina -->
        <%@ page isErrorPage="true" %>
        <%= exception %> <!-- Si applica solo alle isErrorPage -->
        
        <!-- MVC = Model View Controller -->
        <!-- MAI SCRIVERE BUSINESS LOGIC IN JSP (Codice Finale Importante) -->
        <!-- Richiesta -> Controller (servlet) Qui ci va la business logic, mandando un modello con dei dati dentro (POJO Plain Old Java Object) -> View (JSP) -->
        <!-- Controller non deve mai consultare il DB. Controller -> Service class (con roba JDBC) -> DAO (Data Axcess Object) -> DB e mandare risposta -->
    </body>
</html>
