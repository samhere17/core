<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en-IN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <%@ include file="styles.jsp" %>

        <title>${systemConfig.applicationName}</title>
        
    </head>

    <body>
        <header>
			<!--[if lt IE 9]>
				<div class="alert alert-warning text-center">
					<h5>
						<strong>PLEASE UPGRADE YOUR BROWSER FOR THE BEST EXPERIENCE.</strong>
						<br>
						<strong>YOU BROWSER IS OBSOLETE AND DOES NOT SUPPORT THE NEW WEB STANDARDS.</strong>
					</h5>
				</div>
			<![endif]-->

            <%@ include file="header.jsp" %>
        </header>

        <div class="container-fluid">
            <div class="row">
                <%@ include file="aside.jsp" %>
                <main class="col-md-9">
