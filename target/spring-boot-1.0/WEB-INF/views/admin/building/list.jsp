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

                                    <form:form id="listForm" action="${buildingListURL}" method="GET"
                                               modelAttribute="modelSearch">
                                        <div class="row">

                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-6">
                                                        <label class="name">Tên tòa nhà</label>
                                                            <%--<input type="text" class="form-control" id="name" name="name"
                                                                   value="">--%>
                                                        <form:input path="name" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <label class="name">Diện tích sàn</label>
                                                            <%--<input type="number" class="form-control" name="floorArea"
                                                                   value="">--%>
                                                        <form:input path="floorArea" class="form-control"/>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-2">
                                                        <label class="name">Quận</label>
                                                        <form:select class="form-control" path="district">
                                                            <form:option value="">---chọn quận---</form:option>
                                                            <form:options items="${districts}"></form:options>

                                                        </form:select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class="name">Phường</label>
                                                        <form:input path="ward" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class="name">Đường</label>
                                                        <form:input path="street" class="form-control"/>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-4">
                                                        <label class="name">Số tầng hầm</label>
                                                        <form:input path="numberOfBasement" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label class="name">Hướng</label>
                                                        <form:input path="direction" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label class="name">Hạng</label>
                                                        <form:input path="level" class="form-control"/>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-3">
                                                        <label class="name">Diện tích từ</label>
                                                        <form:input path="areaFrom" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class="name">Diện tích đến</label>
                                                        <form:input path="areaTo" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class="name"> Giá thuê từ</label>
                                                        <form:input path="rentPriceFrom" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class="name">Giá thuê đến</label>
                                                        <form:input path="rentPriceTo" class="form-control"/>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-5">
                                                        <label class="name">Tên quản lý</label>
                                                        <form:input path="managerName" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class="name">Điện thoại quản lý</label>
                                                        <form:input path="managerPhone" class="form-control"/>
                                                    </div>
                                                    <div class="col-xs-2">
                                                        <label class="name">Nhân viên</label>
                                                        <form:select class="form-control" path="staffId">
                                                            <form:option value="">--Chọn nhân viên--</form:option>
                                                            <form:options items="${listStaffs}"/>
                                                        </form:select>
                                                    </div>


                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12 ">
                                                    <div class="col-xs-6">
                                                        <form:checkboxes path="typeCode" items="${typeCodes}"/>
                                                    </div>
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
                                                </div>
                                            </div>

                                        </div>
                                    </form:form>

                                </div>


                                <div class="pull-right">
                                    <a href="/admin/building-edit">
                                        <button class="btn btn-info btn-" title="thêm tòa nhà">
                                            <svg
                                                    xmlns="http://www.w3.org/2000/svg"
                                                    width="16" height="16"
                                                    fill="currentColor"
                                                    class="bi bi-building-add"
                                                    viewBox="0 0 16 16">
                                                <path
                                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                                <path
                                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                                <path
                                                        d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                            </svg>
                                        </button>
                                    </a>

                                    <button class="btn btn-danger" title="xóa tòa nhà" id="btnDeleteBuilding">
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


                            <!-- Bảng danh sách -->
                            <div style="font-family: 'Times New Roman'">
                                <table id="tableList" style="margin: 3em 0
                                 0"
                                       class="table table-striped table-bordered table-hover" style="margin: 3em 0 0">
                                    <thead>
                                    <tr>
                                        <th class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace" name="checkList" value="">
                                                <span class="lbl"></span>
                                            </label>
                                        </th>
                                        <th>Tên tòa nhà</th>
                                        <th>Địa chỉ</th>
                                        <th>Số tầng hầm</th>
                                        <th>Tên quản lý</th>
                                        <th>Số điện thoại quản lý</th>
                                        <th>Điện tích sàn</th>
                                        <th>Điện tích trống</th>
                                        <th>Điện tích thuê</th>
                                        <th>Phí môi giới</th>
                                        <th>Phí dịch vụ</th>
                                        <th>Giá thuê</th>
                                        <th>Thao tác</th>


                                    </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="item" items="${buildingList} ">
                                        <tr>
                                            <td class="center">
                                                <label class="pos-rel">
                                                    <input type="checkbox" class="ace" name="checkList"
                                                           value="${item.id}">


                                                </label>
                                            </td>
                                            <td>${item.name}</td>
                                            <td>${item.numberOfBasement}</td>
                                            <td>${item.address}</td>
                                            <td>${item.managerName}</td>
                                            <td>${item.managerPhone}</td>
                                            <td>${item.floorArea}</td>
                                            <td>${item.emptyArea}</td>
                                            <td>${item.rentPrice}</td>
                                            <td>${item.serviceFee}</td>
                                            <td>${item.brokerageFee}</td>

                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                                            onclick="assignmentBuilding(${item.id})">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                             height="16" fill="currentColor"
                                                             class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                                            <path
                                                                    d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                                        </svg>
                                                    </button>
                                                    <a href="/admin/building-edit-${item.id}" title="Sửa tòa nhà">
                                                        <button class="btn btn-xs btn-info">
                                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                        </button>
                                                    </a>

                                                    <button class="btn btn-xs btn-danger" title="xóa tòa nhà"
                                                            onclick="deleteBuilding(${item.id})">
                                                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                    </button>


                                                </div>


                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="modal fade" id="assignmentBuildingModal" role="dialog"
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
                    <input type="hidden" id="buildingId" name="buildingId">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" id="btnassignmentBuilding">Giao tòa nhà</button>
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
    function assignmentBuilding(buildingId) {
        $('#assignmentBuildingModal').modal();
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);
    }

    function loadStaff(buildingId) {
        $.ajax({
            type: 'GET',
            url: "/api/building/" + buildingId + "/staffs",
            data: JSON.stringify(data),
            contentType: 'application/json',
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
                window.location.href = "<c:url value = "/admin/building-list?message=error" />";
            }
        });

    }

    $('#btnassignmentBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
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
            type: 'GET',
            url: "/api/building/" + "assignment",
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {

                console.info("success");
            },
            error: function (response) {
                console.log("error");
                window.location.href = "<c:url value = "/admin/building-list?message=error" />";
            }
        });

    }

    $('#btnSearchBuilding').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    })

    function deleteBuilding(id) {
        var buildingId = [id];
        deleteBuildings(buildingId);


    }

    $('#btnDeleteBuilding').click(function (e) {
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var buildingIds = $('#tableList').find(' tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        deleteBuildings(buildingIds);
        console.log("ok");
    })

    function deleteBuildings(data) {
        $.ajax({
            type: 'Delete',
            url: "/api/building/" + data,
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                console.log("success");
            },
            error: function (response) {
                console.log("error");
            }
        });

    }
</script>
</body>
</html>
