<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
 <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Online Commerce</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Manage
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCategory"
                    aria-expanded="true" aria-controls="collapseCategory">
                    <i class="fas fa-fw fa-list"></i>
                    <span>Category</span>
                </a>
                <div id="collapseCategory" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Category Management:</h6>
                        <a class="collapse-item" href="${cp}/admin/category/add">Add</a>
                        <a class="collapse-item" href="${cp}/admin/category/show">Show</a>
                    </div>
                </div>
            </li>
            
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseProduct"
                    aria-expanded="true" aria-controls="collapseProduct">
                    <i class="fas fa-fw fa-box"></i>
                    <span>Products</span>
                </a>
                <div id="collapseProduct" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Product Management:</h6>
                        <a class="collapse-item" href="${cp}/admin/product/add">Add</a>
                        <a class="collapse-item" href="${cp}/admin/product/show">Show</a>
                    </div>
                </div>
            </li>
			
			
			<li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUser"
                    aria-expanded="true" aria-controls="collapseUser">
                    <i class="fas fa-fw fa-user"></i>
                    <span>User</span>
                </a>
                <div id="collapseUser" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">User Management:</h6>
                        <a class="collapse-item" href="${cp}/admin/user/add">Add</a>
                        <a class="collapse-item" href="${cp}/admin/user/show">Show</a>
                    </div>
                </div>
            </li>
			
			<li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseNotice"
                    aria-expanded="true" aria-controls="collapseNotice">
                    <i class="fas fa-fw fa-bell"></i>
                    <span>Notice</span>
                </a>
                <div id="collapseNotice" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Notice Management:</h6>
                        <a class="collapse-item" href="${cp}/admin/notice/add">Add</a>
                        <a class="collapse-item" href="${cp}/admin/notice/show">Show</a>
                    </div>
                </div>
            </li>
	

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Addons
            </div>

           

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="${cp}/admin/order/show">
                    <i class="fas fa-fw fa-cart-arrow-down"></i>
                    <span>Order</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="${cp}/admin/event/add">
                    <i class="fas fa-fw fa-calendar-check"></i>
                    <span>Events</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="${cp}/admin/message/send">
                    <i class="fas fa-fw fa-envelope"></i>
                    <span>Messages</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>