<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div id="sidebar" class="sidebar                  responsive">
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'fixed')
            } catch (e) {
            }
        </script>


        <%--<ul class="nav nav-list">
            <li class="active">
                <a href="index.html">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Quản lý tòa nhà </span>
                </a>

                <b class="arrow"></b>
            </li>

        </ul><!-- /.nav-list -->--%>

        <%--<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
               data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>--%>

        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'collapsed')
            } catch (e) {
            }
        </script>
    </div>

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Danh sách tòa nhà</li>
                </ul><!-- /.breadcrumb -->


            </div>

            <div class="page-content">


                <%-- <div class="page-header">
                     <h1>
                         Tìm kiếm
                         <small>
                             <i class="ace-icon fa fa-angle-double-right"></i>
                             overview &amp; stats
                         </small>
                     </h1>
                 </div><!-- /.page-header -->--%>
                <div class="row">
                    <div class="col-xs-12 ">
                        <div class="widget-box ui-sortable-handle">
                            <div class="widget-header">
                                <h5 class="widget-title">Tìm kiếm</h5>

                                <div class="widget-toolbar">


                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>


                                </div>
                            </div>

                            <div class="widget-body" style="display: block;">
                                <div class="widget-main"
                                     style="font-family:'Times New Roman'">

                                    <form:form id="listForm" action="/admin/customer-list" method="GET"
                                               modelAttribute="model"
                                    >
                                        <div class="row">

                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-6">
                                                        <label class="name">Tên khách hàng</label>
                                                        <form:input path="fullname" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <label class="name">Di động</label>
                                                        <form:input path="phone" class="form-control"/>
                                                    </div>


                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <security:authorize access="hasRole('MANAGER')">
                                                        <div class="col-xs-6">
                                                            <label class="name"> Email</label>
                                                            <form:input path="email" class="form-control"/>
                                                        </div>
                                                        <div class="col-xs-6">
                                                            <label class="name">Nhân viên</label>
                                                            <form:select class="form-control" path="staffId">
                                                                <form:option value="">--Chọn nhân viên--</form:option>
                                                                <form:options items="${listStaffs}"/>
                                                            </form:select>
                                                        </div>
                                                    </security:authorize>


                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-6">
                                                        <button type="button" class="btn  btn-xs btn-danger "
                                                                id="btnSearchBuilding"
                                                                style="background-color: red;">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                                 height="16" fill="currentColor" class="bi bi-search"
                                                                 viewBox="0 0 16 16">
                                                                <path
                                                                        d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0">
                                                                </path>
                                                            </svg>
                                                            Tìm kiếm
                                                        </button>

                                                    </div>
                                                    <div class="col-xs-6">
                                                        <div class="pull-right">
                                                            <a href="/admin/customer-edit" title="Cập nhật khách hàng">
                                                                <i class="btn btn-info btn-"
                                                                   title="Thêm khách hàng">
                                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                                         height="16" fill="currentColor"
                                                                         class="bi bi-building-add" viewBox="0 0 16 16">
                                                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                                                    </svg>
                                                                </i>
                                                            </a>

                                                            <button class="btn btn-danger" title="xóa khách hàng"
                                                                    id="btnDeleteCustomer">
                                                                <svg
                                                                        xmlns="http://www.w3.org/2000/svg" width="16"
                                                                        height="16"
                                                                        fill="currentColor" class="bi bi-building-dash"
                                                                        viewBox="0 0 16 16">
                                                                    <path
                                                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                                                    <path
                                                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                                                    <path
                                                                            d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                                                </svg>
                                                            </button>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </form:form>

                                </div>


                            </div>


                            <!-- Bảng danh sách -->
                            <div style="font-family: 'Times New Roman'">
                                <div class="table-responsive">
                                    <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                                   requestURI="/admin/customer-list" partialList="true" sort="external"
                                                   size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                                                   id="tableList" pagesize="${model.maxPageItems}"
                                                   export="false"
                                                   class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                   style="margin: 3em 0 1.5em;">
                                        <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                        headerClass="center select-cell">
                                            <fieldset>
                                                <input type="checkbox" name="checkList" value="${tableList.id}"
                                                       id="checkbox_${tableList.id}" class="check-box-element"/>
                                            </fieldset>
                                        </display:column>
                                        <display:column headerClass="text-left" property="fullname"
                                                        title="Tên khách hàng"/>
                                        <display:column headerClass="text-left" property="phone"
                                                        title="Di động"/>
                                        <display:column headerClass="text-left" property="email"
                                                        title="Email"/>
                                        <display:column headerClass="text-left" property="demand"
                                                        title="Nhu cầu"/>
                                        <display:column headerClass="text-left" property="createdBy"
                                                        title="Người thêm"/>

                                        <display:column headerClass="text-left" property="createdDate"
                                                        title="Ngày thêm"/>
                                        <display:column headerClass="text-left" property="status"
                                                        title="Ngày thêm"/>
                                        <display:column headerClass="col-actions" title="Thao tác">
                                            <security:authorize access="hasRole('MANAGER')">
                                                <button class="btn btn-xs btn-success" title="Giao khach hang"
                                                        onclick="assignmentCustomer(${tableList.id})">
                                                    <i class="ace-icon glyphicon glyphicon-list"></i>
                                                </button>
                                            </security:authorize>
                                            <a href="/admin/customer-edit-${tableList.id}" title="Cap nhat khach hang"
                                               class="btn btn-xs btn-info">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </a>

                                            <button class="btn btn-xs btn-danger" title="xóa khach hang"
                                                    onclick="deleteCustomer(${tableList.id})">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>
                                        </display:column>
                                    </display:table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="modal fade" id="assignmentCustomerModal" role="dialog"
         style="font-family: Arial, sans-serif; font-size: 16px; color: #333; font-weight: bold;">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"
                        style="font-family: Arial, sans-serif; font-size: 16px; color: #333; font-weight: bold;">Danh
                        sách nhân viên</h4>
                </div>
                <div class="modal-body">
                    <table id="staffList" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Chọn</th>
                            <th>Tên nhân viên</th>


                        </tr>
                        </thead>

                        <tbody>
                        <%--  <tr>
                              <td class="center">
                                  <input type="checkbox" id="checkbox_1" value="1">
                              </td>
                              <td>Nguyễn Văn A</td>

                          </tr>
                          <tr>
                              <td class="center">
                                  <input type="checkbox" id="checkbox_2" value="2">
                              </td>
                              <td>Nguyễn Văn B</td>

                          </tr>--%>


                        </tbody>
                    </table>
                    <input type="hidden" id="customerId" name="customerId">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="btnassignmentCustomer">Giao khách hàng</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                </div>
            </div>

        </div>
    </div>
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
<script>
    function assignmentCustomer(customerId) {
        $('#assignmentCustomerModal').modal();
        loadStaff(customerId);
        $('#customerId').val(customerId);
    }

    function loadStaff(customerId) {
        $.ajax({
            type: 'GET',
            url: "/api/customer/" + customerId + "/staffsOfCustomer",
            //   data: JSON.stringify(data),
            //contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                var row = '';
                $.each(response.data, function (index, item) {
                    row += '<tr>';
                    row += '  <td class="center"> <input type="checkbox" value= ' + item.staffId + ' id=checkbox_' + item.staffId + ' class ="check-box-element" ' + item.checked + '/></td>';
                    row += '<td class="text-center">' + item.fullName + '</td>';
                    row += '</tr>';

                });
                $('#staffList tbody').html(row);
                console.info("success");
            },
            error: function (response) {
                console.log("error");
                window.location.href = "<c:url value = "/admin/customer-list?message=error" />";
            }
        });

    }


    $('#btnSearchBuilding').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    })
    $('#btnassignmentCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        data['customerId'] = $('#customerId').val();
        var staffs = $('#staffList').find(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        if (data['staffs'] != "") {
            assignment(data)

        }
        ;
        console.log("ok");
    })

    function assignment(data) {
        $.ajax({
            type: 'POST',
            url: "/api/customer/assignmentOfCustomer",
            data: JSON.stringify(data),
            contentType: 'application/json',
            //  dataType: 'json',
            success: function (response) {
                console.info("success");
                window.location.href = "/admin/customer-list?message=succes";
            },
            error: function (response) {
                console.log("error");
                window.location.href = "/admin/customer-list?message=error";
            }
        });
    }

    $('#btnDeleteCustomer').click(function (e) {
        e.preventDefault();
        var data = {};
        data['customerId'] = $('#customerId').val();
        var customerIds = $('#tableList').find(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteCustomer(customerIds);
        console.log("ok");
    })

    function deleteCustomer(data) {
        $.ajax({
            type: 'Delete',
            url: "/api/customer/" + data,
            data: JSON.stringify(data),
            contentType: 'application/json',
            //    dataType: 'json',
            success: function (response) {
                window.location.href = "/admin/customer-list?message=succes";
            },
            error: function (response) {
                console.log("error");
            }
        });
    }

</script>
</body>
</html>