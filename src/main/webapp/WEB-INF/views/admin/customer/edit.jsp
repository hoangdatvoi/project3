<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm tòa nhà</title>
    <!-- Include your CSS files here -->
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <!-- Breadcrumbs -->
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
        </div>

        <!-- Page Content -->
        <div class="page-content">
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <form:form modelAttribute="customerEdit" id="listForm" method="GET">
                    <div class="col-xs-12 ">
                        <!-- Form inputs -->
                        <!-- Tên tòa nhà -->
                        <form class="form-horizontal" role="form"
                        >
                            <div class="form-group">
                                <label class="col-xs-3">Tên</label>
                                <div class="col-xs-9">
                                    <form:input path="fullname" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Số điện thoại</label>
                                <div class="col-xs-9">
                                    <form:input path="phone" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Email</label>
                                <div class="col-xs-9">
                                    <form:input path="email" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Tên công ty</label>
                                <div class="col-xs-9">
                                    <form:input path="companyName" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3">Nhu cầu</label>
                                <div class="col-xs-9">
                                    <form:input path="demand" class="form-control"/>
                                </div>
                            </div>

                            <!-- Quận -->
                            <div class="form-group">
                                <label class="col-xs-3">Tình trạng </label>
                                <div class="col-xs-9">
                                    <form:select class="form-control" path="status">
                                        <form:option value="">---Chọn tình trang---</form:option>
                                        <form:options items="${status}"/>
                                    </form:select>
                                </div>
                            </div>
                            <!-- Phường -->


                            <!-- Buttons -->
                            <div class="form-group">
                                <label class="col-xs-3"></label>
                                <div class="col-xs-9">
                                    <c:if test="${empty customerEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Thêm
                                            khách hàng
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>

                                    </c:if>
                                    <c:if test="${ not empty customerEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Cập
                                            nhật khách hàng
                                        </button>
                                        <button type="button" class="btn btn-primary" id="btnCancel">Hủy thao tác
                                        </button>

                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="buildingId"/>
                        </form>
                    </div>
                </form:form>
                <c:forEach var="item" items="${transactionType}">
                    <div class="col-xs-12">
                        <div class="col-sm-12">
                            <h3 class="header smaller lighter blue">${item.value}</h3>
                            <button class="btn btn-lg btn-primary"
                                    onclick="transactionType('${item.key}',${customerEdit.id})">
                                <i class="orange ace-icon fa fa-location-arrow bigger-130"></i>
                                Add
                            </button>
                        </div>
                        <c:if test="${item.key=='CSKH'}">
                            <div class="col-xs-12">
                                <table id="simple-table" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Ngày tạo</th>
                                        <th>Người tạo</th>
                                        <th>Ngày sửa</th>
                                        <th>Người sửa</th>
                                        <th>Chi tiết giao dịch</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${transactionCSKH}">
                                        <tr>
                                            <td>${item.createdDate}</td>
                                            <td>${item.createdBy}</td>
                                            <td>${item.modifiedDate}</td>
                                            <td>${item.modifiedBy}</td>
                                            <td>${item.note}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                                            onclick="UpdateTransaction(${item.id},'${item.code}','${item.customerId}','${item.note}')">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>

                        <c:if test="${item.key=='DDX'}">
                            <div class="col-xs-12">
                                <table id="simple-table1" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Ngày tạo</th>
                                        <th>Người tạo</th>
                                        <th>Ngày sửa</th>
                                        <th>Người sửa</th>
                                        <th>Chi tiết giao dịch</th>
                                        <th>Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${transactionDDX}">
                                        <tr>
                                            <td>${item.createdDate}</td>
                                            <td>${item.createdBy}</td>
                                            <td>${item.modifiedDate}</td>
                                            <td>${item.modifiedBy}</td>
                                            <td>${item.note}</td>
                                            <td>
                                                <div class="hidden-sm hidden-xs btn-group">
                                                    <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                                            onclick="UpdateTransaction(${item.id},'${item.code}','${item.customerId}','${item.note}')">
                                                        <i class="ace-icon glyphicon glyphicon-list"></i>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>

                    </div>


                </c:forEach>
            </div><!-- /.row -->
        </div><!-- /.page-content -->
        <div class="modal fade" id="transactionTypeModal" role="dialog"
             style="font-family: Arial, sans-serif; font-size: 16px; color: #333; font-weight: bold;">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"
                            style="font-family: Arial, sans-serif; font-size: 16px; color: #333; font-weight: bold;">
                            Nhập giao dịch</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group has-success">
                            <label for="transactionDetail" class="col-xs-12 col-sm-3 control-label no-padding-right">Chi
                                tiet giao dich</label>
                            <div class="col-xs-12 col-sm-9">
                                <span class="block input-icon input-icon-right">
                                    <input type="text" id="transactionDetail" class="width-100" value="">
                                </span>
                            </div>
                        </div>
                        <input type="hidden" name="customerId" id="customerId" value="">
                        <input type="hidden" name="code" id="code" value="">
                        <input type="hidden" name="id" id="id" value="">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="btnAddOrUpdateTransaction">Thêm giao dịch
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                    </div>
                </div>

            </div>
        </div>

    </div><!-- /.main-content-inner -->
</div><!-- /.main-content -->

<!-- Include your JavaScript libraries here -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function transactionType(code, customerId) {
        $('#transactionTypeModal').modal();
        $('#customerId').val(customerId);
        $('#code').val(code);
    }

    function UpdateTransaction(id, code, customerId, note) {
        var transactionDetailInput = document.getElementById('transactionDetail');
        transactionDetailInput.value = note;
        $('#transactionTypeModal').modal();
        $('#id').val(id);
        $('#customerId').val(customerId);
        $('#code').val(code);
    }


    $('#btnAddOrUpdateTransaction').click(function (e) {
        e.preventDefault();
        var data = {};
        data['id'] = $('#id').val();
        data['customerId'] = $('#customerId').val();
        data['code'] = $('#code').val();
        data['transactionDetail'] = $('#transactionDetail').val();
        addTransaction(data);

    });

    function addTransaction(data) {
        $.ajax({
            type: 'POST',
            url: "/api/customer/transaction",
            data: JSON.stringify(data),
            contentType: 'application/json',
            //  dataType: 'json',
            success: function (response) {
                console.log("API Response:", response);
                window.location.href = "/admin/customer-list";


            },
            error: function (xhr, status, error) {
                console.log("error")
            }
        });
    }

    $(document).ready(function () {
        $('#btnAddOrUpdateCustomer').click(function () {
            var data = {};
            var formData = $('#listForm').serializeArray();
            $.each(formData, function (i, v) {

                data[v.name] = v.value;


            });

            // Call the API
            if (data != "") {
                addOrUpdateCustomer(data);
            } else {

                window.location.href = "<c:url value = "/admin/customer-edit?typeCode=require" />";
            }

        });
    });

    function addOrUpdateCustomer(data) {
        $.ajax({
            type: 'POST',
            url: "/api/customer",
            data: JSON.stringify(data),
            contentType: 'application/json',
            //  dataType: 'json',
            success: function (response) {
                console.log("API Response:", response);
                window.location.href = "/admin/customer-list";


            },
            error: function (xhr, status, error) {
                console.log("error")
            }
        });
    }

    $("#btnCancel").click(function () {
        window.location.href = "/admin/customer-list";

    });


    $("#cancelBtn").click(function () {
        showAlertBeforeCancelForm(function () {
            window.location.href = '/admin/customer-list';
        })
    });


</script>
</body>
</html>