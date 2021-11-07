<%-- 
    Document   : leftBar
    Created on : 06-11-2021, 16:49:38
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listCategory}" var="c">
                <li class="list-group-item text-white ${cateActive == c.cateId ? "active":""}"><a href="category?cid=${c.cateId}">${c.cateName}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastProduct.image}" />
            <h5 class="card-title">${lastProduct.name}</h5>
            <p class="card-text">${lastProduct.title}</p>
            <p class="bloc_left_price">${lastProduct.price} $</p>
        </div>
    </div>
    </div>
